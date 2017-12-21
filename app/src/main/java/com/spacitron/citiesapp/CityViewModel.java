package com.spacitron.citiesapp;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.Observable;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableMap;
import android.support.v4.util.Pair;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.spacitron.citiesapp.utils.OnItemSelectedListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CityViewModel extends ViewModel implements OnItemSelectedListener<City>{

    // Empty key - corresponding to an empty string - this will be used to mark the initial
    //cache containing the complete, unfiltered list of cities.
    public static final String EMPTY_KEY = new String();

    public final ObservableBoolean isLoading;
    public final ObservableField<String> filter;
    public final ObservableField<City> selectedCity;
    public final ObservableMap<String, List<City>> filteredCitiesMap;

    private Map<Character, Pair<Integer, Integer>> alphabeticalCityIndex;
    private final ExecutorService worker = Executors.newFixedThreadPool(5);


    public CityViewModel() {
        isLoading = new ObservableBoolean();

        filter = new ObservableField<>();
        filter.set(EMPTY_KEY);

        filteredCitiesMap = new ObservableArrayMap<>();
        selectedCity = new ObservableField<>();
    }

    public void init(final Context context) {
        // This should not be stopped until it completes so use a throwaway thread when first subscribing
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    // Get the InputStream here so you don't need to pass context to other methods
                    makeSortedCitiesFromInputStream(context.getAssets().open("cities_test.json"));
                    alphabeticalCityIndex = getAlphabeticalCityIndex(filteredCitiesMap.get(EMPTY_KEY));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    protected Map<Character, Pair<Integer, Integer>> getAlphabeticalCityIndex(final List<City> indexableCities){

        Character firstLetter = null;
        int startIndex = 0;

        final Map<Character, Pair<Integer, Integer>> alphabeticalIndex = new HashMap<>();

        for (City indexableCity : indexableCities) {

            char indexableCharacter = indexableCity.getLowerCaseDisplayName().charAt(0);

            if (firstLetter == null) {
                firstLetter = indexableCharacter;

            } else if (!firstLetter.equals(indexableCharacter)) {
                alphabeticalIndex.put(firstLetter, new Pair<>(startIndex, indexableCities.indexOf(indexableCity)));
                firstLetter = indexableCharacter;
                startIndex = indexableCities.indexOf(indexableCity);
            }

            // Doesn't feel right to do this here but I certainly also
            // don't want to loop all the cities again
            indexableCity.itemSelectedListener = this;
        }
        return alphabeticalIndex;
    }

    /**
     * Expose functionality separately so this can be calles synchronously in tests
     */
    protected void makeSortedCitiesFromInputStream(final InputStream inputStream) {

        //Store the full list with the default empty key
        filteredCitiesMap.put(EMPTY_KEY, sortCities(parseCities(inputStream)));

        //Then check if a filter has already been set while the data was loading
        performFilteringStrategy();


        // This filters the city entries as the filter text changes.
        filter.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {

                worker.submit(new Runnable() {
                    @Override
                    public void run() {
                        performFilteringStrategy();
                    }
                });
            }
        });
    }

    protected void performFilteringStrategy(){
        // First things first, make the filter text lowercase
        String filterText = filter.get().toLowerCase();

        // Next, caches whose name does not start with the current filter text may
        // should be cleaned-up as they are not relevant right now and we don't want
        // these to grow infinitely
        for (String mapKey : filteredCitiesMap.keySet()) {
            if (!filterText.startsWith(mapKey)) {
                filteredCitiesMap.remove(mapKey);
            }
        }

        // Of course, if the map that already contains the appropriate sublist then
        // we don't need to do anything. This will happen when the user deletes characters
        // from the search box.
        if (filteredCitiesMap.containsKey(filter.get())) {
            return;
        }

        // Next, when the filter text contains a single character, the alphabetical index
        // can tell us the indexes of the sublist containing cities starting with that character.
        if (filterText.length() == 1 && alphabeticalCityIndex!=null) {
            char filterChar = filterText.charAt(0);
            //If there's only one charcater and that's not in the index then it's clearly
            // not in the list either. In that case return an empty array and exit.
            if(!alphabeticalCityIndex.containsKey(filterChar)){
                filteredCitiesMap.put(filterText, new ArrayList<City>());
                return;
            }

            Pair<Integer, Integer> alphabeticalIndex = alphabeticalCityIndex.get(filterChar);
            filteredCitiesMap.put(filterText, filteredCitiesMap.get(EMPTY_KEY).subList(alphabeticalIndex.first, alphabeticalIndex.second));
            return;
        }


        // Finally, if you still haven't found anything, take the smallest list you can find that
        // contains the cities you need - there must be a cache named after the text in the previous search by now - and filter that.
        if (!filterText.isEmpty()) {
            for (String mapKey : filteredCitiesMap.keySet()) {
                if (!mapKey.isEmpty() && filterText.startsWith(mapKey)) {
                    filteredCitiesMap.put(filterText, filterCitiesByStartingString(filterText, filteredCitiesMap.get(mapKey)));
                    return;
                }
            }
        }

        //If all else fails then parse the whole list. This will happen if the user types more than one
        //character at once, for example by copypasting text from elsewhere.
        filteredCitiesMap.put(filterText, filterCitiesByStartingString(filterText, filteredCitiesMap.get(EMPTY_KEY)));
    }

    protected List<City> filterCitiesByStartingString(String filterString, List<City> cities) {

        //If we have nothing to filter with there's we can stop here
        if (filterString == null || filterString.isEmpty() || cities.isEmpty()) {
            return cities;
        }

        List<City> result = new ArrayList<>();

        //Keep track of when you start matching so you can break out of the
        //loop as soon as that's done to save cycles.
        boolean filterStarted = false;

        for (City city : cities) {

            //As this will is managed by a worker thread make sure you stop executing if the work is no longer needed.
            if (Thread.interrupted()) {
                break;
            }
            if (city.getLowerCaseDisplayName().startsWith(filterString.toLowerCase())) {
                result.add(city);
                if(!filterStarted){
                    filterStarted = true;
                }
            }else if(filterStarted){
                break;
            }
        }
        return result;
    }

    protected List<City> parseCities(final InputStream inputStream) {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        final List<City> result = new GsonBuilder()
                .create()
                .fromJson(reader, new TypeToken<List<City>>() {
                }.getType());

        // There may be null entries at the end of this. Make sure those are removed.
        result.removeAll(Collections.singleton(null));

        try {
            reader.close();
        } catch (IOException e) {
        }

        return result;
    }


    protected List<City> sortCities(final List<City> cities) {
        Collections.sort(cities, new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return o1.getLowerCaseDisplayName().compareTo(o2.getLowerCaseDisplayName());
            }
        });

        return cities;
    }

    @Override
    public void onItemSelected(City obj) {
        if(selectedCity.get()!=null && selectedCity.get().equals(obj)){
            // Do this to ensure the observers know a new selection
            // has been made even when the city didn't change
            selectedCity.notifyChange();
        }
        selectedCity.set(obj);
    }
}

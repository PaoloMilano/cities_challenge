package com.spacitron.citiesapp.cityviewmodel;

import android.support.v4.util.Pair;

import com.spacitron.citiesapp.citymodel.City;
import com.spacitron.citiesapp.utils.Callback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;


public class CityFilterHelper {

    // Empty key - corresponding to an empty string - this will be used to mark the initial
    //cache containing the complete, unfiltered list of cities.
    public static final String EMPTY_KEY = new String();

    private final Map<Character, Pair<Integer, Integer>> alphabeticalCityIndex;
    private final Map<String, List<City>> filteredCitiesMap;


    final ExecutorService executor;


    public CityFilterHelper(final List<City> allCities, final ExecutorService executor) {
        this.executor = executor;
        filteredCitiesMap = new HashMap<>();
        filteredCitiesMap.put(EMPTY_KEY, allCities);
        alphabeticalCityIndex = getAlphabeticalCityIndex(allCities);
    }

    void getFilteredCities(final String filter, final Callback<City> callback){

        executor.submit(new Runnable() {
            @Override
            public void run() {
                callback.onSuccess(filteredCities(filter));
            }
        });
    }

    protected List<City> filteredCities(String filter) {

        // First things first, make the filter text lowercase
        filter = filter.toLowerCase();

        // Next, caches whose name does not start with the current filter text
        // should be cleaned-up as they are not relevant right now and we don't want
        // these to grow infinitely. Extract the keys to a list first and remove them later
        // to avoid concurrent mod exception
        List<String> redundantKeys = new ArrayList<>();
        for (String mapKey : filteredCitiesMap.keySet()) {
            if (!filter.startsWith(mapKey)) {
                redundantKeys.add(mapKey);
            }
        }
        for(final String redundantKey: redundantKeys){
            filteredCitiesMap.remove(redundantKey);
        }

        // Of course, if the map that already contains the appropriate sublist then
        // we don't need to do anything. This will happen when the user deletes characters
        // from the search box.
        if (filteredCitiesMap.containsKey(filter)) {
            return filteredCitiesMap.get(filter);
        }

        // Next, when the filter text contains a single character, the alphabetical index
        // can tell us the indexes of the sublist containing cities starting with that character.
        if (filter.length() == 1 && alphabeticalCityIndex != null) {

            char filterChar = filter.charAt(0);

            //If there's only one character and that's not in the index then it's clearly
            // not in the list either. In that case return an empty array and exit.
            if (!alphabeticalCityIndex.containsKey(filterChar)) {
                filteredCitiesMap.put(filter, new ArrayList<City>());
                return filteredCitiesMap.get(filter);
            }

            Pair<Integer, Integer> alphabeticalIndex = alphabeticalCityIndex.get(filterChar);
            filteredCitiesMap.put(filter, filteredCitiesMap.get(EMPTY_KEY).subList(alphabeticalIndex.first, alphabeticalIndex.second));
            return filteredCitiesMap.get(filter);
        }


        // Finally, if you still haven't found anything, take the smallest list you can find that
        // contains the cities you need - there must be a cache named after the text in the previous search by now - and filter that.
        if (!filter.isEmpty()) {
            for (String mapKey : filteredCitiesMap.keySet()) {
                if (!mapKey.isEmpty() && filter.startsWith(mapKey)) {
                    filteredCitiesMap.put(filter, filterCitiesByStartingString(filter, filteredCitiesMap.get(mapKey)));
                    return filteredCitiesMap.get(filter);
                }
            }
        }

        // This will execute if the user types more than one character at once,
        // in the empty field. In that case we must still have an index for the first characted
        // of the sequence so we can use that to speedup filtering;
        final char filterInitial = filter.charAt(0);
        if (alphabeticalCityIndex.containsKey(filterInitial)) {

            final Pair<Integer, Integer> alphabeticalIndex = alphabeticalCityIndex.get(filterInitial);
            filteredCitiesMap.put(filter, filterCitiesByStartingString(filter, filteredCitiesMap.get(EMPTY_KEY).subList(alphabeticalIndex.first, alphabeticalIndex.second)));

        } else {

            // Finally if nothing was found return an empty list
            filteredCitiesMap.put(filter, new ArrayList<City>());

        }
        return filteredCitiesMap.get(filter);
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
            if (city.getDisplayName().toLowerCase().startsWith(filterString.toLowerCase())) {
                result.add(city);
                if (!filterStarted) {
                    filterStarted = true;
                }
            } else if (filterStarted) {
                break;
            }
        }
        return result;
    }

    protected Map<Character, Pair<Integer, Integer>> getAlphabeticalCityIndex(final List<City> indexableCities) {

        Character firstLetter = null;
        int startIndex = 0;

        final Map<Character, Pair<Integer, Integer>> alphabeticalIndex = new HashMap<>();

        for (City indexableCity : indexableCities) {

            char indexableCharacter = indexableCity.getDisplayName().toLowerCase().charAt(0);

            if (firstLetter == null) {
                firstLetter = indexableCharacter;

            } else if (!firstLetter.equals(indexableCharacter)) {
                alphabeticalIndex.put(firstLetter, new Pair<>(startIndex, indexableCities.indexOf(indexableCity)));
                firstLetter = indexableCharacter;
                startIndex = indexableCities.indexOf(indexableCity);
            }
        }
        return alphabeticalIndex;
    }


    void cancel() {

    }
}

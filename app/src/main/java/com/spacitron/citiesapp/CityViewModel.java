package com.spacitron.citiesapp;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.Observable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class CityViewModel extends ViewModel {

    private final ArrayList<FilterableCity> citiesCache;
    private String lastFilterString;

    public final ObservableBoolean isLoading;
    public final ObservableArrayList<FilterableCity> filteredCities;
    public final ObservableField<String> filter;

    private Future futureTask;
    private final ExecutorService worker = Executors.newSingleThreadExecutor();


    public CityViewModel() {
        isLoading = new ObservableBoolean();
        filteredCities = new ObservableArrayList<>();
        filter = new ObservableField<>();
        citiesCache = new ArrayList<>();
        lastFilterString = new String();
    }

    public void init(final Context context) {
        // This should not be stopped until it completes so use a throwaway thread when first subscribing
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    // Get the InputStream here so you don't need to pass context to other methods
                    makeSortedCitiesFromInputStream(context.getAssets().open("cities.json"));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * Expose functionality separately so this can be calles synchronously in tests
     */
    protected void makeSortedCitiesFromInputStream(final InputStream inputStream) {

        //Store the full list in a local variable and set the initial state
        citiesCache.addAll(sortCities(parseCities(inputStream)));

        //Initialise filter parsing
        filteredCities.addAll(filterCities(filter.get(), citiesCache));
        filter.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {

                // If the user types faster than we can filter just stop the previous execution and start a new filter task
                if(futureTask!=null && !futureTask.isDone()) {
                    futureTask.cancel(true);
                }

                futureTask = worker.submit(new Runnable() {
                    @Override
                    public void run() {

                        final List<FilterableCity> filterableCities = filterCities(filter.get(), citiesCache);

                        //As this will is managed by a worker thread make sure you skip this
                        if(!Thread.interrupted()) {
                            filteredCities.clear();
                            filteredCities.addAll(filterableCities);
                        }
                    }
                });
            }
        });
    }


    protected List<FilterableCity> filterCities(String filterString, List<FilterableCity> cities) {

        //If we have nothing to filter with there's no point going any further
        if (filterString == null || filterString.isEmpty()) {
            return cities;
        }

        List<FilterableCity> result = new ArrayList<>();
        for (FilterableCity city : cities) {

            //As this will is managed by a worker thread make sure you stop executing if the work is no longer needed.
            if(Thread.interrupted()){
                break;
            }
            if (city.getDisplayName().toLowerCase().startsWith(filterString.toLowerCase())) {
                result.add(city);
            }
        }
        return result;
    }

    protected List<FilterableCity> parseCities(final InputStream inputStream) {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        final List<FilterableCity> result = new GsonBuilder()
                .create()
                .fromJson(reader, new TypeToken<List<FilterableCity>>() {
                }.getType());

        // There may be null entries at the end of this. Make sure those are removed.
        result.removeAll(Collections.singleton(null));

        try {
            reader.close();
        } catch (IOException e) {
        }

        return result;
    }


    protected List<FilterableCity> sortCities(final List<FilterableCity> cities) {
        Collections.sort(cities, new Comparator<FilterableCity>() {
            @Override
            public int compare(FilterableCity o1, FilterableCity o2) {
                return o1.getDisplayName().compareTo(o2.getDisplayName());
            }
        });

        return cities;
    }

    public class FilterableCity extends City {

        private String displayName;

        public String getDisplayName() {

            //Lazy compute property even though in this ViewModel it will be called almost immediately.
            if (displayName == null) {
                displayName = String.format("%s, %s", name, country);
            }
            return displayName;
        }

    }
}

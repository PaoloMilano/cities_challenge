package com.spacitron.citiesapp;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by paolo on 20/12/2017.
 */

public class CityViewModel extends ViewModel {

    ObservableBoolean isLoading;
    ObservableArrayList<FilterableCity> filteredCities;
    ObservableField<String> filter;

    ExecutorService service = Executors.newSingleThreadExecutor();


    public CityViewModel() {

    }

    public void subscribe(final Context context) {
        // This should not be stopped until it completes so use a throwaway thread when first subscribing
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    // Get the InputStream here so you don't need to pass context to other methods
                    parseCities(context.getAssets().open("cities.json"));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    protected List<FilterableCity> parseCities(final InputStream inputStream) {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        final List<FilterableCity> result = new GsonBuilder()
                .create()
                .fromJson(reader, new TypeToken<List<FilterableCity>>(){}.getType());

        // There may be null entries at the end of this. Make sure those are removed.
        result.removeAll(Collections.singleton(null));

        try {
            reader.close();
        } catch (IOException e) {}

        return result;
    }

    class FilterableCity extends City {
        public boolean isVisible() {
            return filter.get() == null || filter.get().isEmpty() || name.startsWith(filter.get());
        }
    }
}

package com.spacitron.citiesapp.citymodel;

import android.content.Context;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.spacitron.citiesapp.utils.Callback;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;


public class CityFetcher {

    private final Context context;

    private final String[] fileNames;

    public CityFetcher(final Context context, final String[] fileNames) {
        this.context = context;
        this.fileNames = fileNames;
    }


    public void getAllCities(final ExecutorService executor, final Callback<City> callback) {

        executor.submit(new Runnable() {
            @Override
            public void run() {

                final CountDownLatch doneSignal = new CountDownLatch(fileNames.length);
                final List<City> cities = new ArrayList<>();

                for (int i = 0; i < fileNames.length; i++) {

                    final String fileName  = fileNames[i];

                    executor.submit(new Runnable() {
                        @Override
                        public void run() {

                            try {
                                cities.addAll(parseCities(context.getAssets().open(fileName)));
                            } catch (IOException e) {
                                callback.onError(e);
                            }

                            doneSignal.countDown();
                        }
                    });
                }

                try {

                    doneSignal.await();

                } catch (InterruptedException e) {
                    callback.onError(e);
                }

                callback.onSuccess(sortCities(cities));
            }
        });
    }


    protected List<City> parseCities(final InputStream inputStream) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        final List<City> result = new GsonBuilder()
                .create()
                .fromJson(reader, new TypeToken<List<City>>() {
                }.getType());

        // There may be null entries at the end of this. Make sure those are removed.
        result.removeAll(Collections.singleton(null));

        reader.close();

        return result;
    }


    protected List<City> sortCities(final List<City> cities) {

        cities.removeAll(Collections.singleton(null));

        Collections.sort(cities, new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return o1.getDisplayName().toLowerCase().compareTo(o2.getDisplayName().toLowerCase());
            }
        });

        return cities;
    }
}

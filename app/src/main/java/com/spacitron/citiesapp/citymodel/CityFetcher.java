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
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CityFetcher {

    private final Context context;
    private  CityFilterHelper cityFilter;
    private final String[] fileNames;
    private final ExecutorService executor;

    public CityFetcher(final Context context, final String[] fileNames) {
        this.context = context;
        this.fileNames = fileNames;

        this.executor = Executors.newFixedThreadPool(10);
    }


    public void getFilteredCities(final String filter, final Callback<City> callback) {

        if (cityFilter ==  null) {
            getAllCities(new Callback<City>() {
                @Override
                public void onSuccess(List<City> result) {

                    cityFilter = new CityFilterHelper(result);
                    callback.onSuccess(cityFilter.getFilteredCities(filter));

                }

                @Override
                public void onError(Throwable t) {
                    callback.onError(t);
                }
            });

        } else {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    callback.onSuccess(cityFilter.getFilteredCities(filter));
                }
            });
        }
    }

    protected void getAllCities(final Callback<City> callback) {

        executor.submit(new Runnable() {
            @Override
            public void run() {

                final CountDownLatch doneSignal = new CountDownLatch(fileNames.length);
                final List<City> cities = new ArrayList<>();

                for (int i = 0; i < fileNames.length; i++) {

                    final String fileName = fileNames[i];

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

                callback.onSuccess(cities);
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

    public void cancel(){
        executor.shutdownNow();
    }
}

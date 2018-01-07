package com.spacitron.citiesapp;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.spacitron.citiesapp.citymodel.City;
import com.spacitron.citiesapp.citymodel.CityFetcher;
import com.spacitron.citiesapp.utils.Callback;
import com.spacitron.citiesapp.utils.FilesListConfig;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;


@RunWith(AndroidJUnit4.class)
public class CityDataFetcherPerformanceTest {

    private ExecutorService executorService = Executors.newFixedThreadPool(10);
    private boolean parsed;

    @Test
    public void parseCitiesTest() {

        //Parse the single file
        long linearTimeStart = System.currentTimeMillis();
        final List<City> linearCities = getCities(FilesListConfig.READABLE_FULL_JSON_FILE);
        long linearTimeEnd = System.currentTimeMillis();

        //Parse the multiple sub-files in parallel
        long parallelTimeStart = System.currentTimeMillis();
        final List<City> parallelCities = getCities(FilesListConfig.READABLE_JSON_FILES);
        long parallelTimeEnd = System.currentTimeMillis();


        assertEquals(parallelCities.size(), linearCities.size());

        for (int i = 0; i < linearCities.size(); i++) {
            assertEquals(parallelCities.get(i).getDisplayName(), linearCities.get(i).getDisplayName());
        }

        //If both are equal make sure that the performance is better when we go parallel
        long parallelTimeTotal = (parallelTimeEnd - parallelTimeStart);
        long linearTimeTotal = (linearTimeEnd - linearTimeStart);
        assertTrue(parallelTimeTotal < linearTimeTotal);

    }

    class TestyCityFetcher extends CityFetcher {

        public TestyCityFetcher(String... fileNames) {
            super(InstrumentationRegistry.getTargetContext(), fileNames);
        }

        @Override
        public void getAllCities(ExecutorService executor, Callback<City> callback) {
            super.getAllCities(executor, callback);
        }
    }

    List<City> getCities(String ... files){
        parsed = false;
        final List<City> cities = new ArrayList<>();
        new TestyCityFetcher(files).getAllCities(executorService, new Callback<City>() {
            @Override
            public void onSuccess(List<City> result) {
                cities.addAll(result);
                parsed = true;
            }

            @Override
            public void onError(Throwable t) {
                fail(t.getMessage());
            }
        });

        while (!parsed) {
        }

        return cities;

    }
}

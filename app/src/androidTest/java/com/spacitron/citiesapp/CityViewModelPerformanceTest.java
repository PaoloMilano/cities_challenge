package com.spacitron.citiesapp;

import android.databinding.ObservableMap;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.spacitron.citiesapp.utils.FilesListConfig;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;


@RunWith(AndroidJUnit4.class)
public class CityViewModelPerformanceTest {
    @Test
    public void parseCitiesTest() {

        //Parse the file linearly
        CityViewModel linearCityViewModel = new CityViewModel();
        long linearTimeStart = System.currentTimeMillis();
        try {
            linearCityViewModel.makeSortedCitiesFromInputStreams(InstrumentationRegistry.getTargetContext().getAssets().open(FilesListConfig.READABLE_FULL_JSON_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
        long linearTimeEnd = System.currentTimeMillis();


        //Prepare the input streams
        InputStream[] parallelStreams = new InputStream[FilesListConfig.READABLE_JSON_FILES.length];
        for (int i = 0; i < FilesListConfig.READABLE_JSON_FILES.length; i++) {
            try {
                parallelStreams[i] = InstrumentationRegistry.getTargetContext().getAssets().open(FilesListConfig.READABLE_JSON_FILES[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //Start parsing the data in parallel
        CityViewModel parallelCityViewModel = new CityViewModel();
        long parallelTimeStart = System.currentTimeMillis();
        parallelCityViewModel.makeSortedCitiesFromInputStreams(parallelStreams);
        long parallelTimeEnd = System.currentTimeMillis();

        //Now, first let's make sure that they contain the exact same data
        List<City> linearCities = linearCityViewModel.filteredCitiesMap.get(CityViewModel.EMPTY_KEY);
        List<City> parallelCities = parallelCityViewModel.filteredCitiesMap.get(CityViewModel.EMPTY_KEY);

        assertEquals(parallelCities.size(), linearCities.size());

        for (int i = 0; i < linearCities.size(); i++) {
            assertEquals(parallelCities.get(i).getDisplayName(), linearCities.get(i).getDisplayName());
        }

        //If both are equal make sure that the performance is better when we go parallel
        long parallelTimeTotal = (parallelTimeEnd-parallelTimeStart);
        long linearTimeTotal = (linearTimeEnd-linearTimeStart);
        assertTrue(parallelTimeTotal < linearTimeTotal);

    }


    @Test
    public void filterCitiesWithIndexTest() {

        //We need quite a bit of data to make this test meaningful. The sample won't do.
        InputStream[] inputStreams = new InputStream[FilesListConfig.READABLE_JSON_FILES.length];
        for (int i = 0; i < FilesListConfig.READABLE_JSON_FILES.length; i++) {
            try {
                inputStreams[i] = InstrumentationRegistry.getTargetContext().getAssets().open(FilesListConfig.READABLE_JSON_FILES[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //Parepare the viewModel
        CityViewModel cityViewModel = new CityViewModel();
        cityViewModel.makeSortedCitiesFromInputStreams(inputStreams);

        // The code above should have built the index before
        // returning so check to make sure it's there
        assertFalse(cityViewModel.alphabeticalCityIndex.isEmpty());


        // Filtering happens asynchronousely so we need a way to find out when a new cache is generated
        TestCallBack testCallBack = new TestCallBack();
        cityViewModel.filteredCitiesMap.addOnMapChangedCallback(testCallBack);

        //Filter
        long indexedTimeStart = System.nanoTime();
        cityViewModel.filter.set("m");

        // Wait for the filter to be applied
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long indexedTimeEnd = testCallBack.time;


        // Force clear the cache
        cityViewModel.filter.set("");

        // Wait to finish
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(cityViewModel.filteredCitiesMap.size() == 1);

        // Clear the index
        cityViewModel.alphabeticalCityIndex.clear();
        assertTrue(cityViewModel.alphabeticalCityIndex.isEmpty());


        // Now filter without index
        long unindexedTimeStart = System.nanoTime();
        cityViewModel.filter.set("m");

        // Wait for the filter to be applied
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long unindexedTimeEnd = testCallBack.time;

        long unindexedTime = unindexedTimeEnd - unindexedTimeStart;
        long indexedTime = indexedTimeEnd - indexedTimeStart;

        assertTrue(unindexedTime > indexedTime);

    }


    static class TestCallBack extends ObservableMap.OnMapChangedCallback {

        public long time = 0l;

        @Override
        public void onMapChanged(ObservableMap observableMap, Object o) {
            time = System.nanoTime();

        }
    }

}

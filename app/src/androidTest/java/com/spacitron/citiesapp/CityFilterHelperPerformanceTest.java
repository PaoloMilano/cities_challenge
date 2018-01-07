package com.spacitron.citiesapp;

import android.databinding.ObservableMap;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.util.Pair;

import com.spacitron.citiesapp.citymodel.City;
import com.spacitron.citiesapp.cityviewmodel.CityFilterHelper;
import com.spacitron.citiesapp.utils.FilesListConfig;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;


@RunWith(AndroidJUnit4.class)
public class CityFilterHelperPerformanceTest {


    @Test
    public void filterCitiesWithIndexTest() {

        List<City> indexedCities = new ArrayList<>();
        List<City> unindexedCities = new ArrayList<>();

        List<City> testCities = new CityDataFetcherPerformanceTest().getCities(FilesListConfig.READABLE_JSON_FILES);

        // Make a number of filters we can use to exercise the filter function. Avoid single characters
        // or the unindexed filter will not work as expected
        String [] testFilters = new String[]{"mo", "pol", "de", "ngtf", "we", "ba", "pew", "ka", "was", "zas"};



        //We need quite a bit of data to make this test meaningful. The sample won't do so parse all the cities.
        IndexedFilterHelper indexedFilterHelper = new IndexedFilterHelper(testCities);

        //Time how long it takes to run all the filters with an index
        long indexedTimeStart = System.currentTimeMillis();
        for(String filter: testFilters) {
            indexedCities.addAll(indexedFilterHelper.filteredCities(filter));
        }
        long indexedTimeEnd = System.currentTimeMillis();



        //We need quite a bit of data to make this test meaningful. The sample won't do so parse all the cities.
        UnindexedFilterHelper unindexedFilterHelper = new UnindexedFilterHelper(testCities);

        //Time how long it takes to run all the filters with an index
        long unindexedTimeStart = System.currentTimeMillis();
        for(String filter: testFilters) {
            unindexedCities.addAll(unindexedFilterHelper.filteredCities(filter));
        }
        long unindexedTimeEnd = System.currentTimeMillis();


        //First control that you got the same results whether you used an index or not
        assertEquals(unindexedCities.size(), indexedCities.size());
        for(int i = 0; i< unindexedCities.size(); i++){
            unindexedCities.get(i).getDisplayName().equals(indexedCities.get(i).getDisplayName());
        }

        //Now ensure that the indexed times were actually faster
        long unindexedTime = unindexedTimeEnd - unindexedTimeStart;
        long indexedTime = indexedTimeEnd - indexedTimeStart;

        assertTrue(unindexedTime > indexedTime);

    }


    class IndexedFilterHelper extends CityFilterHelper {

        public IndexedFilterHelper(List<City> allCities) {
            super(allCities, null);
        }

        @Override
        protected List<City> filteredCities(String filter) {
            return super.filteredCities(filter);
        }
    }


    class UnindexedFilterHelper extends CityFilterHelper {

        public UnindexedFilterHelper(List<City> allCities) {
            super(allCities, null);
        }


        //Returns an  index that gives the whole list for every query, forcing
        // the filter function to loop through the whole list as if the index didn't exist
        @Override
        protected Map<Character, Pair<Integer, Integer>> getAlphabeticalCityIndex(List<City> indexableCities) {
            Map<Character, Pair<Integer, Integer>> index = super.getAlphabeticalCityIndex(indexableCities);
            for(Character key: index.keySet()){
                index.put(key, new Pair<Integer, Integer>(0, indexableCities.size()));
            }
            return index;
        }

        @Override
        protected List<City> filteredCities(String filter) {
            return super.filteredCities(filter);
        }
    }


    static class TestCallBack extends ObservableMap.OnMapChangedCallback {

        public long time = 0l;

        @Override
        public void onMapChanged(ObservableMap observableMap, Object o) {
            time = System.nanoTime();

        }
    }

}

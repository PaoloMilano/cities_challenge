package com.spacitron.citiesapp;

import android.support.v4.util.Pair;

import com.spacitron.citiesapp.citymodel.City;
import com.spacitron.citiesapp.cityviewmodel.CityFilterHelper;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;


public class CityFilterHelperTest {

    @Test
    public void getAlphabeticalIndexTest() {

        TestyFilterHelper filterHelper = new TestyFilterHelper(new ArrayList<City>());
        Map<Character, Pair<Integer, Integer>> citiesIndex = filterHelper.getAlphabeticalCityIndex(CityData.getCities());

        //There should be 3 'a' entries between 1 and 4
        assertTrue(citiesIndex.get('a').first == 1);
        assertTrue(citiesIndex.get('a').second == 4);

        //There should be 2 'k'
        assertEquals(2, citiesIndex.get('k').second - citiesIndex.get('k').first);
    }

    @Test
    public void filterCitiesTest() {

        TestyFilterHelper filterHelper = new TestyFilterHelper(CityData.getCities());

        assertEquals(3, filterHelper.filteredCities("las").size());
        assertEquals(2, filterHelper.filteredCities("lass").size());

        List<City> filteredCityList = filterHelper.filteredCities("lasss");
        assertEquals(1, filteredCityList.size());
        assertEquals("Lassspi", filteredCityList.get(0).name);

        //Case shouldn't matter
        assertEquals(3, filterHelper.filteredCities("LAS").size());
        assertEquals(2, filterHelper.filteredCities("LaSS").size());

        //Empty for non-matching word
        assertEquals(0, filterHelper.filteredCities("bs65uyvt567gu").size());
    }

    class TestyFilterHelper extends CityFilterHelper {

        public TestyFilterHelper(List<City> allCities) {
            super(allCities, null);
        }

        @Override
        protected List<City> filteredCities(String filter) {
            return super.filteredCities(filter);
        }

        @Override
        protected Map<Character, Pair<Integer, Integer>> getAlphabeticalCityIndex(List<City> indexableCities) {
            return super.getAlphabeticalCityIndex(indexableCities);
        }
    }
}

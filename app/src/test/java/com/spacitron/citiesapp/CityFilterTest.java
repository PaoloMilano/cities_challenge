package com.spacitron.citiesapp;

import com.spacitron.citiesapp.citymodel.City;
import com.spacitron.citiesapp.citymodel.CityFilterHelper;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class CityFilterTest {

    @Test
    public void compareFilterResultsTest() {

        String[] filters = new String[]{"a", "al", "alo", "p", "po",
                "pow", "qoea", "qoeai", "p", "po", "pope", "does",
                "b", "biant", "ci", "cie", "ciers", "pqw", "cocs",
                "kom", "howm", "cers", "typ", "werer", "pwoers", "'loj",
                "gew", "qew", "qewr", "fife", "resq", "peraw", "hget"};


        List<City> cities = CityData.getLongCities();
        cities.addAll(CityData.getLongCities());
        cities.addAll(CityData.getLongCities());
        cities.addAll(CityData.getLongCities());
        cities.addAll(CityData.getLongCities());
        cities.addAll(CityData.getLongCities());
        cities.addAll(CityData.getLongCities());
        cities.addAll(CityData.getLongCities());
        cities.addAll(CityData.getLongCities());
        cities.addAll(CityData.getLongCities());
        cities.addAll(CityData.getLongCities());
        cities.addAll(CityData.getLongCities());
        cities.addAll(CityData.getLongCities());
        cities.addAll(CityData.getLongCities());
        cities.addAll(CityData.getLongCities());
        cities.addAll(CityData.getLongCities());

        // Order the cities alphabbetically to ensure the input will be the same
        // for the helper function as well as for the test helper method
        Collections.sort(cities, new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return o1.getDisplayName().toLowerCase().compareTo(o2.getDisplayName().toLowerCase());
            }
        });

        List<City> filterHelperCities = new ArrayList<>();
        List<City> simpleMethodCities = new ArrayList<>();


        long starTimeSimple = System.currentTimeMillis();
        for (String filter : filters) {
            simpleMethodCities.addAll(simpleGetAllCitiesByStartingString(filter, cities));
        }
        long endTimeSimple = System.currentTimeMillis();


        long startTimeHelper = System.currentTimeMillis();
        TestyCityFilterHelper indexedCityFilter = new TestyCityFilterHelper(cities);
        for (String filter : filters) {
            filterHelperCities.addAll(indexedCityFilter.getFilteredCities(filter));
        }
        long endTimeHelper = System.currentTimeMillis();


        //Ensure that they are equal
        assertEquals(filterHelperCities.size(), simpleMethodCities.size());
        for (int i = 0; i < filterHelperCities.size(); i++) {
            assertEquals(filterHelperCities.get(i).getDisplayName(), simpleMethodCities.get(i).getDisplayName());
        }

        long helperTime = endTimeHelper - startTimeHelper;
        long simpleTime = endTimeSimple - starTimeSimple;

        assertTrue(simpleTime > helperTime);

    }


    // Simple method to reliably return a list of cities by starting substring. This can be used to
    // compare against the results provided by the filter helper class.
    private List<City> simpleGetAllCitiesByStartingString(String filterString, List<City> cities) {

        List<City> result = new ArrayList<>();

        for (City city : cities) {

            if (city.getDisplayName().toLowerCase().startsWith(filterString.toLowerCase())) {
                result.add(city);
            }
        }
        return result;
    }


    class TestyCityFilterHelper extends CityFilterHelper {

        public TestyCityFilterHelper(List<City> filterableCities) {
            super(filterableCities);
        }

        @Override
        public List<City> getFilteredCities(String filter) {
            return super.getFilteredCities(filter);
        }
    }

}

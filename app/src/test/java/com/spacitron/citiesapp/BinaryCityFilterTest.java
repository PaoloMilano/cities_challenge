package com.spacitron.citiesapp;

import com.spacitron.citiesapp.citymodel.City;
import com.spacitron.citiesapp.citymodel.CityFilterHelper;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;


public class BinaryCityFilterTest {

    @Test
    public void getFirstMatchingIndexTest() {

        List<City> cityList = new ArrayList<>();

        {
            City city = new City();
            city.name = "abacus";
            cityList.add(city);
        }

        // Have a duplicate city so you cat test that you get the correct index for the first one
        {
            City city = new City();
            city.name = "abacus";
            cityList.add(city);
        }
        {
            City city = new City();
            city.name = "abacuse";
            cityList.add(city);
        }

        {
            City city = new City();
            city.name = "amacus";
            cityList.add(city);
        }
        {
            City city = new City();
            city.name = "bodes";
            cityList.add(city);
        }
        {
            City city = new City();
            city.name = "modose";
            cityList.add(city);
        }

        TestyBinaryCityFilterHelper binaryCityFilterHelper = new TestyBinaryCityFilterHelper(cityList);
        assertEquals(binaryCityFilterHelper.getStartingIndexForName("aba", cityList), 0);
        assertEquals(binaryCityFilterHelper.getStartingIndexForName("abacus", cityList), 0);
        assertEquals(binaryCityFilterHelper.getStartingIndexForName("amacus", cityList), 3);
        assertEquals(binaryCityFilterHelper.getStartingIndexForName("bodes", cityList), 4);
        assertEquals(binaryCityFilterHelper.getStartingIndexForName("modose", cityList), 5);

        // Remove 1 to ensure the function works both with even and odd list length
        cityList.remove(cityList.size()-1);

        assertEquals(binaryCityFilterHelper.getStartingIndexForName("aba", cityList), 0);
        assertEquals(binaryCityFilterHelper.getStartingIndexForName("abacus", cityList), 0);
        assertEquals(binaryCityFilterHelper.getStartingIndexForName("amacus", cityList), 3);
        assertEquals(binaryCityFilterHelper.getStartingIndexForName("bodes", cityList), 4);
    }


    @Test
    public void getLastMatchingIndexTest() {

        List<City> cityList = new ArrayList<>();

        {
            City city = new City();
            city.name = "abacus";
            cityList.add(city);
        }

        // Have a duplicate city so you cat test that you get the correct index for the first one
        {
            City city = new City();
            city.name = "abacus";
            cityList.add(city);
        }
        {
            City city = new City();
            city.name = "abacuse";
            cityList.add(city);
        }

        {
            City city = new City();
            city.name = "amacus";
            cityList.add(city);
        }
        {
            City city = new City();
            city.name = "bodes";
            cityList.add(city);
        }
        {
            City city = new City();
            city.name = "modose";
            cityList.add(city);
        }

        TestyBinaryCityFilterHelper binaryCityFilterHelper = new TestyBinaryCityFilterHelper(cityList);
        assertEquals(3, binaryCityFilterHelper.getEndingIndexForName("aba", cityList));
        assertEquals(3, binaryCityFilterHelper.getEndingIndexForName("abacus", cityList));
        assertEquals(4, binaryCityFilterHelper.getEndingIndexForName("amacus", cityList));
        assertEquals(5, binaryCityFilterHelper.getEndingIndexForName("bodes", cityList));
        assertEquals(6, binaryCityFilterHelper.getEndingIndexForName("modose", cityList));

        // Remove 1 to ensure the function works both with even and odd list length
        cityList.remove(cityList.size()-1);

        assertEquals(3, binaryCityFilterHelper.getEndingIndexForName("aba", cityList));
        assertEquals(3, binaryCityFilterHelper.getEndingIndexForName("abacus", cityList));
        assertEquals(4, binaryCityFilterHelper.getEndingIndexForName("amacus", cityList));
        assertEquals(5, binaryCityFilterHelper.getEndingIndexForName("bodes", cityList));
    }

    class TestyBinaryCityFilterHelper extends CityFilterHelper {

        public TestyBinaryCityFilterHelper(List<City> filterableCities) {
            super(filterableCities);
        }

        @Override
        protected int getStartingIndexForName(String cityNameSubstring, List<City> cities) {
            return super.getStartingIndexForName(cityNameSubstring, cities);
        }

        @Override
        protected int getEndingIndexForName(String cityNameSubstring, List<City> cities) {
            return super.getEndingIndexForName(cityNameSubstring, cities);
        }
    }
}

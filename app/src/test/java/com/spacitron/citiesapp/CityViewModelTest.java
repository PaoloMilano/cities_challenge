package com.spacitron.citiesapp;

import android.support.v4.util.Pair;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by paolo on 20/12/2017.
 */

public class CityViewModelTest {


    String cityData = "[" +
            "{\"country\":\"UA\",\"name\":\"Hurzuf\",\"_id\":707860,\"coord\":{\"lon\":34.283333,\"lat\":44.549999}}," +
            "{\"country\":\"UA\",\"name\":\"Alupka\",\"_id\":713514,\"coord\":{\"lon\":34.049999,\"lat\":44.416668}}," +

            //Fake country to see that the country is taken into consideration when sorting
            "{\"country\":\"AA\",\"name\":\"Alupka\",\"_id\":713514,\"coord\":{\"lon\":34.049999,\"lat\":44.416668}}," +

            //Lowercase to ensure that sorting is case insensitive amd indexes are built correctly
            "{\"country\":\"UA\",\"name\":\"alupka\",\"_id\":713514,\"coord\":{\"lon\":34.049999,\"lat\":44.416668}}," +
            "{\"country\":\"RU\",\"name\":\"Novinki\",\"_id\":519188,\"coord\":{\"lon\":37.666668,\"lat\":55.683334}}," +
            "{\"country\":\"NP\",\"name\":\"Gorkh\u0101\",\"_id\":1283378,\"coord\":{\"lon\":84.633331,\"lat\":28}}," +
            "{\"country\":\"IN\",\"name\":\"State of Hary\u0101na\",\"_id\":1270260,\"coord\":{\"lon\":76,\"lat\":29}}," +
            "{\"country\":\"UA\",\"name\":\"Holubynka\",\"_id\":708546,\"coord\":{\"lon\":33.900002,\"lat\":44.599998}}," +
            "{\"country\":\"NP\",\"name\":\"B\u0101gmat\u012B Zone\",\"_id\":1283710,\"coord\":{\"lon\":85.416664,\"lat\":28}}," +
            "{\"country\":\"RU\",\"name\":\"Mar\u2019ina Roshcha\",\"_id\":529334,\"coord\":{\"lon\":37.611111,\"lat\":55.796391}}," +
            "{\"country\":\"IN\",\"name\":\"Republic of India\",\"_id\":1269750,\"coord\":{\"lon\":77,\"lat\":20}}," +
            "{\"country\":\"NP\",\"name\":\"Kathmandu\",\"_id\":1283240,\"coord\":{\"lon\":85.316666,\"lat\":27.716667}}," +
            "{\"country\":\"NP\",\"name\":\"kathmandu\",\"_id\":1283240,\"coord\":{\"lon\":85.316666,\"lat\":27.716667}}," +

            // These following three are used to test filtering
            "{\"country\":\"UA\",\"name\":\"Laspi\",\"_id\":703363,\"coord\":{\"lon\":33.733334,\"lat\":44.416668}}," +
            "{\"country\":\"UA\",\"name\":\"Lasspi\",\"_id\":703363,\"coord\":{\"lon\":33.733334,\"lat\":44.416668}}," +
            "{\"country\":\"UA\",\"name\":\"Lassspi\",\"_id\":703363,\"coord\":{\"lon\":33.733334,\"lat\":44.416668}}," +

            "{\"country\":\"IQ\",\"name\":\"Qarah Gawl al \u2018Uly\u0101\",\"_id\":384848,\"coord\":{\"lon\":45.6325,\"lat\":35.353889}}," +
            "{\"country\":\"RU\",\"name\":\"Zavety Il\u2019icha\",\"_id\":464176,\"coord\":{\"lon\":37.849998,\"lat\":56.049999}}," +
            "{\"country\":\"IL\",\"name\":\"\u2018Azriqam\",\"_id\":295582,\"coord\":{\"lon\":34.700001,\"lat\":31.75}}," +
            "{\"country\":\"UA\",\"name\":\"Tyuzler\",\"_id\":690856,\"coord\":{\"lon\":34.083332,\"lat\":44.466667}}," +
            "{\"country\":\"RU\",\"name\":\"Zaponor\u2019ye\",\"_id\":464737,\"coord\":{\"lon\":38.861942,\"lat\":55.639999}}," +
            "{\"country\":\"UA\",\"name\":\"Il\u2019ich\u00EBvka\",\"_id\":707716,\"coord\":{\"lon\":34.383331,\"lat\":44.666668}}," +
            "]";


    @Test
    public void parseCitiesTest() {

        CityViewModel cityViewModel = new CityViewModel();
        List<City> cities = cityViewModel.parseCities(new ByteArrayInputStream(cityData.getBytes()));

        assertEquals(22, cities.size());

        assertEquals("Hurzuf", cities.get(0).name);
        assertEquals(34.283333, cities.get(0).coord.lon);
        assertEquals(44.549999, cities.get(0).coord.lat);


        assertEquals("Il\u2019ich\u00EBvka", cities.get(cities.size() - 1).name);
        assertEquals(34.383331, cities.get(cities.size() - 1).coord.lon);
        assertEquals(44.666668, cities.get(cities.size() - 1).coord.lat);

    }

    @Test
    public void sortCitiesTest() {

        CityViewModel cityViewModel = new CityViewModel();
        List<City> cities = cityViewModel.parseCities(new ByteArrayInputStream(cityData.getBytes()));
        cities = cityViewModel.sortCities(cities);


        City city = cities.get(cities.size() - 1);
        assertEquals("alupka", cities.get(0).name.toLowerCase());
        assertEquals("AA", cities.get(0).country);

        assertEquals("alupka", cities.get(1).name.toLowerCase());
        assertEquals("UA", cities.get(1).country);

        assertEquals("\u2018Azriqam", cities.get(cities.size() - 1).name);
    }

    @Test
    public void filterCitiesTest() {
        CityViewModel cityViewModel = new CityViewModel();
        cityViewModel.makeSortedCitiesFromInputStream(new ByteArrayInputStream(cityData.getBytes()));

        //Because filtering happens on a separate thread we need to give it some time to complete
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(3, cityViewModel.filterCities("las", cityViewModel.citiesCache).size());
        assertEquals(2, cityViewModel.filterCities("lass",  cityViewModel.citiesCache).size());

        List<City> filteredCityList = cityViewModel.filterCities("lasss",  cityViewModel.citiesCache);
        assertEquals(1, filteredCityList.size());
        assertEquals("Lassspi", filteredCityList.get(0).name);

        //Case shouldn't matter
        assertEquals(3, cityViewModel.filterCities("LAS",  cityViewModel.citiesCache).size());
        assertEquals(2, cityViewModel.filterCities("LaSS",  cityViewModel.citiesCache).size());

        //Empty for non-matching word
        assertEquals(0, cityViewModel.filterCities("bs65uyvt567gu",  cityViewModel.citiesCache).size());
    }

    //This test ensures that the various parts of the filtering mechanism work together
    @Test
    public void integrationFilterCitiesTest() {
        CityViewModel cityViewModel = new CityViewModel();
        cityViewModel.makeSortedCitiesFromInputStream(new ByteArrayInputStream(cityData.getBytes()));

        cityViewModel.filter.set("Lasss");

        //Because filtering happens on a separate thread we need to give it some time to complete
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Note that map keys are lower case
        assertEquals(1, cityViewModel.filteredCitiesMap.get("lasss").size());
        assertEquals("Lassspi", cityViewModel.filteredCitiesMap.get("lasss").get(0).name);

        //Ensure that the list is repopulated when we delete characters
        cityViewModel.filter.set("Las");

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(3, cityViewModel.filteredCitiesMap.get("las").size());
    }


    @Test
    public void filterableCityGetNameTest() {
        CityViewModel cityViewModel = new CityViewModel();
        City city = cityViewModel.parseCities(new ByteArrayInputStream(cityData.getBytes())).get(0);
        assertEquals(city.getDisplayName(), "Hurzuf, UA");
    }


    @Test
    public void buildAlphabeticalIndexTest(){
        CityViewModel cityViewModel = new CityViewModel();
        List<City> cities = cityViewModel.parseCities(new ByteArrayInputStream(cityData.getBytes()));
        Map<Character, Pair<Integer, Integer>> citiesIndex = cityViewModel.getAlphabeticalCityIndex(cities);

        //There should be 3 'a' entries between 1 and 4
        assertTrue(citiesIndex.get('a').first == 1);
        assertTrue(citiesIndex.get('a').second == 4);

        //There should be 2 'k'
        assertEquals(2, citiesIndex.get('k').second - citiesIndex.get('k').first);
    }
}

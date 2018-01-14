package com.spacitron.citiesapp;

import com.spacitron.citiesapp.citymodel.City;
import com.spacitron.citiesapp.citymodel.CityFetcher;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;


public class CityFetcherTest {



    @Test
    public void parseCitiesTest() {

        try {

            TestyCityFetcher cityFetcher = new TestyCityFetcher();
            List<City> cities = cityFetcher.parseCities(new ByteArrayInputStream(CityData.data.getBytes()));

            assertEquals(22, cities.size());

            assertEquals("Hurzuf", cities.get(0).name);
            assertEquals(34.283333, cities.get(0).coord.lon);
            assertEquals(44.549999, cities.get(0).coord.lat);


            assertEquals("Il\u2019ich\u00EBvka", cities.get(cities.size() - 1).name);
            assertEquals(34.383331, cities.get(cities.size() - 1).coord.lon);
            assertEquals(44.666668, cities.get(cities.size() - 1).coord.lat);

        } catch (IOException e) {

            fail(e.getMessage());
        }


    }

    class TestyCityFetcher extends CityFetcher {

        public TestyCityFetcher() {
            super(null, null);
        }

        @Override
        protected List<City> parseCities(InputStream inputStream) throws IOException {
            return super.parseCities(inputStream);
        }
    }
}

package com.spacitron.citiesapp;

import com.spacitron.citiesapp.citymodel.City;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class CityTest {

    @Test
    public void filterableCityGetNameTest() {
        City city = CityData.getCities().get(0);
        assertEquals(city.getDisplayName(), "Hurzuf, UA");
    }

}

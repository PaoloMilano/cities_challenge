package com.spacitron.citiesapp;

import android.databinding.Observable;

import com.spacitron.citiesapp.citymodel.City;
import com.spacitron.citiesapp.cityviewmodel.CityViewModel;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CityViewModelTest {


    @Test
    public void testItemSelectionWhenCityIsUnchanged() {
        CityViewModel cityViewModel = new CityViewModel();

        TestCallBack callback = new TestCallBack();

        cityViewModel.selectedCity.addOnPropertyChangedCallback(callback);

        City city = new City();
        city.name = "Philadelphia";
        city.country = "USA";
        city._id = -1;
        city.coord = new City.Coordinates();

        //First hit, the field should have been set
        cityViewModel.onItemSelected(city);
        assertEquals(1, callback.hitCounter);

        //Second hit, although the field should have not been set, observers
        // should have been notified regardless
        cityViewModel.onItemSelected(city);
        assertEquals(2, callback.hitCounter);
    }


    static class TestCallBack extends Observable.OnPropertyChangedCallback {

        public int hitCounter = 0;

        @Override
        public void onPropertyChanged(Observable observable, int i) {
            hitCounter++;
        }
    }
}

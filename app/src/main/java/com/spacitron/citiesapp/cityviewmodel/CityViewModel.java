package com.spacitron.citiesapp.cityviewmodel;

import android.arch.lifecycle.ViewModel;
import android.databinding.Observable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.spacitron.citiesapp.citymodel.City;
import com.spacitron.citiesapp.citymodel.CityFetcher;
import com.spacitron.citiesapp.utils.Callback;
import com.spacitron.citiesapp.utils.OnItemSelectedListener;

import java.util.List;
import java.util.concurrent.ExecutorService;

import static com.spacitron.citiesapp.cityviewmodel.CityFilterHelper.EMPTY_KEY;


public class CityViewModel extends ViewModel implements OnItemSelectedListener<City> {


    public final ObservableBoolean isLoading;
    public final ObservableField<String> filter;
    public final ObservableField<City> selectedCity;
    public final ObservableArrayList<City> filteredCityList;

    private CityFilterHelper cityFilterHelper;


    private boolean isInitialized;

    public CityViewModel() {
        isLoading = new ObservableBoolean();
        filter = new ObservableField<>();
        filter.set(EMPTY_KEY);
        filteredCityList = new ObservableArrayList<>();
        selectedCity = new ObservableField<>();
        isInitialized = false;
    }

    public void init(final CityFetcher cityParser, final ExecutorService executorService) {

        // Keep track of whether this was alrady initialised so you don't end up reading the same data
        // for every configuration change. We could also extend AndroidViewModel to do this but
        // I'd rather limit the dependencies on Android as much as possible here
        if (isInitialized) {
            return;
        }
        isInitialized = true;


        isLoading.set(true);

        cityParser.getAllCities(executorService, new Callback<City>() {

            @Override
            public void onSuccess(List<City> result) {
                cityFilterHelper = new CityFilterHelper(result, executorService);

                filteredCityList.clear();
                filteredCityList.addAll(cityFilterHelper.filteredCities(filter.get()));

                makeFilterListener();

                isLoading.set(false);
            }

            @Override
            public void onError(Throwable t) {
                isLoading.set(false);
            }
        });


    }

    private void makeFilterListener() {
        filter.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {

                cityFilterHelper.getFilteredCities(filter.get(), new Callback<City>() {
                    @Override
                    public void onSuccess(List<City> result) {
                        filteredCityList.clear();
                        filteredCityList.addAll(result);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }
                });

            }
        });
    }


    @Override
    public void onItemSelected(City obj) {
        if (selectedCity.get() != null && selectedCity.get().equals(obj)) {
            // Do this to ensure the observers know a new selection
            // has been made even when the city didn't change
            selectedCity.notifyChange();
        }
        selectedCity.set(obj);
    }
}

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

import static com.spacitron.citiesapp.citymodel.CityFilterHelper.EMPTY_KEY;


public class CityViewModel extends ViewModel implements OnItemSelectedListener<City>, Callback<City> {


    public final ObservableBoolean isLoading;
    public final ObservableField<String> filter;
    public final ObservableField<City> selectedCity;
    public final ObservableArrayList<City> filteredCityList;

    private CityFetcher cityFetcher;
    private OnPropertyChanged onPropertyChangedListener;

    public CityViewModel() {
        isLoading = new ObservableBoolean();
        filter = new ObservableField<>();
        filter.set(EMPTY_KEY);
        filteredCityList = new ObservableArrayList<>();
        selectedCity = new ObservableField<>();
    }



    public void init(final CityFetcher cityFetcher) {
        if(this.cityFetcher!=null){
            this.cityFetcher.cancel();
        }
        this.cityFetcher = cityFetcher;

        filteredCityList.clear();
        isLoading.set(true);

        cityFetcher.getFilteredCities(filter.get(), this);

        if(onPropertyChangedListener==null){
            onPropertyChangedListener = new OnPropertyChanged();
            filter.addOnPropertyChangedCallback(onPropertyChangedListener);
        }

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

    @Override
    public void onSuccess(List<City> result) {
        isLoading.set(false);
        filteredCityList.clear();
        filteredCityList.addAll(result);
    }

    @Override
    public void onError(Throwable t) {

    }

    class OnPropertyChanged extends Observable.OnPropertyChangedCallback{

        @Override
        public void onPropertyChanged(Observable observable, int i) {
            cityFetcher.getFilteredCities(filter.get(), CityViewModel.this);
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        cityFetcher.cancel();
    }
}

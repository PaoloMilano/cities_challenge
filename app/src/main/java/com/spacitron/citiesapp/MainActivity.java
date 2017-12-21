package com.spacitron.citiesapp;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.spacitron.citiesapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CityViewModel cityViewModel = ViewModelProviders.of(this).get(CityViewModel.class);
        cityViewModel.init(this);

        cityViewModel.selectedCity.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                if(getSupportFragmentManager().findFragmentByTag(MapFragment.TAG)==null){
                    final FragmentTransaction transaction = getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.city_list_fragment_container, new MapFragment(), MapFragment.TAG);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });

        getSupportFragmentManager().beginTransaction().add(R.id.city_list_fragment_container, new CityListFragment()).commit();

        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setCityViewModel(cityViewModel);

    }


}

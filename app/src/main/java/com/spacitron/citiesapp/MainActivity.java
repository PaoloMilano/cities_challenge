package com.spacitron.citiesapp;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import com.spacitron.citiesapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static int ENTER_FROM_BOTTOM_DURATION = 200;
    View mapViewContainer = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);


        final CityViewModel cityViewModel = ViewModelProviders.of(this).get(CityViewModel.class);
        cityViewModel.init(this);

        cityViewModel.selectedCity.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {

                //Get a reference to the fragment container now so you are sure it was measured
                if (mapViewContainer == null) {
                    mapViewContainer = findViewById(R.id.map_container);
                    mapViewContainer.setTranslationY(mapViewContainer.getHeight());
                    mapViewContainer.setVisibility(View.VISIBLE);
                }

                //Rather than adding a fragment to the backstack, put the map inside a view and use animations to show/hide it.
                //This will save us having to recreate the map at every single click.
                mapViewContainer.animate().translationY(0).setInterpolator(new DecelerateInterpolator()).setDuration(ENTER_FROM_BOTTOM_DURATION).start();
            }
        });

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.city_list_fragment_container, new CityListFragment())
                .add(R.id.map_container,  new MapFragment())
                .commit();

        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setCityViewModel(cityViewModel);

    }



    @Override
    public void onBackPressed() {
        //Unless the map container is all the way at the bottom of the screen, hide it when pressing back
        if (mapViewContainer != null && mapViewContainer.getTranslationY() != mapViewContainer.getHeight()) {
            mapViewContainer.animate().setDuration(ENTER_FROM_BOTTOM_DURATION).setInterpolator(new DecelerateInterpolator()).translationY(mapViewContainer.getHeight());
        }else {
            super.onBackPressed();
        }
    }
}

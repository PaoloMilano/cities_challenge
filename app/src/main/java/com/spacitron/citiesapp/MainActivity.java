package com.spacitron.citiesapp;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;

import com.spacitron.citiesapp.citylist.CityListFragment;
import com.spacitron.citiesapp.databinding.ActivityMainBinding;
import com.spacitron.citiesapp.map.MapFragment;
import com.spacitron.citiesapp.utils.FilesListConfig;

public class MainActivity extends AppCompatActivity {

    private static int ENTER_FROM_BOTTOM_DURATION = 200;
    private View mapViewContainer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final CityViewModel cityViewModel = ViewModelProviders.of(this).get(CityViewModel.class);
        cityViewModel.init(this, FilesListConfig.READABLE_JSON_FILES);

        cityViewModel.selectedCity.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {


                //Get a reference to the fragment container here so you are sure it was measured
                if (mapViewContainer == null) {
                    mapViewContainer = findViewById(R.id.map_container);
                }

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mapViewContainer.getWindowToken(), 0);

                // This only needs to happen in portrait as when in landscape the map is already shown
                if(((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getRotation() == Surface.ROTATION_0) {
                    mapViewContainer.setTranslationY(mapViewContainer.getHeight());
                    mapViewContainer.setVisibility(View.VISIBLE);

                    //Rather than adding a fragment to the backstack, put the map inside a view and use animations to show/hide it.
                    //This will save us having to recreate the map at every single click.
                    mapViewContainer.animate().translationY(0).setInterpolator(new DecelerateInterpolator()).setDuration(ENTER_FROM_BOTTOM_DURATION).start();
                }
            }
        });

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.city_list_fragment_container, new CityListFragment())
                .replace(R.id.map_container, new MapFragment())
                .commit();

        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setCityViewModel(cityViewModel);

    }


    @Override
    public void onBackPressed() {
        //Unless the map container is all the way at the bottom of the screen, hide it when pressing back
        if (mapViewContainer != null && mapViewContainer.getTranslationY() != mapViewContainer.getHeight()) {
            mapViewContainer.animate().setDuration(ENTER_FROM_BOTTOM_DURATION).setInterpolator(new DecelerateInterpolator()).translationY(mapViewContainer.getHeight());
        } else {
            super.onBackPressed();
        }
    }
}

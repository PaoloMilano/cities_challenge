package com.spacitron.citiesapp.map;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.Observable;
import android.databinding.ObservableField;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.spacitron.citiesapp.City;
import com.spacitron.citiesapp.CityViewModel;


public class MapFragment extends SupportMapFragment implements OnMapReadyCallback {

    public static final String TAG = "map_fragment";

    private GoogleMap map;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if(map==null) {
            getMapAsync(this);
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        map = googleMap;
        map.setOnMyLocationClickListener(new GoogleMap.OnMyLocationClickListener() {
            @Override
            public void onMyLocationClick(@NonNull Location location) {
                final LatLng position = new LatLng(location.getLatitude(), location.getLongitude());
                map.addMarker(new MarkerOptions().position(position)).showInfoWindow();
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(position, 5));
            }
        });

        //If a city was selected before opening the map then move there
        final ObservableField<City> selectedCity = ViewModelProviders.of(getActivity()).get(CityViewModel.class).selectedCity;
        if(selectedCity.get()!=null){
            moveToCity(selectedCity.get());
        }

        selectedCity.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                moveToCity(selectedCity.get());
            }
        });
    }

    private void moveToCity(final City city){
        final City.Coordinates coordinates = city.coord;
        final LatLng position = new LatLng(coordinates.lat, coordinates.lon);
        map.clear();
        map.addMarker(new MarkerOptions().position(position).title(city.getDisplayName())).showInfoWindow();
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(position, 5));
    }

}

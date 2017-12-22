package com.spacitron.citiesapp;

import com.spacitron.citiesapp.utils.OnItemSelectedListener;

public class City {

    private String displayName;

    protected String country;
    protected String name;
    public long _id;
    public City.Coordinates coord;

    public static class Coordinates{
        public double lon;
        public double lat;
    }

    protected OnItemSelectedListener<City> itemSelectedListener;

    public void select(){
        if(itemSelectedListener!=null) {
            itemSelectedListener.onItemSelected(this);
        }
    }


    protected String getLowerCaseDisplayName(){
        return getDisplayName().toLowerCase();
    }

    public String getDisplayName() {

        //Lazy compute property even though in this ViewModel it will be called almost immediately.
        if (displayName == null) {
            displayName = String.format("%s, %s", name, country);
        }
        return displayName;
    }

}

package com.spacitron.citiesapp;

public class City {

    protected String country;
    protected String name;
    public long _id;
    public Coordinates coord;

    public static class Coordinates{
        public double lon;
        public double lat;
    }
}

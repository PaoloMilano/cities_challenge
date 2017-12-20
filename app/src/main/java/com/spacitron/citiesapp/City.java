package com.spacitron.citiesapp;

public class City {

    public String country;
    public String name;
    public long _id;
    public Coordinates coord;

    public static class Coordinates{
        public double lon;
        public double lat;
    }
}

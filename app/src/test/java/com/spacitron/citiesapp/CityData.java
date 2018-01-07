package com.spacitron.citiesapp;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.spacitron.citiesapp.citymodel.City;

import java.util.Collections;
import java.util.List;


public class CityData {

   public final static String data = "[" +
            "{\"country\":\"UA\",\"name\":\"Hurzuf\",\"_id\":707860,\"coord\":{\"lon\":34.283333,\"lat\":44.549999}}," +
            "{\"country\":\"UA\",\"name\":\"Alupka\",\"_id\":713514,\"coord\":{\"lon\":34.049999,\"lat\":44.416668}}," +

            //Fake country to see that the country is taken into consideration when sorting
            "{\"country\":\"AA\",\"name\":\"Alupka\",\"_id\":713514,\"coord\":{\"lon\":34.049999,\"lat\":44.416668}}," +

            //Lowercase to ensure that sorting is case insensitive amd indexes are built correctly
            "{\"country\":\"UA\",\"name\":\"alupka\",\"_id\":713514,\"coord\":{\"lon\":34.049999,\"lat\":44.416668}}," +
            "{\"country\":\"RU\",\"name\":\"Novinki\",\"_id\":519188,\"coord\":{\"lon\":37.666668,\"lat\":55.683334}}," +
            "{\"country\":\"NP\",\"name\":\"Gorkh\u0101\",\"_id\":1283378,\"coord\":{\"lon\":84.633331,\"lat\":28}}," +
            "{\"country\":\"IN\",\"name\":\"State of Hary\u0101na\",\"_id\":1270260,\"coord\":{\"lon\":76,\"lat\":29}}," +
            "{\"country\":\"UA\",\"name\":\"Holubynka\",\"_id\":708546,\"coord\":{\"lon\":33.900002,\"lat\":44.599998}}," +
            "{\"country\":\"NP\",\"name\":\"B\u0101gmat\u012B Zone\",\"_id\":1283710,\"coord\":{\"lon\":85.416664,\"lat\":28}}," +
            "{\"country\":\"RU\",\"name\":\"Mar\u2019ina Roshcha\",\"_id\":529334,\"coord\":{\"lon\":37.611111,\"lat\":55.796391}}," +
            "{\"country\":\"IN\",\"name\":\"Republic of India\",\"_id\":1269750,\"coord\":{\"lon\":77,\"lat\":20}}," +
            "{\"country\":\"NP\",\"name\":\"Kathmandu\",\"_id\":1283240,\"coord\":{\"lon\":85.316666,\"lat\":27.716667}}," +
            "{\"country\":\"NP\",\"name\":\"kathmandu\",\"_id\":1283240,\"coord\":{\"lon\":85.316666,\"lat\":27.716667}}," +

            // These following three are used to test filtering
            "{\"country\":\"UA\",\"name\":\"Laspi\",\"_id\":703363,\"coord\":{\"lon\":33.733334,\"lat\":44.416668}}," +
            "{\"country\":\"UA\",\"name\":\"Lasspi\",\"_id\":703363,\"coord\":{\"lon\":33.733334,\"lat\":44.416668}}," +
            "{\"country\":\"UA\",\"name\":\"Lassspi\",\"_id\":703363,\"coord\":{\"lon\":33.733334,\"lat\":44.416668}}," +

            "{\"country\":\"IQ\",\"name\":\"Qarah Gawl al \u2018Uly\u0101\",\"_id\":384848,\"coord\":{\"lon\":45.6325,\"lat\":35.353889}}," +
            "{\"country\":\"RU\",\"name\":\"Zavety Il\u2019icha\",\"_id\":464176,\"coord\":{\"lon\":37.849998,\"lat\":56.049999}}," +
            "{\"country\":\"IL\",\"name\":\"\u2018Azriqam\",\"_id\":295582,\"coord\":{\"lon\":34.700001,\"lat\":31.75}}," +
            "{\"country\":\"UA\",\"name\":\"Tyuzler\",\"_id\":690856,\"coord\":{\"lon\":34.083332,\"lat\":44.466667}}," +
            "{\"country\":\"RU\",\"name\":\"Zaponor\u2019ye\",\"_id\":464737,\"coord\":{\"lon\":38.861942,\"lat\":55.639999}}," +
            "{\"country\":\"UA\",\"name\":\"Il\u2019ich\u00EBvka\",\"_id\":707716,\"coord\":{\"lon\":34.383331,\"lat\":44.666668}}," +
            "]";


   static List<City> getCities(){
       List<City> result =  new GsonBuilder()
               .create()
               .fromJson(data, new TypeToken<List<City>>() {
               }.getType());
       result.removeAll(Collections.singleton(null));
       return result;
   }
}

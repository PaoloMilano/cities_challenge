package com.spacitron.citiesapp.citymodel;

import android.support.v4.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CityFilterHelper {

    // Empty key - corresponding to an empty string - this will
    // be used to string compare empty search filters
    public static final String EMPTY_KEY = new String();

    private Map<Character, Pair<Integer, Integer>> alphabeticalCityIndex;
    private final Map<String, List<City>> filteredCitiesMap;


    public CityFilterHelper(List<City> filterableCities) {

        filterableCities.removeAll(Collections.singleton(null));

        Collections.sort(filterableCities, new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return o1.getDisplayName().toLowerCase().compareTo(o2.getDisplayName().toLowerCase());
            }
        });

        alphabeticalCityIndex = getAlphabeticalCityIndex(filterableCities);

        filteredCitiesMap = new HashMap<>();
        filteredCitiesMap.put(EMPTY_KEY, filterableCities);
    }


    public List<City> getFilteredCities(String filter) {

        // First things first, make the filter text lowercase
        filter = filter.toLowerCase();
        if (filter.equals(EMPTY_KEY)) {
            return filteredCitiesMap.get(EMPTY_KEY);
        }

        // Next, caches whose name does not start with the current filter text
        // should be cleaned-up as they are not relevant right now and we don't want
        // these to grow infinitely. Extract the keys to a list first and remove them later
        // to avoid concurrent mod exception
        List<String> redundantKeys = new ArrayList<>();
        for (String mapKey : filteredCitiesMap.keySet()) {
            if (!filter.startsWith(mapKey)) {
                redundantKeys.add(mapKey);
            }
        }
        for (final String redundantKey : redundantKeys) {
            filteredCitiesMap.remove(redundantKey);
        }

        // Of course, if the map that already contains the appropriate sublist then
        // we don't need to do anything. This will happen when the user deletes characters
        // from the search box.
        if (filteredCitiesMap.containsKey(filter)) {
            return filteredCitiesMap.get(filter);
        }

        // Next, when the filter text contains a single character, the alphabetical index
        // can tell us the indexes of the sublist containing cities starting with that character.
        if (filter.length() == 1 && alphabeticalCityIndex != null) {

            char filterChar = filter.charAt(0);

            //If there's only one character and that's not in the index then it's clearly
            // not in the list either. In that case return an empty array and exit.
            if (!alphabeticalCityIndex.containsKey(filterChar)) {
                filteredCitiesMap.put(filter, new ArrayList<City>());
                return filteredCitiesMap.get(filter);
            }

            Pair<Integer, Integer> alphabeticalIndex = alphabeticalCityIndex.get(filterChar);
            filteredCitiesMap.put(filter, filteredCitiesMap.get(EMPTY_KEY).subList(alphabeticalIndex.first, alphabeticalIndex.second));
            return filteredCitiesMap.get(filter);
        }


        // Finally, if you still haven't found anything, take the smallest list you can find that
        // contains the cities you need - there must be a cache named after the text in the previous search by now - and filter that.
        if (!filter.isEmpty()) {
            for (String mapKey : filteredCitiesMap.keySet()) {
                if (!mapKey.isEmpty() && filter.startsWith(mapKey)) {
                    filteredCitiesMap.put(filter, filterCitiesByStartingString(filter, filteredCitiesMap.get(mapKey)));
                    return filteredCitiesMap.get(filter);
                }
            }
        }

        // This will execute if the user types more than one character at once,
        // in the empty field. In that case we must still have an index for the first characted
        // of the sequence so we can use that to speedup filtering;
        final char filterInitial = filter.charAt(0);
        if (alphabeticalCityIndex.containsKey(filterInitial)) {

            final Pair<Integer, Integer> alphabeticalIndex = alphabeticalCityIndex.get(filterInitial);
            filteredCitiesMap.put(filter, filterCitiesByStartingString(filter, filteredCitiesMap.get(EMPTY_KEY).subList(alphabeticalIndex.first, alphabeticalIndex.second)));

        } else {

            // Finally if nothing was found return an empty list
            filteredCitiesMap.put(filter, new ArrayList<City>());

        }
        return filteredCitiesMap.get(filter);
    }


    protected Map<Character, Pair<Integer, Integer>> getAlphabeticalCityIndex(final List<City> indexableCities) {

        Character firstLetter = null;
        int startIndex = 0;

        final Map<Character, Pair<Integer, Integer>> alphabeticalIndex = new HashMap<>();

        for (City indexableCity : indexableCities) {

            char indexableCharacter = indexableCity.getDisplayName().toLowerCase().charAt(0);

            if (firstLetter == null) {
                firstLetter = indexableCharacter;

            } else if (!firstLetter.equals(indexableCharacter)) {
                alphabeticalIndex.put(firstLetter, new Pair<>(startIndex, indexableCities.indexOf(indexableCity)));
                firstLetter = indexableCharacter;
                startIndex = indexableCities.indexOf(indexableCity);
            }
        }
        return alphabeticalIndex;
    }

    protected List<City> filterCitiesByStartingString(String filterString, List<City> cities) {
        cities = cities.subList(getStartingIndexForName(filterString, cities), cities.size());
        cities = cities.subList(0, getEndingIndexForName(filterString, cities));
        return cities;
    }

    // This gets the index of the first element in the list containing the filter substring
    protected int getStartingIndexForName(String cityNameSubstring, List<City> cities) {

        if (cities.isEmpty()) {
            return 0;
        }

        final City city = getStartingCityForName(cityNameSubstring, cities);

        // We need to do this because the city we get might be the first of
        // the valid sequence or the one immediately preceding it.
        if (!city.getDisplayName().toLowerCase().startsWith(cityNameSubstring)) {
            return cities.indexOf(city) + 1;
        }

        return cities.indexOf(city);
    }

    // This gets the index of the first element that is greater than the filter substring
    protected int getEndingIndexForName(String cityNameSubstring, List<City> cities) {

        if (cities.isEmpty()) {
            return 0;
        }

        final City city = getEndingCityForName(cityNameSubstring, cities);

        // We need to do this because the city we get might be the last in the
        // sequence of valid cities of the first following it.
        if (city.getDisplayName().toLowerCase().startsWith(cityNameSubstring)) {
            return cities.indexOf(city) + 1;
        }
        return cities.indexOf(city);
    }

    private City getStartingCityForName(String cityNameSubstring, List<City> cities) {
        if (cities.size() == 1) {
            return cities.get(0);
        }

        cityNameSubstring = cityNameSubstring.toLowerCase();

        if (cities.get(0).getDisplayName().toLowerCase().startsWith(cityNameSubstring)) {
            return cities.get(0);
        }

        int middle = cities.size() / 2;

        final String middleName = cities.get(middle).getDisplayName().toLowerCase();

        if (cityNameSubstring.compareTo(middleName) > 0) {
            return getStartingCityForName(cityNameSubstring, cities.subList(middle, cities.size()));
        } else {
            return getStartingCityForName(cityNameSubstring, cities.subList(0, middle));
        }
    }

    private City getEndingCityForName(String cityNameSubstring, List<City> cities) {

        if (cities.size() == 1) {
            return cities.get(0);
        }

        cityNameSubstring = cityNameSubstring.toLowerCase();

        int middle = cities.size() / 2;

        final String middleName = cities.get(middle).getDisplayName().toLowerCase().substring(0, cityNameSubstring.length());

        if (cityNameSubstring.compareTo(middleName) >= 0) {
            return getEndingCityForName(cityNameSubstring, cities.subList(middle, cities.size()));
        } else {
            return getEndingCityForName(cityNameSubstring, cities.subList(0, middle));
        }
    }


}

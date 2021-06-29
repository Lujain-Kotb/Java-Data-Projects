package com.mycompany.countriesandcities;

import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lujain
 */
public interface CountryIndexDAO {
    public List<Country> getAllCountries(String path);
    public List<City> getAllCities(String path);
    public Country createCountry(String[] attributes);
    public City createCity(String[] attributes);
    //Lujain done
    public Map<String,List<String>> createCountryCityMap();
    //Sondos
    public List<City> sortCityPopulationForCountry(String countryCode);
    //Sondos
    public Map<String,Integer> getCountriesPopulation();
    public double getAverageCountryPopulation();
    //Lujain done
    public String[] getMaximumCountriesPopulation(); // Cast population int to string
    //Sondos
    public Map<String,String> getHighestPopulationCityForEachCountry();
    //Lujain done
    public City getHighestPopulationCapital(); // handle printing fel main
}

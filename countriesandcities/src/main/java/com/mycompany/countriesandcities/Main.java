/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.countriesandcities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author lujain
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CountryIndexDAOImpl daoImpl = new CountryIndexDAOImpl();
        daoImpl.getAllCountries("C:\\Users\\lujai\\Documents\\NetBeansProjects\\countriesandcities\\src\\main\\resources\\Countries.csv");
        daoImpl.getAllCities("C:\\Users\\lujai\\Documents\\NetBeansProjects\\countriesandcities\\src\\main\\resources\\Cities.csv");
        
        //Create Country City Map
        System.out.println("Create Country City Map");
        HashMap<String,List<String>>map = (HashMap<String,List<String>>) daoImpl.createCountryCityMap();
        for (String key: map.keySet()) {
        String value = map.get(key).toString();
        System.out.println(key + " " + value);
        }
        
        //Get Country with max population
        System.out.println();
        System.out.println("Get Country with max population");
        String[] result = daoImpl.getMaximumCountriesPopulation();
        if (result!=null){
        System.out.println("Country with maximum population is: "+result[0]+" with population: "+result[1]);
        } else{
            System.out.println("Result pf operation is empty");
        }
        
        // Get Capital with highest population
        System.out.println();
        System.out.println("Get Capital with highest population");
        City highestPopulationCapital = daoImpl.getHighestPopulationCapital();
        if (highestPopulationCapital!=null){
        System.out.println("Capital with highest population is: "+highestPopulationCapital.getName()+" with population: "+highestPopulationCapital.getPopulation());
        } else{
            System.out.println("Result pf operation is empty");
        }
        
        //SortCityPopulationForCountry
        System.out.println();
        System.out.println("SortCityPopulationForCountry");
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        System.out.println("Enter Country Code:");
        String countryCode = null;
        try{
         countryCode = br.readLine();
         List <City> citiesOrderedByPop = daoImpl.sortCityPopulationForCountry(countryCode);
        for(City city: citiesOrderedByPop){
            System.out.println(city.toString());
        }
        } catch(IOException ex) {
            System.out.println("Failed to read line");
        }

        //GetCountriesPopulation
        System.out.println();
        System.out.println("GetCountriesPopulation");
        System.out.println();
        HashMap<String,Integer> map2 = (HashMap<String,Integer>) daoImpl.getCountriesPopulation();
       for (String key: map2.keySet()) {
        String value = map2.get(key).toString();
        System.out.println(key + " " + value);
        }
        
       //GetAveragePopulation
       System.out.println();
       System.out.println("GetAveragePopulation");
       System.out.println("The average population is= "+daoImpl.getAverageCountryPopulation());
       
       //GetHighestPopulation
       System.out.println();
       System.out.println("GetHighestPopulation");
       HashMap<String,String> map3 = (HashMap<String,String>) daoImpl.getHighestPopulationCityForEachCountry();
       for (String key: map3.keySet()) {
        String value = map3.get(key).toString();
        System.out.println(key + " " + value);
        }

    }
}

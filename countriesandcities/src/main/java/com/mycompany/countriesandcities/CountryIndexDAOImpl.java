/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.countriesandcities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author lujain
 */
public class CountryIndexDAOImpl implements CountryIndexDAO {
    
    List<Country> countries;
    List<City> cities;
    
    public CountryIndexDAOImpl(){
        countries = new ArrayList<>();
        cities  = new ArrayList<>();
    }
    @Override
    public List<Country> getAllCountries(String path) {
        try {
            readAndCreate(path, "Country");
            return this.countries;
        } catch (IOException ex) {
            return null;
        }
    }

    @Override
    public List<City> getAllCities(String path) {
        try {
            readAndCreate(path, "City");
            return this.cities;
        } catch (IOException ex) {
            return null;
        }
    }

    @Override
    public Country createCountry(String[] attributes) {
        String code = attributes[0];
        String name = attributes[1];
        String continent = attributes[2];
        double surfaceArea;
        int population;
        double gnp;
        int capital;
        try{
            surfaceArea = Double.parseDouble(attributes[4]);
        } catch(NumberFormatException ex){
            surfaceArea = 0;
        }
        try{
            population = Integer.parseInt(attributes[3]);
        } catch(NumberFormatException ex){
            population = 0;
        }
        try{
            gnp = Double.parseDouble(attributes[5]);
        } catch(NumberFormatException ex){
            gnp = 0;
        }
        try{
            capital = Integer.parseInt(attributes[6]);
        } catch(NumberFormatException ex){
            capital = 0;
        }
        return new Country(code,name,continent,surfaceArea,population,gnp,capital);
    }

    @Override
    public City createCity(String[] attributes) {
        int id;
        String name = attributes[1];
        int population;
        String countryCode = attributes[3];
        try{
            id = Integer.parseInt(attributes[0]);
        } catch(NumberFormatException ex){
            id = 0;
        }
        try{
            population = Integer.parseInt(attributes[2]);
        } catch(NumberFormatException ex){
            population = 0;
        }
        
        return new City(id,name,population,countryCode);
    }

    @Override
    public Map<String, List<String>> createCountryCityMap() {
        Map map = new HashMap<String,List>();
        for (Country country: countries) {
            String countryCode = country.getCode();
            List<String> filteredCities =  cities.stream()
                    .filter(city -> city.getCountryCode().trim().equals(countryCode))
                            .map(City::getName)
                            .collect(toList());
            for(String cityName:filteredCities){
                if (map.get(country.getName())== null){
                ArrayList<String> newList = new ArrayList<String>();
                newList.add(cityName);
                map.put(country.getName(), newList);
            } else{
                ArrayList<String> currentList = (ArrayList)map.get(country.getName());
                currentList.add(cityName);
                map.put(country.getName(), currentList);
            }
            } 
        }
        return map;
        }

    @Override
    public List<City> sortCityPopulationForCountry(String countryCode) {
        List<City> sortedCities = cities.stream()
                .filter(city -> city.getCountryCode().trim().equals(countryCode))
                .sorted(Comparator.comparing(City::getPopulation))
                .collect(toList());
        
        return sortedCities; 
    }

    @Override
    public Map<String, Integer> getCountriesPopulation() {
        HashMap<String,Integer> map = new HashMap<>();
        for (Country country: this.countries) {
            map.put(country.getName(),country.getPopulation());
        }
    return  map;     
    }

    @Override
    public double getAverageCountryPopulation() {
        double sum=0.0;
        int count=0;
        for(int pop: getCountriesPopulation().values()){
            sum=sum+pop ;
            count++;
        }
    return sum/count;
    }

    @Override
    public String[] getMaximumCountriesPopulation() {
        String[] result = new String[2];
        Country resultCountry = countries.stream()
                .max(Comparator.comparing(Country::getPopulation)).orElse(null);
        if (resultCountry != null) {
            result[0]=resultCountry.getName();
            result[1]= String.valueOf(resultCountry.getPopulation());
        }else{
            result = null;
        }
        return result;
    }

     @Override
    public Map<String, String> getHighestPopulationCityForEachCountry() {
        Map<String,String> map1 =new HashMap<>();
        for(Country country: this.countries){ 
            String countryCode = country.getCode();
            City sortedCities = cities.stream()
                .filter(city -> city.getCountryCode().trim().equals(countryCode))
                .max(Comparator.comparing(City::getPopulation)).orElse(null);
            if(sortedCities!=null){
            map1.put(country.getName(), sortedCities.getName());
            }
        }
        
    return map1;        
    }

    @Override
    public City getHighestPopulationCapital() {
        List<City> capitalList = new ArrayList<>();
        for (Country country: countries){
            int countryCapitalId = country.getCapital();
            City foundCity = cities.stream()
                    .filter(city -> city.getId() == countryCapitalId)
                    .findFirst().orElse(null);
            if (foundCity != null) {
                capitalList.add(foundCity);
            }   
        }
        City result = capitalList.stream()
                .max(Comparator.comparing(City::getPopulation)).orElse(null);
        return result;
    }
    
    private void readAndCreate(String path, String type) throws IOException{
        BufferedReader br = readFile(path);
        if(br!= null){
            try{
            String line = br.readLine();
            while(line != null){
                String[] attributes = line.split(",");
                switch(type){
                    case "Country":
                        Country country = this.createCountry(attributes);
                        this.countries.add(country);
                        break;
                    case "City":
                        City city = this.createCity(attributes);
                        this.cities.add(city);
                        break;
                }
                line = br.readLine();
            }
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        } else{
            throw new IOException();
        }
    }
    
    private BufferedReader readFile(String path){
        BufferedReader br = null;
        try{
        br = new BufferedReader(new FileReader(path));
        } catch(IOException ex) {
            ex.printStackTrace(); 
        }
        return br;
    }
}
    

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.countriesandcities;

/**
 *
 * @author lujain
 */
public class City {
    
    private int id;
    private String name;
    private int population;
    private String countryCode;
    
    public City(int id, String name, int population, String countryCode){
        this.id = id;
        this.name = name;
        this.population = population;
        this.countryCode = countryCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    
    @Override
    public String toString(){
      return "id: "+id+" name: "+name+" population: "+population+ " Country Code:" +countryCode;  
    }

    
}

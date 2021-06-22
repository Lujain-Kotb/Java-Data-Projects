/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.umltocode;

/**
 *
 * @author lujain
 */
public class Medal {
    private int medalID;
    
    public Medal(int medalID){
        this.medalID = medalID;
    }
    
    public int getMedal(){
        return this.medalID;
    }
    
    public void setMedalID(int medalID){
        this.medalID = medalID;
    }
}

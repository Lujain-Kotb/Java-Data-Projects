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
public class Coach extends Person {
   private int coachID;
    
    public Coach(String name, String address,int coachID){
        super(name,address);
        this.coachID = coachID;
    }
    
    public int getCoachID(){
        return this.coachID;
    }
    
    public void setCoachID(int coachID){
        this.coachID = coachID;
    }
}

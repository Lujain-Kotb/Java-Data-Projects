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
public class Player extends Person {
    private int playerID;
    private int numMedal;
    private Coach c;
    private Team t;
    private Medal m;
    
    public Player(String name, String address,int playerId,int numMedal){
        super(name,address);
        this.playerID = playerId;
        this.numMedal = numMedal;
    }
    
    public void assignCoach(Coach c){
        this.c = c;
    }
    public Coach getCoach(){
        return this.c;
    }
    public void assignTeam(Team t){
       this.t = t;
    }
     public Team getTeam(){
        return this.t;
    }
    
    public void addMedal(Medal m){
        this.m = m;
    }
     public Medal getMedal(){
        return this.m;
    }
    
    public int getPlayerID(){
        return this.playerID;
    }
    
    public void setPlayerID(int playerID){
        this.playerID = playerID;
    }
    
    public int getNumMedal(){
        return this.numMedal;
    }
    
    public void setNumMedal(int numMedal){
        this.numMedal = numMedal;
    }
    
}

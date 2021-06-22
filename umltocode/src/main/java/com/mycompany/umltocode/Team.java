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
public class Team {
    private int teamID;
    
    public Team(int teamID){
        this.teamID = teamID;
    }
    
    public int getTeamID(){
        return this.teamID;
    }
    
    public void setTeamID(int teamID){
        this.teamID = teamID;
    }
}

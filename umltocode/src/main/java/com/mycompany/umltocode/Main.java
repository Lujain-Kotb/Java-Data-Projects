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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Player p1 = new Player("p1","alex",1,5);
        Player p2 = new Player("p2","cairo",2,3);
        Coach c1 = new Coach("c1","alex",1);
        Coach c2 = new Coach("c2","cairo",2);
        Team t = new Team(1);
        Medal m = new Medal(1);
        p1.assignTeam(t);
        p1.assignCoach(c1);
        p1.addMedal(m);
        Delegate egydel = new Delegate("Egypt");
        egydel.addPlayer(p1);
        egydel.addPlayer(p2);
        egydel.addCoach(c2);
        System.out.println("Number of players: "+egydel.getNumberOfPlayers());        
    }
    
}

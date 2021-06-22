/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.umltocode;
import java.util.*;
/**
 *
 * @author lujain
 */
public class Delegate {
   private String country;
   private List <Player> pList;
   private Coach c;
   
   public Delegate(String country){
       this.country = country;
       this.pList = new ArrayList<>();
   }
   
   public void addCoach(Coach c){
       this.c = c;
   }
   
   public Coach getCoach(){
       return this.c;
   }
   
   public void addPlayer(Player p){
       this.pList.add(p);
   }
   
   public List<Player> getPlayerList(){
       return this.pList;
   }
   
   public int getNumberOfPlayers(){
       return this.pList.size();
   }
}

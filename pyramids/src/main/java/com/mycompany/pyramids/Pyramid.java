/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pyramids;

/**
 *
 * @author lujain
 */
public class Pyramid {
    private String pharoah;
    private String modernName;
    private String site;
    private double height;
    
    public Pyramid(String pharoah, String modernName, String site, double height){
        this.pharoah = pharoah;
        this.modernName = modernName;
        this.site = site;
        this.height = height;
    }
    
    public String toString(){
        return "Pharoah: " + this.pharoah +" , Modern Name: "+this.modernName+" , Site: "+site+" , Height: "+height;
    }
    
    public String getPharoah(){
        return this.pharoah;
    }
    
    public void setPharoah(String pharoah){
        this.pharoah = pharoah;
    }
    
    public String getModernName(){
        return this.modernName;
    }
    
    public void setModernName(String modernName){
        this.modernName = modernName;
    }
    
    public String getSite(){
        return this.site;
    }
    
    public void setSite(String site){
        this.site = site;
    }
    
    public double getHeight(){
        return this.height;
    }
    
    public void setHeight(double height){
        this.height = height;
    }
}

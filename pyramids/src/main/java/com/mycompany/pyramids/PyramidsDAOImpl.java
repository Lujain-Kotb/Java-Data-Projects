/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pyramids;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lujain
 */
public class PyramidsDAOImpl implements PyramidsDAO {
    
    List<Pyramid> pyramids;
    
    public PyramidsDAOImpl(){
        pyramids = new ArrayList<Pyramid>();
    }
    
    @Override
    public List<Pyramid> getAllPyramids(String path) {
        BufferedReader br = readFile(path);
        if(br!= null){
            try{
            String line = br.readLine(); // Skip header line
            line = br.readLine();
            while(line != null){
                String[] attributes = line.split(",");
                Pyramid pyr = this.createPyramid(attributes);
                this.pyramids.add(pyr);
                line = br.readLine();
            }
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        } else{
            return null;
        }
        return this.pyramids;
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

    @Override
    public Pyramid createPyramid(String[] attributes) {
        String pharoah = attributes[0];
        String modernName = attributes[2];
        String site = attributes[4];
        double height;
        try{
            height = Double.parseDouble(attributes[7]);
        } catch(NumberFormatException ex){
            height = 0;
        }
        return new Pyramid(pharoah,modernName,site,height);
    }
}

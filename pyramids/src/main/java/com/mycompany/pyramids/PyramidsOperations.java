/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pyramids;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lujain
 */
public class PyramidsOperations {
    private List<Pyramid> pyramids;
    
    public PyramidsOperations(List<Pyramid> pyramids){
        this.pyramids = pyramids;
    }
    
    public List<Pyramid> getList(){
        return this.pyramids;
    }
    
        public List<Pyramid> sortByHeight(){
        Collections.sort(this.pyramids, new Comparator<Pyramid>() {
            @Override
            public int compare(Pyramid p1, Pyramid p2) {
                return (int) ((p1.getHeight() - p2.getHeight())*100);
            }
        });
       return this.pyramids;
    }
    
    public HashMap<String,Integer> groupBySite(){
        HashMap<String,Integer> map = new HashMap<>();
        for (Pyramid pyr: this.pyramids) {
            if (map.get(pyr.getSite())== null){
                map.put(pyr.getSite(),1);
            } else{
                map.put(pyr.getSite(), map.get(pyr.getSite())+1);
            }
        }
        return map;
    }
}

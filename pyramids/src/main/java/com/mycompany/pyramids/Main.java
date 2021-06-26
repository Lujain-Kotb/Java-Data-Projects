/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pyramids;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lujain
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PyramidsDAOImpl pyrdaoimpl = new PyramidsDAOImpl();
        List<Pyramid> pyramids = pyrdaoimpl.getAllPyramids("C:\\Users\\lujai\\Documents\\NetBeansProjects\\pyramids\\pyramids.csv");
        for (Pyramid pyramid: pyramids) {
            System.out.println(pyramid.toString());
        }
        PyramidsOperations ops = new PyramidsOperations(pyramids);
        ops.sortByHeight();
        System.out.println();
        System.out.println("Sorted list by height");
        for (Pyramid pyramid: ops.getList()) {
            System.out.println(pyramid.toString());
        }
        HashMap<String,Integer> map = ops.groupBySite();
        System.out.println();
        System.out.println("Grouped list by site");
        for (String key: map.keySet()) {
        String value = map.get(key).toString();
        System.out.println(key + " " + value);
}
    }
    
}

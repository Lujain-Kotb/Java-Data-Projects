/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.titanic;

import java.io.IOException;
import tech.tablesaw.api.Table;

/**
 *
 * @author lujain
 */
public class TablesawSummary {
    
    public static void printTitanicSummary() {
        try {
            Table df = Table.read().file("C:\\Users\\lujai\\Documents\\NetBeansProjects\\titanic\\src\\main\\resources\\Data_to_use\\titanic.csv");
            System.out.println(df.summary());
        } catch(IOException ex){
           ex.printStackTrace(); 
        }
    }
}

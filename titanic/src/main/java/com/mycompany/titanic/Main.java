package com.mycompany.titanic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lujain
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TablesawSummary.printTitanicSummary();
        DataSetOperations ops = new DataSetOperations();
        ops.graphPassengerAges();
        ops.graphPassengerClass();
        ops.graphPassengerSurvived();
        ops.graphPassengerSurvivedGender();
    }
}

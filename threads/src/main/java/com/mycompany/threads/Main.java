/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.threads;

/**
 *
 * @author lujain
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new SimpleThread("Thread Object 1").start();
        new SimpleThread("Thread Object 2").start();
        
        new Thread(new SimpleRunThread("Runnable Object")).start();
    }
    
}

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
        String string1 = "My name is Lujain"; 
        String string2 = "My name is Ahmed"; 
        String longer = StringUtils.betterString(string1, string2, (s1, s2) -> s1.length() > s2.length()); 
        String first = StringUtils.betterString(string1, string2, (s1, s2) -> true);
        
        System.out.println("String "+longer+" is longer");
        System.out.println("String "+first+" is first");
    }
    
}



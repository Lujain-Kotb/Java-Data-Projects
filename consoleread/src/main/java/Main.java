/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lujain
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        FileWriter writer = new FileWriter("D:\\outputfile.txt");
        BufferedWriter bw = new BufferedWriter(writer);
        String data = null;
        do {
        System.out.println("Enter Data:");
        data = br.readLine();
        System.out.println("Data is: "+ data);
        bw.write(data);
        bw.newLine();
        }
        while(!(data.equals("stop")));
        bw.close();
        br.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
}

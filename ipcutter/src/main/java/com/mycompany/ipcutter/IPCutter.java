/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ipcutter;

/**
 *
 * @author lujain
 */
public class IPCutter {
    private String ipAddress;
    
    public IPCutter(String ip){
        this.ipAddress = ip;
    }
    
    public String cut(){
      String result = "";
      String[] list = this.ipAddress.split("\\.");
      for(String item:list){
          result+= item + "\n";
      }
      return result;
    }
}

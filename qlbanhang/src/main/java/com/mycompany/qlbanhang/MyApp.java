/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qlbanhang;

import java.sql.Connection;
import java.sql.DriverManager;



/**
 *
 * @author ACER
 */
public class MyApp {
    public static void main(String Agrs[]){
        Connection conn = null; 
        try {
          String connStr = "jdbc:mysql://localhost:3306/qlhanghoa";
          conn = DriverManager.getConnection(connStr);
          System.out.println("Connect succes");
        }
        catch(Exception e){
            System.out.println("Cannot connect");
        }
          
        
    }
    
    
}

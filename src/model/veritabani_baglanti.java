/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Ali Can
 */
public class veritabani_baglanti {

    
    public Connection con;
    
    private final String url="jdbc:mysql://localhost:3306/";
    private final String driver="com.mysql.jdbc.Driver";
    private final String dbname="sinema";
    private final String username="root";
    private final String password="0000";
    
    public void baglan() {
        try {
            Class.forName(driver).newInstance();
            con=DriverManager.getConnection(url+dbname,username,password);
            System.out.println("Bağlantı Başarılı");
        } catch (Exception ex) {
            System.out.println("Hata: "+ ex);
        }
        
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.veritabani_baglanti;



public class giris {

    ResultSet rs=null;
    PreparedStatement ps;
    
    public boolean login(String ad,String sifresi) throws SQLException{
        
        veritabani_baglanti vb = new veritabani_baglanti();
        vb.baglan();
        
        String sorgu="select yonetici_sifre from yonetici where yonetici_kadi=?";
        ps=vb.con.prepareCall(sorgu);
        ps.setString(1, ad);
        rs=ps.executeQuery();
        
        while(rs.next()){
            String pw=rs.getString("yonetici_sifre");
            if(pw.equals(sifresi)){
                return true;
            }
            else
                return false;
        }
        return false;
        
                
    }
    
    public boolean login2(String ad,String sifresi) throws SQLException{
        
        veritabani_baglanti vb = new veritabani_baglanti();
        vb.baglan();
        
        String sorgu="select sifre_editor from editor where kadi_editor=?";
        ps=vb.con.prepareCall(sorgu);
        ps.setString(1, ad);
        rs=ps.executeQuery();
        
        while(rs.next()){
            String pw=rs.getString("sifre_editor");
            if(pw.equals(sifresi)){
                return true;
            }
            else
                return false;
        }
        return false;
        
                
    }
    
}

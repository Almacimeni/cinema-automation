/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.veritabani_baglanti;

/**
 *
 * @author Ali Can
 */
public class anasayfa_ayar {
    private JTable personelTablo;
    private Vector<String> sutunlar = new Vector<>();
    private Vector<Object> satir;
    private DefaultTableModel model;
    ResultSet rs=null;
    PreparedStatement ps;
    public anasayfa_ayar(JTable personelTablo) {
        this.personelTablo = personelTablo;
        sutunlar.add("Film Adı");
        sutunlar.add("Salon");
        sutunlar.add("Seans");
        
        model=(DefaultTableModel)personelTablo.getModel();
        model.setColumnIdentifiers(sutunlar);
        
        
        
        veritabani_baglanti vb = new veritabani_baglanti();
        vb.baglan();
        /*this.sehirCombobox = sehirCombobox;
        try {
            String sorgu = "select * from sehir";
            ps = vb.con.prepareStatement(sorgu);
            rs= ps.executeQuery();
            while(rs.next()){
                String sehirAd = rs.getString("sehirAdi");
                sehirCombobox.addItem(sehirAd);
            }
        } catch (Exception e) {
        }
        
        this.birimCombobox = birimCombobox;
        try {
            String sorgu = "select * from birim";
            ps = vb.con.prepareStatement(sorgu);
            rs= ps.executeQuery();
            while(rs.next()){
                String birimAd = rs.getString("birimAdi");
                birimCombobox.addItem(birimAd);
            }
        } catch (Exception e) {
        }*/
        
    }

    public ArrayList<sabitlerSql> filmList() throws SQLException{
        model.getDataVector().removeAllElements();
        ArrayList<sabitlerSql> personelList = new ArrayList<>();
        try{
            veritabani_baglanti vb = new veritabani_baglanti();
            vb.baglan();
            String sorgu = "SELECT * FROM film order by ad_film";
            Statement st = vb.con.createStatement();
            ResultSet rs = st.executeQuery(sorgu);
            sabitlerSql pg;
            
            while(rs.next()){
                pg = new sabitlerSql( rs.getString("ad_film"), rs.getString("id_salon"), rs.getString("id_seans") );
                personelList.add(pg);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "hata2: " + e);
        }
        return personelList;
    }
    public void listele() throws SQLException{
        ArrayList<sabitlerSql> list = (ArrayList<sabitlerSql>) filmList();
        model = (DefaultTableModel) personelTablo.getModel();
        Object[] row = new Object[9];
        for (int i = 0; i < list.size(); i++) {
            row[0]=list.get(i).getFilmAdi();
            row[1]=list.get(i).getFilmSalon();
            row[2]=list.get(i).getFilmSeans();
            model.addRow(row);
        }
    }
    
    
    public void filmEkle(String filmAdi,String filmSalon,String filmSeans) throws SQLException{
        veritabani_baglanti vb = new veritabani_baglanti();
        vb.baglan();
        String sorgu="INSERT INTO film(ad_film,id_salon,id_seans) VALUES(?,?,?)";
       
        ps=vb.con.prepareCall(sorgu);
        ps.setString(1, filmAdi);
        ps.setString(2, filmSalon);
        ps.setString(3, filmSeans);
        ps.executeUpdate();
    }

    public void filmSil(String filmAdi, String filmSalon, String filmSeans ) throws SQLException {
        
        veritabani_baglanti vb = new veritabani_baglanti();
        vb.baglan();
        String sorgu="delete from film where ad_film=? and id_salon=? and id_seans=?";
        ps=vb.con.prepareCall(sorgu);
        ps.setString(1, filmAdi);
        ps.setString(2, filmSalon);
        ps.setString(3, filmSeans);
        ps.executeUpdate(); 
        
    }

   /* public void filmGuncelle(String filmAdi,String filmSalon,String filmSeans) throws SQLException {
        
        veritabani_baglanti vb = new veritabani_baglanti();
        vb.baglan();
        String sorgu="UPDATE film SET ad_film=?,id_salon=?,id_seans=? where ad_film=?";
       
        ps=vb.con.prepareCall(sorgu);
        ps.setString(1, filmAdi);
        ps.setString(2, filmSalon);
        ps.setString(3, filmSeans);
        ps.setString(4, filmAdi);
        ps.executeUpdate();
    }*/
}
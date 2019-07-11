/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Ali Can
 */
public class sabitlerSql {

   
    private String filmAdi;
    private String filmSalon;
    private String filmSeans;
    
    
    public sabitlerSql(String filmAdi,String filmSalon,String filmSeans)
    {
        
        this.filmAdi=filmAdi;
        this.filmSalon=filmSalon;
        this.filmSeans=filmSeans;
    }

    
    
    /**
     * @return the filmAdi
     */
    public String getFilmAdi() {
        return filmAdi;
    }

    /**
     * @param filmAdi the filmAdi to set
     */
    public void setFilmAdi(String filmAdi) {
        this.filmAdi = filmAdi;
    }

    /**
     * @return the filmSalon
     */
    public String getFilmSalon() {
        return filmSalon;
    }

    /**
     * @param filmSalon the filmSalon to set
     */
    public void setFilmSalon(String filmSalon) {
        this.filmSalon = filmSalon;
    }

    /**
     * @return the filmSeans
     */
    public String getFilmSeans() {
        return filmSeans;
    }

    /**
     * @param filmSeans the filmSeans to set
     */
    public void setFilmSeans(String filmSeans) {
        this.filmSeans = filmSeans;
    }

   
}

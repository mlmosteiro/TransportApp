package com.example.adrinbeda.testsqlite;
/**
 *
 * Clase para anuncios de la TransportApp
 *
 **/

import java.util.Date;

public abstract class announcements{
    private users user;     //Si lo hago FK me interesa String o User?... Mejor User... creo.
    private Date date;
    private String orgn;
    private String destination;
    private String origin;
    private int price;
    private String title;

    public announcements(users user, Date date, String origin, String destination, int price, String title){
        this.user = user;
        this.date = date;
        this.origin = origin;
        this.destination = destination;
        this.price = price;
        this.title = title;
    }

    // Tiene sentido hacer set, si vamos a crear nosotros las propias entradas de la base de datos?... xD
    public users getUser(){
        return this.user;
    }

    public String getLocation(){
        return "from: " + this.orgn + " to: " + this.destination;
    }

    public String getTitle(){
        return this.title;
    }

    public Date getDate(){
        return this.date;
    }

    public int getPrice(){
        return this.price;
    }

}
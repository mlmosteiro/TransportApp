package com.example.adrinbeda.testsqlite;
/**
 *
 * Clase para anuncios de transporte de la TransportApp
 *
 **/

import java.util.Date;

public class transportAnnouncements extends announcements {
    private String vhDetails;

    public transportAnnouncements(users user, Date date, String origin, String destination, int price, String title, String vhDetails){
        super(user, date, origin, destination, price, title);
        this.vhDetails = vhDetails;
    }

    public String getVhDetails(){
        return this.vhDetails;
    }

    public users getUser(){
        return super.getUser();
    }

    public String getLocation(){
        return super.getLocation();
    }

    public String getTitle(){
        return super.getTitle();
    }

    public Date getDate(){
        return super.getDate();
    }

    public int getPrice(){
        return super.getPrice();
    }
}
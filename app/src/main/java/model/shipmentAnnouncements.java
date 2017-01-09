package com.example.adrinbeda.testsqlite;
/**
 *
 * Clase para anuncios de envío de la TransportApp
 *
 **/

import java.util.Date;

public class shipmentAnnouncements extends announcements {
    private String type;

    public shipmentAnnouncements(users user, Date date, String origin, String destination, int price, String title, String type){
        super(user, date, origin, destination, price, title);
        this.type = type;
    }

    public String getType(){
        return this.type;
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
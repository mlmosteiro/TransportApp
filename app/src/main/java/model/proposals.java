package com.example.adrinbeda.testsqlite; /**
 *
 * Clase definida para proposals en TransportApp
 *
 **/

import java.util.Date;

public class proposals {
    private users user;     // FK on db
    private int price;
    private String description;
    private String state;
    private Date date;

    public proposals(users user, int price, String description, String state, Date date){
        this.user = user;
        this.price = price;
        this.description = description;
        this.state = state;
        this.date = date;
    }

    public users getUser(){
        return this.user;
    }

    public int getPrice(){
        return this.price;
    }

    public String getDescription(){
        return this.description;
    }

    public Date getDate(){
        return this.date;
    }

    public String getState(){
        return this.state;
    }

}
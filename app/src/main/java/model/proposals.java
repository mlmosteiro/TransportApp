package model; /**
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
    private Date date;  //Fecha de envio de la propuesta para ordenarlas cronologicamente
    private Date loadDate;
    private Date downloadDate;

    public proposals(users user, int price, String description, String state, Date date, Date loadDate, Date downloadDate) {
        this.user = user;
        this.price = price;
        this.description = description;
        this.state = state;
        this.date = date;
        this.loadDate = loadDate;
        this.downloadDate = downloadDate;
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

    public Date getLoadDate() {
        return loadDate;
    }

    public Date getDownloadDate() {
        return downloadDate;
    }
}
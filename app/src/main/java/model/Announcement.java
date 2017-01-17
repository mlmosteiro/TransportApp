package model;
/**
 *
 * Clase para anuncios de la TransportApp
 *
 **/

import android.content.ContentValues;

import java.util.Date;

import erasmus.transportapp.R;

public abstract class Announcement {
    private Users user;     //Si lo hago FK me interesa String o User?... Mejor User... creo.
    private Date date;      //Fecha en la que ha sido publicado el anuncio para poder mostrarlos en orden cronologico
    private Location destination;
    private Location origin;
    private int price;
    private String title;
    private Date loadDate;
    private Date downloadDate;
    private String description;
    private int imageId;
    private int id;



    public Announcement(int id, Users user, Date date, Location destination, Location origin, int price, String title, Date loadDate, Date downloadDate, String description, int imageId) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.destination = destination;
        this.origin = origin;
        this.price = price;
        this.title = title;
        this.loadDate = loadDate;
        this.downloadDate = downloadDate;
        this.description = description;
        this.imageId = imageId;
    }

    //TODO: Quitar esto en cuanto se pueda :D
    public Announcement(int id, Location origin, Location destination) {
        this.id = id;
        this.user = new Users("user1");
        this.title = "Título del anuncio :D";
        this.origin = origin;
        this.destination = destination;
        this.downloadDate = new Date(2017,12,11);
        this.loadDate = new Date(2017,01,11);
        this.description = new String("Blara blara to blara blara");
        this.imageId = R.drawable.ic_menu_my_announcements;
        this.price = 1200;

    }

    public Users getUser(){
        return this.user;
    }

    public String getLocation(){
        return "from: " + this.origin + " to: " + this.destination;
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

    public Location getDestination() { return destination; }

    public Location getOrigin() { return origin; }

    public Date getLoadDate() { return loadDate; }

    public Date getDownloadDate() { return downloadDate; }

    public String getDescription() { return description; }

    public int getImageId() { return imageId; }

    public int getId() { return id; }

}
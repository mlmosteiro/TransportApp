package model;
/**
 *
 * Clase para anuncios de transporte de la TransportApp
 *
 **/

import android.content.ContentValues;


import java.util.Date;

import model.typeVehicle.Type;

public class TransportAnnouncements extends Announcement {
    private String vhDetails;

    public TransportAnnouncements(Users user, Date date, Location destination, Location origin, int price, String title, Date loadDate, Date downloadDate, String description, int id, Type type, String vhDetails) {
        super(user, date, destination, origin, price, title, loadDate, downloadDate, description, id, type);
        this.vhDetails = vhDetails;
    }

    public TransportAnnouncements(int id, Location origin, Location destination, Type type, String vhDetails) {
        super(id, origin, destination, type);
        this.vhDetails = vhDetails;
    }

    public String getVhDetails() {
        return vhDetails;
    }

    //TODO guardar tambien las latitudes!!!
    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        values.put(Contracts.transportAnnouncementEntry.title, this.getTitle());
        values.put(Contracts.transportAnnouncementEntry.description, this.getDescription());
        values.put(Contracts.transportAnnouncementEntry.vehicleDetails, this.vhDetails);
        values.put(Contracts.transportAnnouncementEntry.origin, this.getOrigin().getName());
        values.put(Contracts.transportAnnouncementEntry.destination, this.getDestination().getName());
        values.put(String.valueOf(Contracts.transportAnnouncementEntry.price), this.getPrice());
        values.put(String.valueOf(Contracts.transportAnnouncementEntry.type), this.getType().getName());
        return values;
    }
}
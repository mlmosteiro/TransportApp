package model;
/**
 *
 * Clase para anuncios de transporte de la TransportApp
 *
 **/

import android.content.ContentValues;

import java.util.Date;

public class TransportAnnouncements extends Announcement {
    private String vhDetails;

    public TransportAnnouncements(int id, Users user, Date date, Location destination, Location origin, int price, String title, Date loadDate, Date downloadDate, String description, int imageId, String vhDetails) {
        super(id, user, date, destination, origin, price, title, loadDate, downloadDate, description, imageId);
        this.vhDetails = vhDetails;
    }

    public TransportAnnouncements(int id, Location origin, Location destination, String vhDetails) {
        super(id, origin, destination);
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
        values.put(String.valueOf(Contracts.transportAnnouncementEntry.imageID), this.getImageId());
        return values;
    }
}
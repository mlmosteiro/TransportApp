package model;
/**
 *
 * Clase para anuncios de transporte de la TransportApp
 *
 **/

import android.content.ContentValues;

import java.util.Date;

public class TransportAnnouncements extends Announcements {
    private String vhDetails;

    public TransportAnnouncements(Users user, Date date, String destination, String origin, int price, String title, Date loadDate, Date downloadDate, String description, int imageId, String vhDetails) {
        super(user, date, destination, origin, price, title, loadDate, downloadDate, description, imageId);
        this.vhDetails = vhDetails;
    }

    public TransportAnnouncements(String origin, String destination, String vhDetails) {
        super(origin, destination);
        this.vhDetails = vhDetails;
    }

    public String getVhDetails() {
        return vhDetails;
    }

    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        values.put(Contracts.transportAnnouncementEntry.title, this.getTitle());
        values.put(Contracts.transportAnnouncementEntry.description, this.getDescription());
        values.put(Contracts.transportAnnouncementEntry.vehicleDetails, this.vhDetails);
        values.put(Contracts.transportAnnouncementEntry.origin, this.getOrigin());
        values.put(Contracts.transportAnnouncementEntry.destination, this.getDestination());
        values.put(String.valueOf(Contracts.transportAnnouncementEntry.price), this.getPrice());
        values.put(String.valueOf(Contracts.transportAnnouncementEntry.imageID), this.getImageId());
        return values;
    }
}
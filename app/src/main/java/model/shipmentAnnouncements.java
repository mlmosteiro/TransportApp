package model;
/**
 *
 * Clase para anuncios de envío de la TransportApp
 *
 **/

import android.content.ContentValues;

import java.util.Date;



public class ShipmentAnnouncements extends Announcements {
    private String type;

    public ShipmentAnnouncements(Users user, Date date, String destination, String origin, int price, String title, Date loadDate, Date downloadDate, String description, int imageId, String type) {
        super(user, date, destination, origin, price, title, loadDate, downloadDate, description, imageId);
        this.type = type;
    }

    public ShipmentAnnouncements(String origin, String destination) {
        super(origin,destination);
        this.type = "Other";
    }

    public String getType() {
        return type;
    }

    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        values.put(Contracts.shipmentAnnouncementEntry.title, this.getTitle());
        values.put(Contracts.shipmentAnnouncementEntry.description, this.getDescription());
        values.put(Contracts.shipmentAnnouncementEntry.type, this.type);
        values.put(Contracts.shipmentAnnouncementEntry.origin, this.getOrigin());
        values.put(Contracts.shipmentAnnouncementEntry.destination, this.getDestination());
        values.put(String.valueOf(Contracts.shipmentAnnouncementEntry.price), this.getPrice());
        values.put(String.valueOf(Contracts.shipmentAnnouncementEntry.imageID), this.getImageId());
        return values;
    }
}
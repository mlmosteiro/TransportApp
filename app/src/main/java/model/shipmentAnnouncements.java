package model;
/**
 *
 * Clase para anuncios de envío de la TransportApp
 *
 **/

import android.content.ContentValues;

import java.util.Date;



public class ShipmentAnnouncements extends Announcement {
    private String type;

    public ShipmentAnnouncements(int id, Users user, Date date, Location destination, Location origin, int price, String title, Date loadDate, Date downloadDate, String description, int imageId, String type) {
        super(id, user, date, destination, origin, price, title, loadDate, downloadDate, description, imageId);
        this.type = type;
    }

    public ShipmentAnnouncements(int id, Location origin, Location destination) {
        super(id, origin,destination);
        this.type = "Other";
    }

    public String getType() {
        return type;
    }

    //TODO guardar tambien las latitudes!!!
    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        values.put(Contracts.shipmentAnnouncementEntry.title, this.getTitle());
        values.put(Contracts.shipmentAnnouncementEntry.description, this.getDescription());
        values.put(Contracts.shipmentAnnouncementEntry.type, this.type);
        values.put(Contracts.shipmentAnnouncementEntry.origin, this.getOrigin().getName());
        values.put(Contracts.shipmentAnnouncementEntry.destination, this.getDestination().getName());
        values.put(String.valueOf(Contracts.shipmentAnnouncementEntry.price), this.getPrice());
        values.put(String.valueOf(Contracts.shipmentAnnouncementEntry.imageID), this.getImageId());
        return values;
    }
}
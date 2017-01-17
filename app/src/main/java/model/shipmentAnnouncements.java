package model;
/**
 *
 * Clase para anuncios de envío de la TransportApp
 *
 **/

import android.content.ContentValues;

import java.util.Date;

import model.typeVehicle.Type;


public class ShipmentAnnouncements extends Announcement {


    public ShipmentAnnouncements(Users user, Date date, Location destination, Location origin, int price, String title, Date loadDate, Date downloadDate, String description, int id, Type type) {
        super(user, date, destination, origin, price, title, loadDate, downloadDate, description, id, type);
    }

    public ShipmentAnnouncements(int id, Location origin, Location destination, Type type) {
        super(id, origin, destination, type);
    }

    //TODO guardar tambien las latitudes!!!
    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        values.put(Contracts.shipmentAnnouncementEntry.title, this.getTitle());
        values.put(Contracts.shipmentAnnouncementEntry.description, this.getDescription());
        values.put(Contracts.shipmentAnnouncementEntry.type, this.getType().getName());
        values.put(Contracts.shipmentAnnouncementEntry.origin, this.getOrigin().getName());
        values.put(Contracts.shipmentAnnouncementEntry.destination, this.getDestination().getName());
        values.put(String.valueOf(Contracts.shipmentAnnouncementEntry.price), this.getPrice());
        return values;
    }
}
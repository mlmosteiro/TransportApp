package model;
/**
 *
 * Clase para anuncios de envío de la TransportApp
 *
 **/

import java.util.Date;



public class shipmentAnnouncements extends announcements {
    private String type;

    public shipmentAnnouncements(users user, Date date, String destination, String origin, int price, String title, Date loadDate, Date downloadDate, String description, int imageId, String type) {
        super(user, date, destination, origin, price, title, loadDate, downloadDate, description, imageId);
        this.type = type;
    }

    public shipmentAnnouncements(String origin, String destination) {
        super(origin,destination);
        this.type = "Other";
    }

    public String getType() {
        return type;
    }
}
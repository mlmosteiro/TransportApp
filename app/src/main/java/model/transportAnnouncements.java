package model;
/**
 *
 * Clase para anuncios de transporte de la TransportApp
 *
 **/

import java.util.Date;

public class transportAnnouncements extends announcements {
    private String vhDetails;

    public transportAnnouncements(users user, Date date, String destination, String origin, int price, String title, Date loadDate, Date downloadDate, String description, int imageId, String vhDetails) {
        super(user, date, destination, origin, price, title, loadDate, downloadDate, description, imageId);
        this.vhDetails = vhDetails;
    }

    public transportAnnouncements(String origin, String destination, String vhDetails) {
        super(origin, destination);
        this.vhDetails = vhDetails;
    }

    public String getVhDetails() {
        return vhDetails;
    }
}
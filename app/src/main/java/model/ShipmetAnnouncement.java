package model;

import java.util.Date;

/**
 * Created by MaryLuz on 08/01/2017.
 */
public class ShipmetAnnouncement extends Announcement {
    private String type; //TODO codificar esto por un INT

    public ShipmetAnnouncement(String title, String origin, String destination, Date loadDate, Date downloadDate, Integer price, String description, int imageId, User user, Date publicationDate, String type) {
        super(title, origin, destination, loadDate, downloadDate, price, description, imageId, user, publicationDate);
        this.type = type;
    }

    public ShipmetAnnouncement(String origin, String destination, String type) {
        super(origin, destination);
        this.type = type;
    }
}

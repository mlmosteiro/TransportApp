package model;

import java.util.Date;

/**
 * Created by MaryLuz on 08/01/2017.
 */
public class TransportAnnouncement extends Announcement {

    private String vehicleDetails;

    public TransportAnnouncement(String title, String origin, String destination, Date loadDate, Date downloadDate, Integer price, String description, int imageId, User user, Date publicationDate, String vehicleDetails) {
        super(title, origin, destination, loadDate, downloadDate, price, description, imageId, user, publicationDate);
        this.vehicleDetails = vehicleDetails;
    }

    public TransportAnnouncement(String origin, String destination, String vehicleDetails) {
        super(origin, destination);
        this.vehicleDetails = vehicleDetails;
    }
}

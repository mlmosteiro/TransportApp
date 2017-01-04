package model;

import java.util.Date;

import erasmus.transportapp.R;

/**
 * Created by MaryLuz on 04/01/2017.
 */
public class Announcement {
    private String origin;
    private String destination;
    private Date loadDate;
    private Date downloadDate;
    private int imageId;

    public Announcement(String origin, String destination, Date loadDate, Date downloadDate, int imageId) {
        this.origin = origin;
        this.destination = destination;
        this.loadDate = loadDate;
        this.downloadDate = downloadDate;
        this.imageId = imageId;
    }

    public Announcement(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
        this.downloadDate = new Date(2017,12,11);
        this.loadDate = new Date(2017,01,11);
        this.imageId = R.drawable.ic_menu_my_announcements;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getLoadDate() {
        return loadDate;
    }

    public void setLoadDate(Date loadDate) {
        this.loadDate = loadDate;
    }

    public Date getDownloadDate() {
        return downloadDate;
    }

    public void setDownloadDate(Date downloadDate) {
        this.downloadDate = downloadDate;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}

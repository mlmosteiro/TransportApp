package model;

import java.util.Date;

import erasmus.transportapp.R;

/**
 * Created by MaryLuz on 04/01/2017.
 */
public abstract class Announcement {
    private String title;
    private String origin;
    private String destination;
    private Date loadDate;
    private Date downloadDate;
    private Integer price;
    private String description;
    private int imageId;
    private User user;
    private Date publicationDate;

    public Announcement(String title, String origin, String destination, Date loadDate, Date downloadDate, Integer price, String description, int imageId, User user, Date publicationDate) {
        this.title = title;
        this.origin = origin;
        this.destination = destination;
        this.loadDate = loadDate;
        this.downloadDate = downloadDate;
        this.price = price;
        this.description = description;
        this.imageId = imageId;
        this.user = user;
        this.publicationDate = publicationDate;
    }

    //TODO: Quitar esto en cuanto se pueda :D
    public Announcement(String origin, String destination) {
        this.title = "Título del anuncio :D";
        this.origin = origin;
        this.destination = destination;
        this.downloadDate = new Date(2017,12,11);
        this.loadDate = new Date(2017,01,11);
        this.description = new String("Blara blara to blara blara");
        this.imageId = R.drawable.ic_menu_my_announcements;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}

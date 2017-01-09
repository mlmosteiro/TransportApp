package model;

import java.util.Date;

/**
 * Created by MaryLuz on 08/01/2017.
 */
public class Proposal {

    private String id; //TODO asignar ID
    private Date loadDate;
    private Date downloadDate;
    private String description;
    private Integer price;
    private Integer state; //TODO mejorar esto

    public Proposal( Date loadDate, Date downloadDate, String description, Integer price, Integer state) {

        this.loadDate = loadDate;
        this.downloadDate = downloadDate;
        this.description = description;
        this.price = price;
        this.state = state;
    }

    public String getId() {
        return id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}

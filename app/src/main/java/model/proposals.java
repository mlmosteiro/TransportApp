package model; /**
 *
 * Clase definida para Proposals en TransportApp
 *
 **/

import android.content.ContentValues;

import java.util.Date;

public class Proposals {
    private Users user;
    private String idShipment;
    private String idTransport;
    private int price;
    private String description;
    private String state;
    private Date date;  //Fecha de envio de la propuesta para ordenarlas cronologicamente
    private Date loadDate;
    private Date downloadDate;

    public Proposals(Users user, String idShipment, String idTransport, int price, String description, String state, Date date, Date loadDate, Date downloadDate) {
        this.user = user;
        this.idShipment = idShipment;
        this.idTransport = idTransport;
        this.price = price;
        this.description = description;
        this.state = state;
        this.date = date;
        this.loadDate = loadDate;
        this.downloadDate = downloadDate;
    }

    public Users getUser(){
        return this.user;
    }

    public int getPrice(){
        return this.price;
    }

    public String getDescription(){
        return this.description;
    }

    public Date getDate(){
        return this.date;
    }

    public String getState(){
        return this.state;
    }

    public Date getLoadDate() {
        return loadDate;
    }

    public Date getDownloadDate() {
        return downloadDate;
    }

    public String getIdShipment(){
        return this.idShipment;
    }

    public String getIdTransport(){
        return this.idTransport;
    }

    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        values.put(Contracts.proposalsEntry.idShipment, idShipment);
        values.put(Contracts.proposalsEntry.idTransport, idTransport);
        values.put(Contracts.proposalsEntry.description, description);
        values.put(Contracts.proposalsEntry.price, price);
        values.put(Contracts.proposalsEntry.state, state);
        return values;
    }
}
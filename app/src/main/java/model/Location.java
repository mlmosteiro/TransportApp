package model;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by MaryLuz on 16/01/2017.
 */

public class Location {
    private LatLng latLng;
    private String name;

    public Location(LatLng latLng, String name) {
        this.latLng = latLng;
        this.name = name;
    }
    public Location(double latitud, double longitud, String name){
        this.latLng = new LatLng(latitud,longitud);
        this.name = name;
    }
    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package model.typeVehicle;

import erasmus.transportapp.R;


/**
 * Created by MaryLuz on 17/01/2017.
 * Mobile applications
 * TransportApp
 * Erasmus 2016-2017
 */

public abstract class Type {
    private String name;
    private Integer minValue;
    private Double mult;
    private int srcImage;

    public Type(String name, Integer minValue, Double mult, int srcImage) {
        this.name = name;
        this.minValue = minValue;
        this.mult = mult;
        this.srcImage = srcImage;
    }

    public Double getProgress(int barProgress){
        return minValue + (mult*barProgress);
    }

    public String getName() {
        return name;
    }

    public int getSrcImage() {
        return srcImage;
    }
}

package erasmus.transportapp;

import java.util.ArrayList;

import model.Announcement;

/**
 * Created by MaryLuz on 16/01/2017.
 * Mobile applications
 * TransportApp
 * Erasmus 2016-2017
 */
public class Contents {
    private static Contents ourInstance = new Contents();

    private ArrayList<Announcement> announcementsList;
    public static String ANNOUNCEMENT_POSSITION = "ANNOUNCEMENT_POSSITION";

    public static Contents getInstance() {
        return ourInstance;
    }

    public Contents() {
        announcementsList = new ArrayList<>();
    }

    public static Contents getOurInstance() {
        return ourInstance;
    }

    public static void setOurInstance(Contents ourInstance) {
        Contents.ourInstance = ourInstance;
    }

    public ArrayList<Announcement> getAnnouncementsList() {
        return announcementsList;
    }

    public void setAnnouncementsList(ArrayList<Announcement> announcementsList) {
        this.announcementsList = announcementsList;
    }


}

package model;

import java.util.ArrayList;

/**
 * Created by MaryLuz on 08/01/2017.
 */
public class User {
    private String userName;
    private String password; //TODO: Cambiar esto a algo seguro xD
    private String name;
    private ArrayList <Announcement> publications;
    private ArrayList <Proposal> proposals;

    public User(String userName, String password, String name) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.publications = new ArrayList<>();
        this.proposals = new ArrayList<>();
    }


}

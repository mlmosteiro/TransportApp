package model;
/**
 *
 * Clase para usuarios de la TransportApp
 *
 **/

import java.util.ArrayList;
import java.util.Date; ;

public class users {
    private String nickname;    // FK on DB
    private String pswd;
    private String name;
    private String surname;
    private String mail;
    private ArrayList <announcements> publications;
    private ArrayList <proposals> proposals;

    public users(String nickname, String pswd, String name, String surname, String mail){
        this.nickname = nickname;
        this.pswd = pswd;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.publications = new ArrayList<>();
        this.proposals = new ArrayList<>();
    }

    public users(String nickname){
        this.nickname = nickname;
        this.pswd = "hello";
        this.name = "Nombre";
        this.surname = "Apellido";
        this.mail = "foo@example.com";
        this.publications = new ArrayList<>();
        this.proposals = new ArrayList<>();
    }
    public String getNickname() {
        return nickname;
    }

    public String getPswd(){
        return this.pswd;
    }

    public String getMail(){
        return this.mail;
    }

    public String getName(){
        return this.name +  " " + this.surname;
    }

    public String toString(){
        return "User: " + this.nickname;
    }

    public ArrayList<announcements> getPublications() {
        return publications;
    }

    public ArrayList<proposals> getProposals() {
        return proposals;
    }
}
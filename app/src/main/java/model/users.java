package model;
/**
 *
 * Clase para usuarios de la TransportApp
 *
 **/

import android.content.ContentValues;

import java.util.ArrayList;
;

public class Users {
    private String nickname;
    private String pswd;
    private String name;
    private String surname;
    private String mail;
    private ArrayList <Announcements> publications;
    private ArrayList <Proposals> proposals;

    public Users(String nickname, String pswd, String name, String surname, String mail){
        this.nickname = nickname;
        this.pswd = pswd;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.publications = new ArrayList<>();
        this.proposals = new ArrayList<>();
    }

    public Users(String nickname){
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

    public ArrayList<Announcements> getPublications() {
        return publications;
    }

    public ArrayList<Proposals> getProposals() {
        return proposals;
    }

    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        values.put(Contracts.usersEntry.nickname, this.nickname);
        values.put(Contracts.usersEntry.pswd, this.pswd);
        values.put(Contracts.usersEntry.name, this.name);
        values.put(Contracts.usersEntry.surname, this.surname);
        values.put(Contracts.usersEntry.mail, this.mail);
        return values;
    }
}
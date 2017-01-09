package com.example.adrinbeda.testsqlite; /**
 *
 * Clase para usuarios de la TransportApp
 *
 **/

import java.util.Date; ;

public class users {
    private String nickname;    // FK on DB
    private String pswd;
    private String name;
    private String surname;
    private String mail;

    public users(String nickname, String pswd, String name, String surname, String mail){
        this.nickname = nickname;
        this.pswd = pswd;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
    }

    public String getNick(){
        return this.nickname;
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
}
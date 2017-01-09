package model;

import android.provider.BaseColumns;

import java.util.Date;

/**
 * Created by Adrián Úbeda on 09/01/2017.
 * Clase para definir el esquema de los users en la base de datos
 */

public class contracts {
    public static abstract class usersEntry implements BaseColumns {
        public static final String tableName = "users";
        public static final String nickname =  "nickname";
        public static final String pswd = "password";
        public static final String name = "name";
        public static final String surname = "surname";
        public static final String mail = "mail";
    }

    public static abstract class proposalsEntry implements BaseColumns {
        public static final String tableName = "proposals";
        // cambio el valor de user por un string nickname?
        //public static final users = users;
        public static final int price = 0;
        public static final String description = "None";
        public static final String state = "None";
        public static final Date date = new Date(82,4,1,10,30,15);

    }
}

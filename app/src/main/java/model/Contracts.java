package model;

import android.provider.BaseColumns;

import java.util.Date;

/**
 * Created by Adrián Úbeda on 09/01/2017.
 * Clase para definir el esquema de las clases en la base de datos.
 */

public class Contracts {
    public static abstract class usersEntry implements BaseColumns {
        public static final String tableName = "Users";
        public static final String nickname =  "nickname";
        public static final String pswd = "password";
        public static final String name = "name";
        public static final String surname = "surname";
        public static final String mail = "mail";
    }

    public static abstract class proposalsEntry implements BaseColumns {
        public static final String tableName = "Proposals";
        public static final String idShipment = "idShipment";
        public static final String idTransport = "idTransport";
        public static final Users user = new Users("Example");
        public static final int price = 0;
        public static final String description = "None";
        public static final String state = "None";
        public static final Date loadDate = java.sql.Date.valueOf("2017-01-01");
        public static final Date downloadDate = java.sql.Date.valueOf("2017-01-01");
    }

    public static abstract class shipmentAnnouncementEntry implements BaseColumns {
        public static final String tableName = "shipmentAnnouncement";
        public static final String title = "title";
        public static final String origin = "origin";
        public static final String destination = "destination";
        public static final Date loadDate = java.sql.Date.valueOf("2017-01-01");
        public static final Date downloadDate = java.sql.Date.valueOf("2017-01-10");
        public static final String description = "description";
        public static final Integer price = 0;
        public static final Integer imageId = 0;
        public static final Date publicationDate = java.sql.Date.valueOf("2017-01-10");
        public static final String type ="type";
        public static final Users user = new Users("Example");
    }

    public static abstract class transportAnnouncementEntry implements BaseColumns {
        public static final String tableName = "transportAnnouncements";
        public static final String title = "title";
        public static final String origin = "origin";
        public static final String destination = "destination";
        public static final Date loadDate = java.sql.Date.valueOf("2017-01-10");
        public static final Date downloadDate = java.sql.Date.valueOf("2017-01-10");
        public static final String description = "description";
        public static final Integer price = 0;
        public static final Integer imageId = 0;
        public static final Date publicationDate = java.sql.Date.valueOf("2017-01-10");
        public static final String vehicleDetails ="vehicleDetails";
        public static final Users user = new Users("Example");
    }

}

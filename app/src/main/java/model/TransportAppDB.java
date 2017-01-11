package model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.hardware.camera2.params.ColorSpaceTransform;

import java.util.Date;

/**
 * Created by Adrián Úbeda on 09/01/2017.
 * Base de datos para los usuarios, Proposals, anuncios(compra y venta).
 */

public class TransportAppDB extends SQLiteOpenHelper {
    private static final int version = 1;
    private static final String dbName = "TransportAppDB.db";

    private static final String createUsersTable = "CREATE TABLE " +
            Contracts.usersEntry.tableName + "(" + Contracts.usersEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            Contracts.usersEntry.nickname + " TEXT NOT NULL," +
            Contracts.usersEntry.pswd + " TEXT NOT NULL," +
            Contracts.usersEntry.mail + " TEXT NOT NULL,"+
            Contracts.usersEntry.name + " TEXT NOT NULL," +
            Contracts.usersEntry.surname + " TEXT NOT NULL)";

    private static final String createProposalsTable = "CREATE TABLE " +
            Contracts.proposalsEntry.tableName + "(" + Contracts.proposalsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            Contracts.proposalsEntry.idShipment + "TEXT NOT NULL, " +
            Contracts.proposalsEntry.idTransport + "TEXT NOT NULL, " +
            "FOREIGN KEY (" + Contracts.proposalsEntry.idShipment + ") REFERENCES " + Contracts.shipmentAnnouncementEntry.tableName + (Contracts.shipmentAnnouncementEntry._ID) + " ON DELETE CASCADE " +
            "FOREIGN KEY (" + Contracts.proposalsEntry.idTransport + ") REFERENCES " + Contracts.shipmentAnnouncementEntry.tableName + (Contracts.transportAnnouncementEntry._ID) + " ON DELETE CASCADE " +
            Contracts.proposalsEntry.description + "TEXT NOT NULL," +
            Contracts.proposalsEntry.state + "TEXT NOT NULL," +
            Contracts.proposalsEntry.price + "INTEGER," +
            Contracts.proposalsEntry.downloadDate + "TEXT," +
            Contracts.proposalsEntry.loadDate + "TEXT)";

    private static final String createShipmentAnnouncementTable = "CREATE TABLE " +
            Contracts.shipmentAnnouncementEntry.tableName + "(" + Contracts.shipmentAnnouncementEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            Contracts.shipmentAnnouncementEntry.user + "TEXT NOT NULL," +
            "FOREIGN KEY (" + Contracts.shipmentAnnouncementEntry.user + ") REFERENCES " + Contracts.usersEntry.tableName + (Contracts.usersEntry._ID) + " ON DELETE CASCADE " +
            Contracts.shipmentAnnouncementEntry.description + "TEXT NOT NULL, " +
            Contracts.shipmentAnnouncementEntry.title + "TEXT NOT NULL, " +
            Contracts.shipmentAnnouncementEntry.origin + "TEXT NOT NULL, " +
            Contracts.shipmentAnnouncementEntry.destination + "TEXT NOT NULL, " +
            Contracts.shipmentAnnouncementEntry.type + "TEXT NOT NULL, " +
            Contracts.shipmentAnnouncementEntry.price + "INTEGER, " +
            Contracts.shipmentAnnouncementEntry.publicationDate + "TEXT NOT NULL, " +
            Contracts.shipmentAnnouncementEntry.downloadDate + "TEXT NOT NULL, " +
            Contracts.shipmentAnnouncementEntry.loadDate + "TEXT NOT NULL)";

    private static String createTransportAnnouncementTable = "CREATE TABLE " +
            Contracts.transportAnnouncementEntry.tableName + "(" + Contracts.transportAnnouncementEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            Contracts.shipmentAnnouncementEntry.user + "TEXT NOT NULL, " +
            "FOREIGN KEY (" + Contracts.shipmentAnnouncementEntry.user + ") REFERENCES " + Contracts.usersEntry.tableName + Contracts.usersEntry._ID + "ON DELETE CASCADE " +
            Contracts.transportAnnouncementEntry.description + "TEXT NOT NULL, " +
            Contracts.transportAnnouncementEntry.title + "TEXT NOT NULL, " +
            Contracts.transportAnnouncementEntry.origin + "TEXT NOT NULL, " +
            Contracts.transportAnnouncementEntry.destination + "TEXT NOT NULL, " +
            Contracts.transportAnnouncementEntry.vehicleDetails + "TEXT NOT NULL, " +
            Contracts.transportAnnouncementEntry.price + "INTEGER, " +
            Contracts.transportAnnouncementEntry.publicationDate + "TEXT NOT NULL, " +
            Contracts.transportAnnouncementEntry.downloadDate + "TEXT NOT NULL, " +
            Contracts.transportAnnouncementEntry.loadDate + "TEXT NOT NULL)";

    public TransportAppDB(Context context) {
        super(context, dbName, null, version);
    }

    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            // Enable foreign key constraints
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createUsersTable);
        db.execSQL(createProposalsTable);
        db.execSQL(createShipmentAnnouncementTable);
        db.execSQL(createTransportAnnouncementTable);

        //testDB(db);
    }

    // método para crear algunos usuarios, y propuestas para testeo de db.
    private void testDB (SQLiteDatabase dataBase) {
        Users user1 = new Users("FVazquez", "password", "Francisco", "Vázquez", "mudo@example.com");
        Users user2 = new Users("AMartin", "password", "Alvaro",  "Martin", "amartin@example.com");
        Users user3 = new Users("IscoRoman", "password", "Francisco", "Alarcon", "falarcon@example.com");

        insertUserOnDB(dataBase, user1);
        insertUserOnDB(dataBase, user2);
        insertUserOnDB(dataBase, user3);

        insertProposalOnDB(dataBase, new Proposals(user1, "2", null, 240, "lorem ipsum", "ordered", new Date(2000), new Date(2323), new Date(23424)));
        insertProposalOnDB(dataBase, new Proposals(user2, "2", null, 679, "lorem ipsum", "waiting payment", new Date(345), new Date(567), new Date(23424)));
        insertProposalOnDB(dataBase, new Proposals(user3, "2", null, 45, "lorem ipsum", "ordered", new Date(45435), new Date(6587), new Date(23424)));
    }

    private long insertUserOnDB(SQLiteDatabase dataBase, Users user) {
        return dataBase.insert(Contracts.usersEntry.tableName, null, user.toContentValues());
    }

    private long insertProposalOnDB(SQLiteDatabase database, Proposals proposal){
        return database.insert(Contracts.proposalsEntry.tableName, null, proposal.toContentValues());
    }

    private long insertShipmentAnnouncementOnDb(SQLiteDatabase database, ShipmentAnnouncements announcement){
        return database.insert(Contracts.shipmentAnnouncementEntry.tableName, null, announcement.toContentValues());
    }

    private long insertTransportAnnouncementOnDb(SQLiteDatabase database, TransportAnnouncements announcement) {
        return database.insert(Contracts.transportAnnouncementEntry.tableName, null, announcement.toContentValues());
    }

    //método para eliminar a un user por su nick.
    private void removeFromUserDB(SQLiteDatabase database, Users user) {
        database.delete(Contracts.usersEntry.tableName, Contracts.usersEntry.nickname + user.getNickname(),null);
    }

    // método para añadir un elemento indicado a la base de datos
    private void updateUserDB(SQLiteDatabase database, Users user) {
        ContentValues values = user.toContentValues();
        database.update(Contracts.usersEntry.tableName, values, null, null);
    }

    // test para probar nuevos métodos remove y update.
    private void testRemoveUpdateDB(SQLiteDatabase database) {
        Users user = new Users("FVazquez", "password", "Francisco", "Vázquez", "mudo@example.com");
        removeFromUserDB(database, user);
        Users user1 = new Users("FranciscoVazquez", "password", "Francisco", "Vázquez", "mudo@example.com");
        updateUserDB(database, user1);
    }

    // método para obtener una base de datos.
    public Cursor getTable(SQLiteDatabase database, String contractTableName){
        // getTable(dataBase, ContractsUserEntry.nameTable);
        // 2 son columnas, 3 seccion, 4 seleccion de argumento.
        Cursor c = database.query(contractTableName, null, null, null, null, null, null, null);
        return c;
    }

    //Coge todos los elementos de una base de datos dada
    public Cursor getAll(String contractTableName) {
        return getReadableDatabase().query(contractTableName, null, null, null, null, null, null);
    }

    //selecciona por el Id que le pases como String.
    public Cursor getById(String contractTableName, String id){
        Cursor c = getReadableDatabase().query(contractTableName, null, null,  new String[]{id}, null, null, null);
        return c;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}

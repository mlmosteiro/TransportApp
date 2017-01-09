package model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Adrián Úbeda on 09/01/2017.
 * Base de datos para los usuarios, proposals, anuncios(compra y venta).
 */

public class userDB extends SQLiteOpenHelper {
    private static final int version = 1;
    private static final String dbName = "users.db";


    /*
    CREATE TABLE USERS (
        userID INTEGER PRIMARY KEY AUTOINCREMENT,
        nickname TEXT NOT NULL,
        pswd  TEXT NOT NULL,
        mail TEXT NOT NULL)
        name TEXT NOT NULL,
        surname  TEXT NOT NULL,
     */

    private static final String createUsersTable = "CREATE TABLE " +
            contracts.usersEntry.tableName + "(" + contracts.usersEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            contracts.usersEntry.nickname + " TEXT NOT NULL," +
            contracts.usersEntry.pswd + " TEXT NOT NULL," +
            contracts.usersEntry.mail + " TEXT NOT NULL,"+
            contracts.usersEntry.name + " TEXT NOT NULL," +
            contracts.usersEntry.surname + " TEXT NOT NULL)";

    /*
        CREATE TABLE PROPOSALS (
            proposalID INTEGER PRIMARY KEY AUTOINCREMENT,
            user String FOREIGN KEY --BLABLABA, no se como se pone--,
            description TEXT NOT NULL,
            state TEXT NOT NULL,
            price INTEGER,
            date DATE)";
     */
    /*TODO cambiar el id de propuestas, en lugar de contracts.userEntry deberia ir contracts.announcementEntry(?) y añadir el usuario como un string, sí*/

    private static final String createProposalsTable = "CREATE TABLE " +
            contracts.proposalsEntry.tableName + "(" +contracts.usersEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            // aquí iría el user que es fk, yo creo que mejor String...
            contracts.proposalsEntry.description + " TEXT NOT NULL," +
            contracts.proposalsEntry.state + " TEXT NOT NULL," +
            contracts.proposalsEntry.price + " INTEGER," +
            contracts.proposalsEntry.date + " DATE)";

    public userDB(Context context) {
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
       // db.execSQL(createProposalsTable); //COMENTADA PORQUE HAY ATRIBUTOS QUE AUN NO TIENE DEFINIDOS, Y EL COMPILADOR PETA :P
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}

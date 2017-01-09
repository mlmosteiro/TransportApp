package com.example.adrinbeda.testsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Adrián Úbeda on 09/01/2017.
 * Base de datos para los usuarios, proposals, anuncios(compra y venta).
 */

public class userDB extends SQLiteOpenHelper {
    private static final int version = 1;
    private static final String dbName = "users.db";

    private static final String createUsersTable = "CREATE TABLE " +
            contracts.usersEntry.tableName + "(" + contracts.usersEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            contracts.usersEntry.nickname + "TEXT NOT NULL," +
            contracts.usersEntry.name + "TEXT NOT NULL," +
            contracts.usersEntry.pswd + "TEXT NOT NULL," +
            contracts.usersEntry.surname + "TEXT NOT NULL," +
            contracts.usersEntry.mail + "TEXT NOT NULL,";

    private static final String createProposalsTable = "CREATE TABLE " +
            contracts.proposalsEntry.tableName + "(" +contracts.usersEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            // aquí iría el user que es fk, yo creo que mejor String...
            contracts.proposalsEntry.description + "TEXT NOT NULL," +
            contracts.proposalsEntry.state + "TEXT NOT NULL," +
            contracts.proposalsEntry.price + "INTEGER," +
            contracts.proposalsEntry.date + "DATE,";

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
        db.execSQL(createProposalsTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}

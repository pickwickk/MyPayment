package com.example.mypayment.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.mypayment.model.Paiement;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by Guylain on 16/05/2016.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private Dao<Paiement, Integer> paiementDao = null;

    public DatabaseHelper(Context context) {
        super(context, "MyPaiement.db", null, 1);
    }

    public Dao<Paiement, Integer> getPaiementDao() throws SQLException {
        if (paiementDao == null) {
            paiementDao = getDao(Paiement.class);
        }
        return paiementDao;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            Log.d("", "Tables created in %s", null);
            TableUtils.createTable(connectionSource, Paiement.class);
        } catch (SQLException e) {
            Log.e("", "Can't create database", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {

    }

    /**
     * Close the database connections and clear any cached DAOs.
     */
    @Override
    public void close() {
        super.close();
        paiementDao = null;
    }


}

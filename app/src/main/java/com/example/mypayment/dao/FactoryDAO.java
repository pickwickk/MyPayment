package com.example.mypayment.dao;

import android.content.Context;

import com.j256.ormlite.android.apptools.OpenHelperManager;

/**
 * Created by gverouda on 20/05/2016.
 */
public class FactoryDAO {
    private static DatabaseHelper mFactoryDAO;
    
    public static DatabaseHelper getInstance(Context context){
        if(mFactoryDAO == null){
            mFactoryDAO = OpenHelperManager.getHelper(context,
                    DatabaseHelper.class);
        }
        return mFactoryDAO;
    }


}

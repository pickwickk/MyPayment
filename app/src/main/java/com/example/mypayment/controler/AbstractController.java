package com.example.mypayment.controler;

import android.content.Context;

/**
 * Created by Guylain on 25/06/2016.
 */
public abstract class AbstractController extends ConstantesUtil {

    protected static Context mContext;

    public static void setContext(Context aContext){
        if(aContext != null) {
            mContext = aContext;
        }
    }

}

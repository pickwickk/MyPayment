package com.example.mypayment.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mypayment.controler.AbstractController;

/**
 * Created by Guylain on 25/06/2016.
 */
public abstract class AbstractActivity extends AppCompatActivity {

    protected void initialisationContexte(Context aContext) {
        AbstractController.setContext(aContext);
    }
}

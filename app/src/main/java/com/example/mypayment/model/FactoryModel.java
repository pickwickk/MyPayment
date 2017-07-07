package com.example.mypayment.model;

import com.example.mypayment.model.Paiement;
import com.example.mypayment.model.TypePaiement;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Guylain on 24/06/2016.
 */
public class FactoryModel {

    public static Paiement getPaiement() {
        return new Paiement();
    }

    public static Paiement getPaiement(String aLibelle, Double aMontant, TypePaiement aTypePaiement, Calendar aDateDuPaiement) {
        Paiement lPaiement = getPaiement();
        lPaiement.setMontant(aMontant);
        lPaiement.setLibelle(aLibelle);
        lPaiement.setTypeDePaiement(aTypePaiement);
        lPaiement.setDatePaiement(aDateDuPaiement.getTime());
        return lPaiement;
    }

}
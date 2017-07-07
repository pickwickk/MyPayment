package com.example.mypayment.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.EnumSet;
import java.util.List;

/**
 * Created by Guylain on 22/05/2016.
 */
public enum Mois {
    JANVIER(Calendar.JANUARY,"JANVIER"),
    FEVRIER(Calendar.FEBRUARY,"FEVRIER"),
    MARS(Calendar.MARCH,"MARS"),
    AVRIL(Calendar.APRIL,"AVRIL"),
    MAI(Calendar.MAY,"MAI"),
    JUIN(Calendar.JUNE,"JUIN"),
    JUILLET(Calendar.JULY,"JUILLET"),
    AOUT(Calendar.AUGUST,"AOUT"),
    SEPTEMBRE(Calendar.SEPTEMBER,"SEPTEMBRE"),
    OCTOBRE(Calendar.OCTOBER,"OCTOBRE"),
    NOVEMBRE(Calendar.NOVEMBER,"NOVEMBRE"),
    DECEMBRE(Calendar.DECEMBER,"DECEMBRE"),
    INDEFINI(Calendar.UNDECIMBER,"");

    private Integer mNumeroMois;
    private String mLabel;

    private Mois(Integer aNumeroMois,String aLabel){
        this.mNumeroMois = aNumeroMois;
        this.mLabel = aLabel;
    }

    public Integer getNumeroMois(){
        return this.mNumeroMois;
    }

    public String getLabel(){
        return this.mLabel;
    }

    public static Mois convert(Integer aNumeroMois){
        List<Mois> lListeMois = new ArrayList<Mois>( EnumSet.allOf(Mois.class));
        Boolean lTrouve = false;
        Integer lNombreDeMois = 0;
        Mois lTypeMois = Mois.INDEFINI;
        if(aNumeroMois != null && lListeMois != null ) {
            while (!lTrouve && lNombreDeMois < lListeMois.size()) {
                Mois lMois = lListeMois.get(lNombreDeMois);
                if (lMois.getNumeroMois().equals(aNumeroMois)) {
                    lTypeMois = lMois;
                    lTrouve = true;
                }
                lNombreDeMois++;
            }
        }
        return lTypeMois;
    }

    public static Mois convert(String aLabel){
        List<Mois> lListeMois = new ArrayList<Mois>( EnumSet.allOf(Mois.class));
        Boolean lTrouve = false;
        Integer lNombreDeMois = 0;
        Mois lTypeMois = Mois.INDEFINI;
        if(aLabel != null && lListeMois != null ) {
            String lLabel = aLabel.toUpperCase();
            while (!lTrouve && lNombreDeMois < lListeMois.size()) {
                Mois lMois = lListeMois.get(lNombreDeMois);
                if (lMois.getLabel().equals(lLabel)) {
                    lTypeMois = lMois;
                    lTrouve = true;
                }
                lNombreDeMois++;
            }
        }
        return lTypeMois;
    }

}

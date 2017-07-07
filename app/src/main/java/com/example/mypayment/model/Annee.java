package com.example.mypayment.model;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * Created by Guylain on 22/05/2016.
 */

public enum Annee {
    ANNEE_2016(2016),
    ANNEE_2017(2017),
    ANNEE_2018(2018),
    ANNEE_2019(2019),
    INDEFINI(0);


    private Integer mAnnee;

    private Annee(Integer aAnnee){
        this.mAnnee = aAnnee;
    }

    public Integer getAnnee(){
        return this.mAnnee;
    }

    public static Annee convert(Integer aAnnee){
        List<Annee> lListeAnnee = new ArrayList<Annee>( EnumSet.allOf(Annee.class));
        Boolean lTrouve = false;
        Integer lNombreDeAnnee = 0;
        Annee lTypeAnnee = Annee.INDEFINI;
        if(aAnnee != null && lListeAnnee != null ) {
            while (!lTrouve && lNombreDeAnnee < lListeAnnee.size()) {
                Annee lAnnee = lListeAnnee.get(lNombreDeAnnee);
                if (lAnnee.getAnnee().equals(aAnnee)) {
                    lTypeAnnee = lAnnee;
                    lTrouve = true;
                }
                lNombreDeAnnee++;
            }
        }
        return lTypeAnnee;
    }

}

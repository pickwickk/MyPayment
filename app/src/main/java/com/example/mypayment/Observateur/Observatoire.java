package com.example.mypayment.Observateur;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guylain on 24/05/2016.
 */
public class Observatoire {
    public static List<Observateur> mListObservateur;

    public static void addObservateur(Observateur aObservateur){
        if(mListObservateur == null){
            mListObservateur = new ArrayList<Observateur>();
        }
        mListObservateur.add(aObservateur);
    }

    public static void nouveauPaiement(Integer aAnneeDuPaiement,Integer aMoisDuPaiement){
        if(mListObservateur !=null) {
            for (Observateur lObservateur :mListObservateur){
                lObservateur.nouveauPaiement(aAnneeDuPaiement,aMoisDuPaiement);
            }
        }
    }

}

package com.example.mypayment.util;

import android.support.annotation.IdRes;
import android.widget.RadioButton;

import com.example.mypayment.R;
import com.example.mypayment.model.Annee;
import com.example.mypayment.model.Mois;

/**
 * Created by gverouda on 25/05/2016.
 */
public class ConsultationViewUtil {

    public static @IdRes Integer idRadioButtonMois(Integer aMois){
        @IdRes Integer lIdRadioButtonMois = null;
        if(aMois != null) {
            Mois lMoisChoisi = Mois.convert(aMois);
            switch (lMoisChoisi) {
                case JANVIER:
                    lIdRadioButtonMois = R.id.janvier;
                    break;
                case FEVRIER:
                    lIdRadioButtonMois = R.id.fevrier;
                    break;
                case MARS:
                    lIdRadioButtonMois = R.id.mars;
                    break;
                case AVRIL:
                    lIdRadioButtonMois = R.id.avril;
                    break;
                case MAI:
                    lIdRadioButtonMois = R.id.mai;
                    break;
                case JUIN:
                    lIdRadioButtonMois = R.id.juin;
                    break;
                case JUILLET:
                    lIdRadioButtonMois = R.id.juillet;
                    break;
                case AOUT:
                    lIdRadioButtonMois = R.id.aout;
                    break;
                case SEPTEMBRE:
                    lIdRadioButtonMois = R.id.septembre;
                    break;
                case OCTOBRE:
                    lIdRadioButtonMois = R.id.octobre;
                    break;
                case NOVEMBRE:
                    lIdRadioButtonMois = R.id.novembre;
                    break;
                case DECEMBRE:
                    lIdRadioButtonMois = R.id.decembre;
                    break;
                case INDEFINI:
                    break;
            }
        }

        return lIdRadioButtonMois;
    }

    public static @IdRes Integer idRadioButtonAnnee(Integer aAnnee){
        @IdRes Integer lIdRadioButtonAnnee = null;
        if(aAnnee != null) {
            Annee lAnneeChoisi = Annee.convert(aAnnee);
            switch (lAnneeChoisi) {
                case ANNEE_2016:
                    lIdRadioButtonAnnee = R.id.annee_2016;
                    break;
                case ANNEE_2017:
                    lIdRadioButtonAnnee = R.id.annee_2017;
                    break;
                case ANNEE_2018:
                    lIdRadioButtonAnnee = R.id.annee_2018;
                    break;
                case ANNEE_2019:
                    lIdRadioButtonAnnee = R.id.annee_2019;
                    break;
                case INDEFINI:
                    break;
            }
        }
        return lIdRadioButtonAnnee;
    }
}

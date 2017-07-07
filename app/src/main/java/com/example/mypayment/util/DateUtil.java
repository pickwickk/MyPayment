package com.example.mypayment.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Guylain on 22/05/2016.
 */
public class DateUtil {

    public static Calendar getDate(Integer aJour, Integer aAnnee, Integer aMois, Moment aMoment){
        Calendar lCalendarARetourner = dateDuJour();

        if(aMoment!=null) {
            switch (aMoment) {
                case MATIN_00h00:
                    lCalendarARetourner = datePerso(0,0,0,0);
                    break;
                case SOIR_23h59:
                    lCalendarARetourner = datePerso(23,59,59,59);
                    break;
                default :
                    break;
            }
            if(aAnnee!=null) {
                lCalendarARetourner.set(Calendar.YEAR, aAnnee);
            }
            if(aMois!=null) {
                lCalendarARetourner.set(Calendar.MONTH, aMois);
            }
            if(aJour != null){
                lCalendarARetourner.set(Calendar.DAY_OF_MONTH,aJour);
            }

        }
        return lCalendarARetourner;
    }

    public static Calendar dateDuJour(){
        Calendar lCalendar = Calendar.getInstance();
        return lCalendar;
    }


    private static Calendar datePerso(Integer aHeur,Integer aMinute, Integer aSeconde,Integer aMilliseconde){
        Calendar lCalendar = Calendar.getInstance();
        lCalendar.set(Calendar.HOUR_OF_DAY, aHeur);
        lCalendar.set(Calendar.MINUTE, aMinute);
        lCalendar.set(Calendar.SECOND, aSeconde);
        lCalendar.set(Calendar.MILLISECOND, aMilliseconde);
        return lCalendar;
    }

    public static String getFormattedDate(Calendar aCalendar,String aFormatDate){
        if(aCalendar == null) {
            aCalendar = Calendar.getInstance();
        }
        SimpleDateFormat lFormat = new SimpleDateFormat(aFormatDate);
        String formatted = lFormat.format(aCalendar.getTime());
        return formatted;
    }

    public enum Moment{
        MATIN_00h00,
        SOIR_23h59;
    }


}

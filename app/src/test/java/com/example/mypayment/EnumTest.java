package com.example.mypayment;

import android.support.annotation.IdRes;

import com.example.mypayment.model.Annee;
import com.example.mypayment.model.Mois;
import com.example.mypayment.model.TypePaiement;
import com.example.mypayment.util.ConsultationViewUtil;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class EnumTest {

    @Test
    public void testEnumAnneeConvert2016() throws Exception {
        Annee lAnnee = Annee.convert(2016);
        assertEquals(lAnnee,Annee.ANNEE_2016);
    }

    @Test
    public void testEnumAnneeConvert2017() throws Exception {
        Annee lAnnee = Annee.convert(2017);
        assertEquals(lAnnee,Annee.ANNEE_2017);
    }

    @Test
    public void testEnumAnneeConvert2018() throws Exception {
        Annee lAnnee = Annee.convert(2018);
        assertEquals(lAnnee,Annee.ANNEE_2018);
    }

    @Test
    public void testEnumAnneeConvert2019() throws Exception {
        Annee lAnnee = Annee.convert(2019);
        assertEquals(lAnnee,Annee.ANNEE_2019);
    }

    @Test
    public void testEnumAnneeConvertNull() throws Exception {
        Annee lAnnee = Annee.convert(null);
        assertEquals(lAnnee,Annee.INDEFINI);
    }

    @Test
    public void testEnumAnneeConvertNonDefini() throws Exception {
        Annee lAnnee = Annee.convert(5);
        assertEquals(lAnnee,Annee.INDEFINI);
    }

    @Test
    public void testEnumMoisConvertJanvierCalendar() throws Exception {
        Mois lMois = Mois.convert(Calendar.JANUARY);
        assertEquals(lMois,Mois.JANVIER);
    }

    @Test
    public void testEnumMoisConvertJanvier() throws Exception {
        Mois lMois = Mois.convert("JANVIER");
        assertEquals(lMois,Mois.JANVIER);
    }

    @Test
    public void testEnumMoisConvertFevrierCalendar() throws Exception {
        Mois lMois = Mois.convert(Calendar.FEBRUARY);
        assertEquals(lMois,Mois.FEVRIER);
    }

    @Test
    public void testEnumMoisConvertFevrier() throws Exception {
        Mois lMois = Mois.convert("FEVRIER");
        assertEquals(lMois,Mois.FEVRIER);
    }

    @Test
    public void testEnumMoisConvertMarsCalendar() throws Exception {
        Mois lMois = Mois.convert(Calendar.MARCH);
        assertEquals(lMois,Mois.MARS);
    }

    @Test
    public void testEnumMoisConvertMars() throws Exception {
        Mois lMois = Mois.convert("MARS");
        assertEquals(lMois,Mois.MARS);
    }

    @Test
    public void testEnumMoisConvertAvrilCalendar() throws Exception {
        Mois lMois = Mois.convert(Calendar.APRIL);
        assertEquals(lMois,Mois.AVRIL);
    }

    @Test
    public void testEnumMoisConvertAvril() throws Exception {
        Mois lMois = Mois.convert("AVRIL");
        assertEquals(lMois,Mois.AVRIL);
    }

    @Test
    public void testEnumMoisConvertMaiCalendar() throws Exception {
        Mois lMois = Mois.convert(Calendar.MAY);
        assertEquals(lMois,Mois.MAI);
    }

    @Test
    public void testEnumMoisConvertMai() throws Exception {
        Mois lMois = Mois.convert("MAI");
        assertEquals(lMois,Mois.MAI);
    }

    @Test
    public void testEnumMoisConvertJuinCalendar() throws Exception {
        Mois lMois = Mois.convert(Calendar.JUNE);
        assertEquals(lMois,Mois.JUIN);
    }

    @Test
    public void testEnumMoisConvertJuin() throws Exception {
        Mois lMois = Mois.convert("JuIN");
        assertEquals(lMois,Mois.JUIN);
    }

    @Test
    public void testEnumMoisConvertJuilletCalendar() throws Exception {
        Mois lMois = Mois.convert(Calendar.JULY);
        assertEquals(lMois,Mois.JUILLET);
    }

    @Test
    public void testEnumMoisConvertJuillet() throws Exception {
        Mois lMois = Mois.convert("JUIlLET");
        assertEquals(lMois,Mois.JUILLET);
    }

    @Test
    public void testEnumMoisConvertAoutCalendar() throws Exception {
        Mois lMois = Mois.convert(Calendar.AUGUST);
        assertEquals(lMois,Mois.AOUT);
    }

    @Test
    public void testEnumMoisConvertAout() throws Exception {
        Mois lMois = Mois.convert("aout");
        assertEquals(lMois,Mois.AOUT);
    }

    @Test
    public void testEnumMoisConvertSeptembreCalendar() throws Exception {
        Mois lMois = Mois.convert(Calendar.SEPTEMBER);
        assertEquals(lMois,Mois.SEPTEMBRE);
    }

    @Test
    public void testEnumMoisConvertSeptembre() throws Exception {
        Mois lMois = Mois.convert("SEPTEMBRE");
        assertEquals(lMois,Mois.SEPTEMBRE);
    }

    @Test
    public void testEnumMoisConvertOctobreCalendar() throws Exception {
        Mois lMois = Mois.convert(Calendar.OCTOBER);
        assertEquals(lMois,Mois.OCTOBRE);
    }

    @Test
    public void testEnumMoisConvertOctobre() throws Exception {
        Mois lMois = Mois.convert("OCTOBRE");
        assertEquals(lMois,Mois.OCTOBRE);
    }

    @Test
    public void testEnumMoisConvertNovembreCalendar() throws Exception {
        Mois lMois = Mois.convert(Calendar.NOVEMBER);
        assertEquals(lMois,Mois.NOVEMBRE);
    }

    @Test
    public void testEnumMoisConvertNovembre() throws Exception {
        Mois lMois = Mois.convert("NOVEMBRE");
        assertEquals(lMois,Mois.NOVEMBRE);
    }

    @Test
    public void testEnumMoisConvertDecembreCalendar() throws Exception {
        Mois lMois = Mois.convert(Calendar.DECEMBER);
        assertEquals(lMois,Mois.DECEMBRE);
    }

    @Test
    public void testEnumMoisConvertDecembre() throws Exception {
        Mois lMois = Mois.convert("decembre");
        assertEquals(lMois,Mois.DECEMBRE);
    }

    @Test
    public void testEnumMoisConvertUndecimberString() throws Exception {
        String lNull = null;
        Mois lMois = Mois.convert(lNull);
        assertEquals(lMois,Mois.INDEFINI);
    }

    @Test
    public void testEnumMoisConvertUndecimberInteger() throws Exception {
        Integer lNull = null;
        Mois lMois = Mois.convert(lNull);
        assertEquals(lMois,Mois.INDEFINI);
    }

    @Test
    public void testEnumTypePaiementConvertCarteBleu() throws Exception {
        TypePaiement lTypePaiement = TypePaiement.convert("carte_bleu");
        assertEquals(lTypePaiement,TypePaiement.CB);
    }

    @Test
    public void testEnumTypePaiementConvertCheque() throws Exception {
        TypePaiement lTypePaiement = TypePaiement.convert("cheque");
        assertEquals(lTypePaiement,TypePaiement.Cheque);
    }

    @Test
    public void testEnumTypePaiementConvertArgentLiquide() throws Exception {
        TypePaiement lTypePaiement = TypePaiement.convert("argent_liquide");
        assertEquals(lTypePaiement,TypePaiement.Espece);
    }

    @Test
    public void testEnumTypePaiementConvertNull() throws Exception {
        TypePaiement lTypePaiement = TypePaiement.convert(null);
        assertEquals(lTypePaiement,TypePaiement.Indefini);
    }

    @Test
    public void testEnumTypePaiementConvertIntrouvable() throws Exception {
        TypePaiement lTypePaiement = TypePaiement.convert("blablabla");
        assertEquals(lTypePaiement,TypePaiement.Indefini);
    }

}
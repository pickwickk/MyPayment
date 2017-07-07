package com.example.mypayment;

import android.support.annotation.IdRes;

import com.example.mypayment.util.ConsultationViewUtil;
import com.example.mypayment.util.DateUtil;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ConsultationViewUtilTest {

    @Test
    public void testRecuperationIdJanvier() throws Exception {
        @IdRes Integer id = ConsultationViewUtil.idRadioButtonMois(Calendar.JANUARY);
        assertEquals((Object)id,(Object)R.id.janvier);
    }

    @Test
    public void testRecuperationIdFevrier() throws Exception {
        @IdRes Integer id = ConsultationViewUtil.idRadioButtonMois(Calendar.FEBRUARY);
        assertEquals((Object)id,(Object)R.id.fevrier);
    }

    @Test
    public void testRecuperationIdMars() throws Exception {
        @IdRes Integer id = ConsultationViewUtil.idRadioButtonMois(Calendar.MARCH);
        assertEquals((Object)id,(Object)R.id.mars);
    }

    @Test
    public void testRecuperationIdAvril() throws Exception {
        @IdRes Integer id = ConsultationViewUtil.idRadioButtonMois(Calendar.APRIL);
        assertEquals((Object)id,(Object)R.id.avril);
    }

    @Test
    public void testRecuperationIdMai() throws Exception {
        @IdRes Integer id = ConsultationViewUtil.idRadioButtonMois(Calendar.MAY);
        assertEquals((Object)id,(Object)R.id.mai);
    }

    @Test
    public void testRecuperationIdJuin() throws Exception {
        @IdRes Integer id = ConsultationViewUtil.idRadioButtonMois(Calendar.JUNE);
        assertEquals((Object)id,(Object)R.id.juin);
    }

    @Test
    public void testRecuperationIdJuillet() throws Exception {
        @IdRes Integer id = ConsultationViewUtil.idRadioButtonMois(Calendar.JULY);
        assertEquals((Object)id,(Object)R.id.juillet);
    }

    @Test
    public void testRecuperationIdAout() throws Exception {
        @IdRes Integer id = ConsultationViewUtil.idRadioButtonMois(Calendar.AUGUST);
        assertEquals((Object)id,(Object)R.id.aout);
    }

    @Test
    public void testRecuperationIdSeptembre() throws Exception {
        @IdRes Integer id = ConsultationViewUtil.idRadioButtonMois(Calendar.SEPTEMBER);
        assertEquals((Object)id,(Object)R.id.septembre);
    }

    @Test
    public void testRecuperationIdOctobre() throws Exception {
        @IdRes Integer id = ConsultationViewUtil.idRadioButtonMois(Calendar.OCTOBER);
        assertEquals((Object)id,(Object)R.id.octobre);
    }

    @Test
    public void testRecuperationIdNovembre() throws Exception {
        @IdRes Integer id = ConsultationViewUtil.idRadioButtonMois(Calendar.NOVEMBER);
        assertEquals((Object)id,(Object)R.id.novembre);
    }

    @Test
    public void testRecuperationIdDecembre() throws Exception {
        @IdRes Integer id = ConsultationViewUtil.idRadioButtonMois(Calendar.DECEMBER);
        assertEquals((Object)id,(Object)R.id.decembre);
    }

    @Test
    public void testRecuperationIdNull() throws Exception {
        @IdRes Integer id = ConsultationViewUtil.idRadioButtonMois(null);
        assertNull(id);
    }

    @Test
    public void testRecuperationIdPasCoherent() throws Exception {
        @IdRes Integer id = ConsultationViewUtil.idRadioButtonMois(Calendar.DECEMBER);
        assertNotEquals((Object)id,(Object)R.id.novembre);
    }


}
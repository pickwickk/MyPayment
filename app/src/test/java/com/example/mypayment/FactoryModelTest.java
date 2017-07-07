package com.example.mypayment;

import android.support.annotation.IdRes;

import com.example.mypayment.model.FactoryModel;
import com.example.mypayment.model.Paiement;
import com.example.mypayment.model.TypePaiement;
import com.example.mypayment.util.ConsultationViewUtil;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class FactoryModelTest {

    @Test
    public void testRecuperationPaiementVide() throws Exception {
        Paiement lPaiement = FactoryModel.getPaiement();
        assertNotNull(lPaiement);
        assertNull(lPaiement.getId());
        assertNull(lPaiement.getMontant());
        assertNull(lPaiement.getLibelle());
        assertNull(lPaiement.getTypeDePaiement());
        assertNull(lPaiement.getDatePaiement());
    }

    @Test
    public void testRecuperationPaiementAvecParametre() throws Exception {
        Paiement lPaiement = FactoryModel.getPaiement("blabla",10.1, TypePaiement.CB,Calendar.getInstance());
        assertNotNull(lPaiement);
        assertNull(lPaiement.getId());
        assertEquals(lPaiement.getMontant(),(Double) 10.1d);
        assertEquals(lPaiement.getLibelle(),"blabla");
        assertEquals(lPaiement.getTypeDePaiement(),TypePaiement.CB);
        assertNotNull(lPaiement.getDatePaiement());
    }

}
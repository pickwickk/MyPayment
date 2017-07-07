package com.example.mypayment;

import com.example.mypayment.util.DateUtil;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class DateUtilTest {

    @Test
    public void testFormatageDateParSlash() throws Exception {
        Calendar lCalendar = Calendar.getInstance();
        lCalendar.set(Calendar.YEAR,2016);
        lCalendar.set(Calendar.MONTH,Calendar.MARCH);
        lCalendar.set(Calendar.DAY_OF_MONTH,01);

        String lDateFormatted = DateUtil.getFormattedDate(lCalendar,"dd/MM/yyyy");
        assertEquals(lDateFormatted,"01/03/2016");
    }

    @Test
    public void testFormatageDateParTiret() throws Exception {
        Calendar lCalendar = Calendar.getInstance();
        lCalendar.set(Calendar.YEAR,2016);
        lCalendar.set(Calendar.MONTH,Calendar.MARCH);
        lCalendar.set(Calendar.DAY_OF_MONTH,01);

        String lDateFormatted = DateUtil.getFormattedDate(lCalendar,"dd-MM-yyyy");
        assertEquals(lDateFormatted,"01-03-2016");
    }

    @Test
    public void testRecuperationDateDuJour() throws Exception {
        Calendar lCalendar = Calendar.getInstance();
        Calendar lCalendarATester= DateUtil.dateDuJour();
        assertEquals(lCalendarATester.get(Calendar.YEAR),lCalendar.get(Calendar.YEAR));
        assertEquals(lCalendarATester.get(Calendar.MONTH),lCalendar.get(Calendar.MONTH));
        assertEquals(lCalendarATester.get(Calendar.DAY_OF_MONTH),lCalendar.get(Calendar.DAY_OF_MONTH));
    }


    @Test
    public void testRecuperationDate00h00() throws Exception {
        Calendar lCalendarATester= DateUtil.getDate(1,2016,Calendar.MARCH, DateUtil.Moment.MATIN_00h00);
        assertEquals(lCalendarATester.get(Calendar.YEAR),2016);
        assertEquals(lCalendarATester.get(Calendar.MONTH),Calendar.MARCH);
        assertEquals(lCalendarATester.get(Calendar.DAY_OF_MONTH),1);
        assertEquals(lCalendarATester.get(Calendar.HOUR_OF_DAY),0);
        assertEquals(lCalendarATester.get(Calendar.MINUTE),0);
        assertEquals(lCalendarATester.get(Calendar.SECOND),0);
        assertEquals(lCalendarATester.get(Calendar.MILLISECOND),0);
    }

    @Test
    public void testRecuperationDate23h59() throws Exception {
        Calendar lCalendarATester= DateUtil.getDate(1,2016,Calendar.MARCH, DateUtil.Moment.SOIR_23h59);
        assertEquals(lCalendarATester.get(Calendar.YEAR),2016);
        assertEquals(lCalendarATester.get(Calendar.MONTH),Calendar.MARCH);
        assertEquals(lCalendarATester.get(Calendar.DAY_OF_MONTH),1);
        assertEquals(lCalendarATester.get(Calendar.HOUR_OF_DAY),23);
        assertEquals(lCalendarATester.get(Calendar.MINUTE),59);
        assertEquals(lCalendarATester.get(Calendar.SECOND),59);
        assertEquals(lCalendarATester.get(Calendar.MILLISECOND),59);
    }

    @Test
    public void testRecuperationDateSansDonnerLeMoment() throws Exception {
        Calendar lCalendar = Calendar.getInstance();
        Calendar lCalendarATester= DateUtil.getDate(1,2016,Calendar.MARCH,null);
        assertEquals(lCalendarATester.get(Calendar.YEAR),lCalendar.get(Calendar.YEAR));
        assertEquals(lCalendarATester.get(Calendar.MONTH),lCalendar.get(Calendar.MONTH));
        assertEquals(lCalendarATester.get(Calendar.DAY_OF_MONTH),lCalendar.get(Calendar.DAY_OF_MONTH));
    }

    @Test
    public void testRecuperationDateSansDonnerJour() throws Exception {
        Calendar lCalendar = Calendar.getInstance();
        Calendar lCalendarATester= DateUtil.getDate(null,2016,Calendar.MARCH, DateUtil.Moment.MATIN_00h00);
        assertEquals(lCalendarATester.get(Calendar.YEAR),2016);
        assertEquals(lCalendarATester.get(Calendar.MONTH),Calendar.MARCH);
        assertEquals(lCalendarATester.get(Calendar.DAY_OF_MONTH),lCalendar.get(Calendar.DAY_OF_MONTH));
        assertEquals(lCalendarATester.get(Calendar.HOUR_OF_DAY),0);
        assertEquals(lCalendarATester.get(Calendar.MINUTE),0);
        assertEquals(lCalendarATester.get(Calendar.SECOND),0);
        assertEquals(lCalendarATester.get(Calendar.MILLISECOND),0);
    }

    @Test
    public void testRecuperationDateSansDonnerAnnee() throws Exception {
        Calendar lCalendar = Calendar.getInstance();
        Calendar lCalendarATester= DateUtil.getDate(1,null,Calendar.MARCH, DateUtil.Moment.MATIN_00h00);
        assertEquals(lCalendarATester.get(Calendar.YEAR),lCalendar.get(Calendar.YEAR));
        assertEquals(lCalendarATester.get(Calendar.MONTH),Calendar.MARCH);
        assertEquals(lCalendarATester.get(Calendar.DAY_OF_MONTH),1);
        assertEquals(lCalendarATester.get(Calendar.HOUR_OF_DAY),0);
        assertEquals(lCalendarATester.get(Calendar.MINUTE),0);
        assertEquals(lCalendarATester.get(Calendar.SECOND),0);
        assertEquals(lCalendarATester.get(Calendar.MILLISECOND),0);
    }

    @Test
    public void testRecuperationDateSansDonnerMois() throws Exception {
        Calendar lCalendar = Calendar.getInstance();
        Calendar lCalendarATester= DateUtil.getDate(1,2016,null, DateUtil.Moment.MATIN_00h00);
        assertEquals(lCalendarATester.get(Calendar.YEAR),2016);
        assertEquals(lCalendarATester.get(Calendar.MONTH),lCalendar.get(Calendar.MONTH));
        assertEquals(lCalendarATester.get(Calendar.DAY_OF_MONTH),1);
        assertEquals(lCalendarATester.get(Calendar.HOUR_OF_DAY),0);
        assertEquals(lCalendarATester.get(Calendar.MINUTE),0);
        assertEquals(lCalendarATester.get(Calendar.SECOND),0);
        assertEquals(lCalendarATester.get(Calendar.MILLISECOND),0);
    }
}
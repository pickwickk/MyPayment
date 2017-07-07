package com.example.mypayment.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mypayment.R;
import com.example.mypayment.controler.CreationPaiementController;
import com.example.mypayment.model.Paiement;
import com.example.mypayment.util.IntentVariables;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Guylain on 09/07/2016.
 */
public class RecapitulatifActivity extends AbstractActivity {

    private Calendar mDateDuPaiement;
    private BigDecimal mMontantCarteBleu;
    private BigDecimal mMontantLiquide;
    private BigDecimal mMontantCheque;
    private BigDecimal mMontantTicketRestaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.initialisationContexte(this);
        setContentView(R.layout.activity_recapitulatif);

        mDateDuPaiement = (Calendar)this.getIntent().getSerializableExtra(IntentVariables.DATE_PAIEMENT);

        if(mDateDuPaiement == null) {
            mDateDuPaiement = Calendar.getInstance();
        }

        mMontantCarteBleu = new BigDecimal(0);
        mMontantLiquide = new BigDecimal(0);
        mMontantCheque = new BigDecimal(0);
        mMontantTicketRestaurant = new BigDecimal(0);

        List<Paiement> lListePaiements = CreationPaiementController.getInstance().recuperationPaiementDunMois(mDateDuPaiement.get(Calendar.YEAR),mDateDuPaiement.get(Calendar.MONTH));

        for (Paiement lPaiement:lListePaiements) {
            if(lPaiement.getTypeDePaiement() != null) {
                switch (lPaiement.getTypeDePaiement()) {
                    case CB:
                        mMontantCarteBleu = mMontantCarteBleu.add(new BigDecimal(lPaiement.getMontant()));
                        break;
                    case Espece:
                        mMontantLiquide = mMontantLiquide.add(new BigDecimal(lPaiement.getMontant()));
                        break;
                    case Cheque:
                        mMontantCheque = mMontantCheque.add(new BigDecimal(lPaiement.getMontant()));
                        break;
                    case Indefini:
                        break;
                }
            }
        }

        PieChart pieChart = (PieChart) findViewById(R.id.chart);
        pieChart.setCenterText("sdfsdfsfdss");
        pieChart.setHoleRadius(5f);
        // creating data values
        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(mMontantCarteBleu.floatValue(), 0));
        entries.add(new Entry(mMontantLiquide.floatValue(), 1));
        entries.add(new Entry(mMontantCheque.floatValue(), 2));
        entries.add(new Entry(0, 3));
        PieDataSet dataset = new PieDataSet(entries, "");
        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Carte bleu");
        labels.add("Liquide");
        labels.add("Cheques");
        labels.add("Ticket restaurants");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData data = new PieData(labels, dataset); // initialize Piedata
        pieChart.setData(data);
        pieChart.animateY(5000);
        pieChart.setDescription("Description");  // set the description
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
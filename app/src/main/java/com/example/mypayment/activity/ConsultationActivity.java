package com.example.mypayment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.mypayment.Observateur.Observateur;
import com.example.mypayment.Observateur.Observatoire;
import com.example.mypayment.R;
import com.example.mypayment.controler.CreationPaiementController;
import com.example.mypayment.adapter.PaiementAdapter;
import com.example.mypayment.util.ConsultationViewUtil;
import com.example.mypayment.util.IntentVariables;
import com.example.mypayment.model.Mois;
import com.example.mypayment.model.Paiement;
import com.example.mypayment.util.DateUtil;

import java.util.Calendar;
import java.util.List;

public class ConsultationActivity extends AbstractActivity implements Observateur,RadioGroup.OnCheckedChangeListener {

    private ConsultationActivity mConsultationActivity;
    private ListView mListView;
    private RadioGroup mRadioGroupAnnee;
    private RadioGroup mRadioGroupMois;
    private RadioButton mRadioButtonAnneeChecked;
    private RadioButton mRadioButtonMoisChecked;
    private Button mButtonRecapitulatif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.initialisationContexte(this);
        mConsultationActivity = this;
        CreationPaiementController.setContext(this);
        Observatoire.addObservateur(this);
        setContentView(R.layout.activity_consultation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mConsultationActivity,CreationPaiementActivity.class);
                //on lance l'intent, cela a pour effet de stoper l'activité courante et lancer une autre activite ici CreationPaiementActivity
                Calendar lCalendar = DateUtil.dateDuJour();

                Integer lChoixAnnee = getAnneeChecked();
                Integer lChoixMois = getMoisChecked();

                if(lChoixAnnee != null && lChoixMois != null){
                    lCalendar.set(Calendar.YEAR,lChoixAnnee);
                    lCalendar.set(Calendar.MONTH,lChoixMois);
                }

                intent.putExtra(IntentVariables.DATE_PAIEMENT,lCalendar);
                startActivity(intent);
            }
        });

        mButtonRecapitulatif = (Button) findViewById(R.id.recapitulatif);
        mButtonRecapitulatif.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mConsultationActivity,RecapitulatifActivity.class);
                //on lance l'intent, cela a pour effet de stoper l'activité courante et lancer une autre activite ici CreationPaiementActivity
                Calendar lCalendar = DateUtil.dateDuJour();

                Integer lChoixAnnee = getAnneeChecked();
                Integer lChoixMois = getMoisChecked();

                if(lChoixAnnee != null && lChoixMois != null){
                    lCalendar.set(Calendar.YEAR,lChoixAnnee);
                    lCalendar.set(Calendar.MONTH,lChoixMois);
                }

                intent.putExtra(IntentVariables.DATE_PAIEMENT,lCalendar);
                startActivity(intent);
            }

        });

        mRadioGroupAnnee = (RadioGroup)findViewById(R.id.radio_choix_annee);
        mRadioGroupMois = (RadioGroup)findViewById(R.id.radio_choix_mois);

        Calendar lDateDuJour = DateUtil.dateDuJour();
        Integer lAnneeActuel = lDateDuJour.get(Calendar.YEAR);
        Integer lMoisActuel = lDateDuJour.get(Calendar.MONTH);

        mRadioButtonAnneeChecked = (RadioButton) mRadioGroupAnnee.findViewById(ConsultationViewUtil.idRadioButtonAnnee(lAnneeActuel));
        mRadioButtonMoisChecked = (RadioButton) mRadioGroupMois.findViewById(ConsultationViewUtil.idRadioButtonMois(lMoisActuel));

        //L'ordre est important pour ne pas activer le onCheckedChanged deux fois à l'initialisation
        mRadioButtonAnneeChecked.setChecked(Boolean.TRUE);

        mRadioGroupAnnee.setOnCheckedChangeListener(this);
        mRadioGroupMois.setOnCheckedChangeListener(this);

        mRadioButtonMoisChecked.setChecked(Boolean.TRUE);
    }

    private Integer getAnneeChecked(){
        Integer lChoixAnnee = null;
        try {
            if(mRadioButtonAnneeChecked != null){
                lChoixAnnee = Integer.parseInt(mRadioButtonAnneeChecked.getText().toString());
            }
        }catch(NumberFormatException num){
            num.printStackTrace();
        }
        return lChoixAnnee;
    }

    private Integer getMoisChecked(){
        Integer lChoixMois = null;
        if(mRadioButtonMoisChecked != null){
            Mois lMoischoisi = Mois.convert(mRadioButtonMoisChecked.getText().toString());
            lChoixMois = lMoischoisi.getNumeroMois();
        }
        return lChoixMois;
    }


    @Override
    public void onCheckedChanged(RadioGroup aGroup, int aCheckedId) {
        // This will get the radiobutton that has changed in its check state
        RadioButton checkedRadioButton = (RadioButton)aGroup.findViewById(aCheckedId);
        // This puts the value (true/false) into the variable

        boolean isChecked = checkedRadioButton.isChecked();
        if(isChecked) {
            if(aGroup.getId() == mRadioGroupAnnee.getId()){
                mRadioButtonAnneeChecked = checkedRadioButton;
            }else if(aGroup.getId() == mRadioGroupMois.getId()){
                mRadioButtonMoisChecked = checkedRadioButton;
            }
            Integer lChoixAnnee = getAnneeChecked();
            Integer lChoixMois = getMoisChecked();
            alimentationListePaiementsSelonChoixDate(lChoixAnnee,lChoixMois);
        }
    }

    private void alimentationListePaiementsSelonChoixDate(Integer aAnnee,Integer aMois){
        List<Paiement> lListePaiements = CreationPaiementController.getInstance().recuperationPaiementDunMois(aAnnee,aMois);
        PaiementAdapter adapter = new PaiementAdapter(ConsultationActivity.this, lListePaiements);
        mListView = (ListView) findViewById(R.id.liste_paiements);
        mListView.setAdapter(adapter);
    }

    @Override
    public void nouveauPaiement(Integer aAnnee,Integer aMois) {
        //Si on est sur le même écran de consultation que le nouveau paiment on le récupère de la bdd
        Integer lChoixAnnee = getAnneeChecked();
        Integer lChoixMois = getMoisChecked();
        if(lChoixMois != null && lChoixAnnee != null){
            if(aAnnee.equals(lChoixAnnee) && lChoixMois.equals(aMois)){
                alimentationListePaiementsSelonChoixDate(lChoixAnnee,lChoixMois);
            }
        }

        affichageResumeTraitement(Boolean.TRUE);
    }

    private void affichageResumeTraitement(Boolean aSucces){
        String lMessageEnd ;
        if(aSucces) {
            lMessageEnd = getString(R.string.creation_reussi);
        }else{
            lMessageEnd = getString(R.string.creation_echec);;
        }
        View lMain = findViewById(R.id.consultation_paiement_view);
        Snackbar.make(lMain, lMessageEnd, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

}

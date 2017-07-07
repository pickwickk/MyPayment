package com.example.mypayment.activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mypayment.Observateur.Observatoire;
import com.example.mypayment.R;
import com.example.mypayment.controler.CreationPaiementController;
import com.example.mypayment.model.TypePaiement;
import com.example.mypayment.util.DateUtil;
import com.example.mypayment.util.IntentVariables;

import java.util.Calendar;

public class CreationPaiementActivity extends AbstractActivity {

    private TextView mNomPaiementChoisi;
    private TypePaiement mTypePaiementchoisi;
    private EditText mEditTextMontant;
    private EditText mEditTextCommentaire;
    private RadioGroup mRadioChoixPaiement;
    private Calendar mDateDuPaiement;
    private Button mChangeDateCreationPaiement;
    private CreationPaiementActivity mCreationPaiementActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.initialisationContexte(this);
        setContentView(R.layout.activity_creation);
        mCreationPaiementActivity = this;

        mDateDuPaiement = (Calendar)this.getIntent().getSerializableExtra(IntentVariables.DATE_PAIEMENT);

        if(mDateDuPaiement == null) {
            mDateDuPaiement = Calendar.getInstance();
        }

        mEditTextMontant = (EditText) findViewById(R.id.montant);
        mEditTextCommentaire = (EditText) findViewById(R.id.commentaire);
        mRadioChoixPaiement = (RadioGroup) findViewById(R.id.radio_choix_paiement);

        mNomPaiementChoisi = (TextView)findViewById(R.id.choix_paiement);

        mChangeDateCreationPaiement = (Button)findViewById(R.id.change_date);

        mChangeDateCreationPaiement.setText(DateUtil.getFormattedDate(mDateDuPaiement,getString(R.string.format_date_slash)));

        mChangeDateCreationPaiement.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog lDatePickerDialog = new DatePickerDialog(mCreationPaiementActivity,new DatePickerDialog.OnDateSetListener() {

                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        mDateDuPaiement.set(Calendar.YEAR,year);
                        mDateDuPaiement.set(Calendar.MONTH,monthOfYear);
                        mDateDuPaiement.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                        mChangeDateCreationPaiement.setText(DateUtil.getFormattedDate(mDateDuPaiement,getString(R.string.format_date_slash)));
                    }

                },mDateDuPaiement.get(Calendar.YEAR), mDateDuPaiement.get(Calendar.MONTH), mDateDuPaiement.get(Calendar.DAY_OF_MONTH));
                lDatePickerDialog.show();
            }
        });

        //Mise en place de l'écoute sur les radios boutons
        mRadioChoixPaiement.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup aRadioGroup, int checkedId)
            {
                // This will get the radiobutton that has changed in its check state
                RadioButton checkedRadioButton = (RadioButton)aRadioGroup.findViewById(checkedId);
                // This puts the value (true/false) into the variable

                boolean isChecked = checkedRadioButton.isChecked();
                // Si le radio bouton est selectionné on mets-à-jour le libellé type de paiement choisi
                if (isChecked)
                {
                    mTypePaiementchoisi = TypePaiement.convert((String)checkedRadioButton.getText());
                    mNomPaiementChoisi.setText(mTypePaiementchoisi.getValue());
                }
            }
        });

        Button lButtonValideDepense = (Button) findViewById(R.id.valide_depense);
        lButtonValideDepense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean lControleSurfaceOK = controleDeSurface();

                if(lControleSurfaceOK) {
                    //Création du paiement avec les infos du formulaire
                    Boolean lTraitementReussi = CreationPaiementController.getInstance().traiementDeLaCreationDuPaiement(Double.valueOf(mEditTextMontant.getText().toString()),
                            mEditTextCommentaire.getText().toString(),mTypePaiementchoisi,mDateDuPaiement);
                    if(lTraitementReussi){
                        Observatoire.nouveauPaiement(mDateDuPaiement.get(Calendar.YEAR),mDateDuPaiement.get(Calendar.MONTH));
                    }
                    finish();
                }
            }
        });

    }

    public Boolean controleDeSurface(){
        Boolean lControleSurfaceOK = true;
        //Reset des erreurs
        mEditTextMontant.setError(null);
        mEditTextCommentaire.setError(null);

        if(mEditTextMontant.getText().toString().isEmpty()){
            mEditTextMontant.setError(getString(R.string.montant_manquant));
            lControleSurfaceOK = Boolean.FALSE;
        }
        if(mEditTextCommentaire.getText().toString().isEmpty()){
            mEditTextCommentaire.setError(getString(R.string.commentaire_manquant));
            lControleSurfaceOK = Boolean.FALSE;
        }
        if(mRadioChoixPaiement.getCheckedRadioButtonId() == -1){
            Toast.makeText(CreationPaiementActivity.this, R.string.moyen_paiement_manquant,Toast.LENGTH_SHORT).show();
            lControleSurfaceOK = Boolean.FALSE;
        }

        return lControleSurfaceOK;
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

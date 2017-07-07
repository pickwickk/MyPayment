package com.example.mypayment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mypayment.R;
import com.example.mypayment.model.Paiement;
import com.example.mypayment.UImodel.PaiementViewHolder;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Guylain on 22/05/2016.
 */
public class PaiementAdapter extends ArrayAdapter<Paiement> {

    //tweets est la liste des models à afficher
    public PaiementAdapter(Context context, List<Paiement> tweets) {
        super(context, 0, tweets);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.view_paiement,parent, false);
        }

        PaiementViewHolder viewHolder = (PaiementViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new PaiementViewHolder();
            viewHolder.setTypePaiement((TextView)convertView.findViewById(R.id.type_paiement));
            viewHolder.setLabel((TextView)convertView.findViewById(R.id.text_paiement));
            viewHolder.setMontant((TextView) convertView.findViewById(R.id.montant));
            viewHolder.setDatePaiement((TextView) convertView.findViewById(R.id.date_paiement));
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Paiement lPaiement = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.getTypePaiement().setText(lPaiement.getTypeDePaiement().getValue());
        viewHolder.getLabel().setText(lPaiement.getLibelle());
        viewHolder.getMontant().setText(lPaiement.getMontant().toString());;
        viewHolder.getDatePaiement().setText(creationPhraseLibelleDate(lPaiement.getDatePaiement()));
        return convertView;
    }

    public String creationPhraseLibelleDate(Date aDate){
        Calendar lCalendar = Calendar.getInstance();
        lCalendar.setTime(aDate);
        Integer lMinute = lCalendar.get(Calendar.MINUTE);
        String lMinutes = lMinute.toString();
        if(lMinute < 10){
            lMinutes= "0"+lMinutes;
        }
        return "Le "+lCalendar.get(Calendar.DAY_OF_MONTH)+", à "+lCalendar.get(Calendar.HOUR_OF_DAY)+"H"+lMinutes;
    }

}
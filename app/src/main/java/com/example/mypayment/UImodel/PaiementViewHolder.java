package com.example.mypayment.UImodel;

import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Guylain on 22/05/2016.
 */
public class PaiementViewHolder {
    public TextView mTypePaiement;
    public TextView mLabel;
    public TextView mMontant;

    public TextView getDatePaiement() {
        return mDatePaiement;
    }

    public void setDatePaiement(TextView mDatePaiement) {
        this.mDatePaiement = mDatePaiement;
    }

    public TextView mDatePaiement;

    public TextView getTypePaiement() {
        return mTypePaiement;
    }

    public void setTypePaiement(TextView mTypePaiement) {
        this.mTypePaiement = mTypePaiement;
    }

    public TextView getLabel() {
        return mLabel;
    }

    public void setLabel(TextView mLabel) {
        this.mLabel = mLabel;
    }

    public TextView getMontant() {
        return mMontant;
    }

    public void setMontant(TextView mMontant) {
        this.mMontant = mMontant;
    }
}

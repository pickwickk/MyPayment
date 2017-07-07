package com.example.mypayment.model;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * Created by Guylain on 15/05/2016.
 */
public enum TypePaiement {
    CB("carte_bleu","Carte bleu"),
    Espece("argent_liquide","Argent liquide"),
    Cheque("cheque","Cheque"),
    Indefini("indefini","indefini");

    private String label;
    private String value;

    private TypePaiement(String aLabel,String aValue){
        this.label = aLabel;
        this.value = aValue;
    }

    public String getLabel(){
        return this.label;
    }

    public String getValue(){
        return this.value;
    }

    public static TypePaiement convert(String aLabel){
        List<TypePaiement> lListeTypePaiement = new ArrayList<TypePaiement>( EnumSet.allOf(TypePaiement.class));
        Boolean lTrouve = false;
        Integer lNombreDeTypePaiement = 0;
        TypePaiement lTypePaiement = TypePaiement.Indefini;
        if(aLabel != null && lListeTypePaiement != null ) {
            while (!lTrouve && lNombreDeTypePaiement < lListeTypePaiement.size()) {
                TypePaiement lTypeDePaiement = lListeTypePaiement.get(lNombreDeTypePaiement);
                if (lTypeDePaiement.getLabel().contains(aLabel)) {
                    lTypePaiement = lTypeDePaiement;
                    lTrouve = true;
                }
                lNombreDeTypePaiement++;
            }
        }
        return lTypePaiement;
    }
}

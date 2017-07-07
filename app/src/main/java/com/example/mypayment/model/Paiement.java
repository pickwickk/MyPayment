package com.example.mypayment.model;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Guylain on 15/05/2016.
 */
@DatabaseTable(tableName = "Paiement")
public class Paiement{

    @DatabaseField(generatedId=true)
    Integer id;

    @DatabaseField(columnName = "montant", canBeNull=false)
    Double montant;

    @DatabaseField(columnName = "libelle", canBeNull=false)
    String libelle;

    @DatabaseField(columnName = "typePaiement", canBeNull=false)
    TypePaiement typeDePaiement;

    @DatabaseField(columnName = "datePaiement", canBeNull=false)
    Date datePaiement;

    protected Paiement(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public TypePaiement getTypeDePaiement() {
        return typeDePaiement;
    }

    public void setTypeDePaiement(TypePaiement typeDePaiement) {
        this.typeDePaiement = typeDePaiement;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

}

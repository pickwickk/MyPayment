package com.example.mypayment.controler;

import com.example.mypayment.dao.FactoryDAO;
import com.example.mypayment.model.FactoryModel;
import com.example.mypayment.model.Paiement;
import com.example.mypayment.model.TypePaiement;
import com.example.mypayment.util.DateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Guylain on 15/05/2016.
 */
public class CreationPaiementController extends AbstractController{

    private static CreationPaiementController mInstance;

    protected CreationPaiementController(){
    }

    public static CreationPaiementController getInstance(){
        if(mInstance == null){
            mInstance = new CreationPaiementController();
        }
        return mInstance;
    }

    public List<Paiement> recuperationPaiementDunMois(Integer aAnnee,Integer aMois){
        List<Paiement> lListPaimement = new ArrayList<Paiement>();
        try {
            lListPaimement = FactoryDAO.getInstance(mContext).getPaiementDao().queryBuilder().where().between("datePaiement", DateUtil.getDate(PREMIER_JOUR_DU_MOIS,aAnnee,aMois, DateUtil.Moment.MATIN_00h00).getTime(),DateUtil.getDate(DERNIER_JOUR_DU_MOIS,aAnnee,aMois,DateUtil.Moment.SOIR_23h59).getTime()).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lListPaimement;
    }

    public Boolean traiementDeLaCreationDuPaiement(Double aMontant, String aLibelle, TypePaiement aTypePaiement, Calendar aDateDuPaiement){
        Boolean lInfoDuPaiementValide = Boolean.TRUE;
        Boolean lCreationReussi = Boolean.FALSE;
        if(aMontant == null || aLibelle == null || aTypePaiement == null ){
            lInfoDuPaiementValide = Boolean.FALSE;
        }
        if(lInfoDuPaiementValide) {
            try {
                lCreationReussi = creationDuPaiement(aMontant,
                        aLibelle, aTypePaiement,aDateDuPaiement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return lCreationReussi;
    }

    private Boolean creationDuPaiement(Double aMontant, String aLibelle, TypePaiement aTypePaiement, Calendar aDateDuPaiement) throws SQLException {
        Paiement lPaiement = FactoryModel.getPaiement(aLibelle,aMontant,aTypePaiement,aDateDuPaiement);
        Integer lNombreDeModificationEnBdd = FactoryDAO.getInstance(mContext).getPaiementDao().create(lPaiement);
        Boolean lResultat = Boolean.FALSE;
        if(lNombreDeModificationEnBdd == 1){
            lResultat = Boolean.TRUE;
        }
        return lResultat;
    }

}

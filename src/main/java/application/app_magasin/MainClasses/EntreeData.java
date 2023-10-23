package application.app_magasin.MainClasses;

import java.util.Date;

public class EntreeData {
    private Date DateIn;
    private Fournisseur fournisseur;
    private double MontantIN;
    private int QparCtnIN;
    private int QuantiteIN;
    private double prixAchat;
    private String produit;
    private String referenceIN;

    public EntreeData(Date date, Fournisseur fournisseur, double montantIN, int qparCtnIN, int quantiteIN, double prixAchat, String produit, String referenceIN) {
        this.DateIn = date;
        this.fournisseur = fournisseur;
        this.MontantIN = montantIN;
        this.QparCtnIN = qparCtnIN;
        this.QuantiteIN = quantiteIN;
        this.prixAchat = prixAchat;
        this.produit = produit;
        this.referenceIN = referenceIN;
    }

    public Date getDate() {
        return DateIn;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public double getMontantIN() {
        return MontantIN;
    }

    public int getQparCtnIN() {
        return QparCtnIN;
    }

    public int getQuantiteIN() {
        return QuantiteIN;
    }

    public double getPrixAchat() {
        return prixAchat;
    }

    public String getProduit() {
        return produit;
    }

    public String getReferenceIN() {
        return referenceIN;
    }
}

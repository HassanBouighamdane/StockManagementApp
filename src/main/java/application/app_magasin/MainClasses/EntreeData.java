package application.app_magasin.MainClasses;

import java.util.Date;

public class EntreeData {
    private Date DateIn;
    private Fournisseur fournisseur;
    private double montantTotal;
    private Depot depot;
    private int QparCtnIN;
    private int QuantiteIN;
    private double prixAchat;
    private Produit produit;


    public EntreeData(Date date, Fournisseur fournisseur, Depot depot, int qparCtnIN, int quantiteIN, double prixAchat, Produit produit, double montantTotal) {
        this.DateIn = date;
        this.fournisseur = fournisseur;
        this.QparCtnIN = qparCtnIN;
        this.QuantiteIN = quantiteIN;
        this.prixAchat = prixAchat;
        this.produit = produit;
        this.depot=depot;
        this.montantTotal=montantTotal;

    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    public Date getDate() {
        return DateIn;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public double getMontantTotal() {
        return montantTotal;
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

    public Produit getProduit() {
        return produit;
    }


}

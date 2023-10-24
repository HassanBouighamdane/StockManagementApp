package application.app_magasin.MainClasses;

import java.util.List;

public class Produit {
    private String id_produit;
    private Categorie categorie;
    private String designation;
    private Fournisseur fournisseur;
    private List<Depot> depot;


    public Produit(String id_produit, Categorie categorie, String designation, Fournisseur fournisseur) {
        this.id_produit = id_produit;
        this.categorie = categorie;
        this.designation = designation;
        this.fournisseur = fournisseur;
        this.depot = depot;
    }

    public String getId_produit() {
        return id_produit;
    }

    public void setId_produit(String id_produit) {
        this.id_produit = id_produit;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public List<Depot> getDepot() {
        return depot;
    }

    public void setDepot(List<Depot> depot) {
        this.depot = depot;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }


    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }


    @Override
    public String toString() {
        return designation;
    }
}

package application.app_magasin.MainClasses;

public class Produit {
    private String id_produit;
    private Categorie categorie;
    private String Designation;
    private Fournisseur fournisseur;

    public Produit(String id_produit, Categorie categorie, String designation, Fournisseur fournisseur) {
        this.id_produit = id_produit;
        this.categorie = categorie;
        Designation = designation;
        this.fournisseur = fournisseur;
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

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    @Override
    public String toString() {
        return Designation;
    }
}

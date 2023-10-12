package application.app_magasin;

public class Produit {
    private String ref;
    private String Designation;
    private String categorie;
    private int quantite;
    private double prix;

    public Produit(String produit, String categorie, int quantite, double prix) {
        this.Designation = produit;
        this.categorie = categorie;
        this.quantite = quantite;
        this.prix = prix;
    }

    public Produit(String produit, String categorie) {
        this.Designation = produit;
        this.categorie = categorie;
    }

    public Produit(String produit, String categorie, double prix) {
        this.Designation = produit;
        this.categorie = categorie;
        this.prix = prix;
    }

    public String getProduit() {
        return Designation;
    }

    public void setProduit(String product) {
        this.Designation = product;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantité) {
        this.quantite = quantité;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}

package application.app_magasin.MainClasses;

import java.util.List;

public class Depot {
    private String id_depot;
    private String name_depot;
    private List<Produit> Produits;

    public Depot(String id_depot, String name_depot) {
        this.id_depot = id_depot;
        this.name_depot = name_depot;
    }

    public String getId_depot() {
        return id_depot;
    }

    public void setId_depot(String id_depot) {
        this.id_depot = id_depot;
    }

    public String getName_depot() {
        return name_depot;
    }

    public void setName_depot(String name_depot) {
        this.name_depot = name_depot;
    }

    public List<Produit> getProduits() {
        return Produits;
    }

    public void setProduits(List<Produit> produits) {
        Produits = produits;
    }

    @Override
    public String toString() {
        return id_depot;
    }
}

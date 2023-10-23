package application.app_magasin.MainClasses;

public class Fournisseur {
    private static int id_fournisseur;
    private String name;
    private int nbr_entree;
    private String Telephone;

    public Fournisseur(String name, int nbr_entree, String telephone) {
        this.name = name;
        this.nbr_entree = nbr_entree;
        Telephone = telephone;
    }

    public static int getId_fournisseur() {
        return id_fournisseur;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNbr_entree() {
        return nbr_entree;
    }

    public void setNbr_entree(int nbr_entree) {
        this.nbr_entree = nbr_entree;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    @Override
    public String toString() {
        return name;
    }
}

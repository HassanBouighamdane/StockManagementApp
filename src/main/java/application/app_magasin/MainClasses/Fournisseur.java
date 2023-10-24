package application.app_magasin.MainClasses;

public class Fournisseur {
    private static int id_fournisseur;
    private String name;

    private String Telephone;

    public Fournisseur(String name, String telephone) {
        this.name = name;

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

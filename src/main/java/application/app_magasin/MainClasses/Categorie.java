package application.app_magasin.MainClasses;

public class Categorie {
    private int id_cat;
    private String name;

    public Categorie(String name) {
        this.name = name;
    }


    public Categorie(int id_cat, String name) {
        this.id_cat = id_cat;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

package application.app_magasin.MainClasses;

public class Categorie {
    private static int id_cat;
    private String name;

    public Categorie(String name) {
        this.name = name;
    }

    public static int getId_cat() {
        return id_cat;
    }

    public static void setId_cat(int id_cat) {
        Categorie.id_cat = id_cat;
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

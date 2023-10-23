package application.app_magasin.MainClasses;

public class Cilent {
    private static int id_client;
    private String name;
    private String Phone;
    private int nbr_sortie;

    public Cilent(String name, String phone, int nbr_sortie) {
        this.name = name;
        this.Phone = phone;
        this.nbr_sortie = nbr_sortie;
    }

    public static int getId_client() {
        return id_client;
    }

    public static void setId_client(int id_client) {
        Cilent.id_client = id_client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public int getNbr_sortie() {
        return nbr_sortie;
    }

    public void setNbr_sortie(int nbr_sortie) {
        this.nbr_sortie = nbr_sortie;
    }

    @Override
    public String toString() {
        return name;
    }
}

package model;

public class UsersKart {
    private int id_kart;
    private int id_user;
    private String strana;
    private int schot;
    private String valuta;
    private Users users;

    public UsersKart(int id_kart,int id_user, String strana, int schot,String valuta) {
        this.id_kart=id_kart;
        this.id_user=id_user;
        this.strana = strana;
        this.schot=schot;
        this.valuta=valuta;
    }

    public UsersKart(Users users,int id_kart, int id_user, String strana, int schot,String valuta) {
        this.users = users;
        this.id_kart=id_kart;
        this.id_user=id_user;
        this.strana = strana;
        this.schot=schot;
        this.valuta=valuta;
    }

    public UsersKart(String userName, String strana, int schot, String valuta) {}

    public int getId_kart() {
        return id_kart;
    }

    public void setId_kart(int id_kart) {
        this.id_kart = id_kart;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getStrana() {
        return strana;
    }

    public void setStrana(String strana) {
        this.strana = strana;
    }

    public int getSchot() {
        return schot;
    }

    public void setSchot(int schot) {
        this.schot = schot;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}


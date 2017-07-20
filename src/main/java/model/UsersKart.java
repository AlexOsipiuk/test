package model;

public class UsersKart {
    private int idkart;
    private int iduser;
    private String strana;
    private int schot;
    private String valuta;
    private Users users;

    public UsersKart(int id_kart,int id_user, String strana, int schot,String valuta) {
        this.idkart=id_kart;
        this.iduser=id_user;
        this.strana = strana;
        this.schot=schot;
        this.valuta=valuta;
    }


    public UsersKart(Users users,int id_kart, int id_user, String strana, int schot,String valuta) {
        this.users = users;
        this.idkart=id_kart;
        this.iduser=id_user;
        this.strana = strana;
        this.schot=schot;
        this.valuta=valuta;
    }

    public UsersKart(int id_kart,String strana,int schot,String valuta, int id_user) {
        this.idkart=id_kart;
        this.iduser=id_user;
        this.strana = strana;
        this.schot=schot;
        this.valuta=valuta;
    }

    public UsersKart(String userName, String strana, int schot, String valuta) {}

    public int getId_kart() {
        return idkart;
    }

    public void setId_kart(int id_kart) {
        this.idkart = id_kart;
    }

    public int getId_user() {
        return iduser;
    }

    public void setId_user(int id_user) {
        this.iduser = id_user;
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


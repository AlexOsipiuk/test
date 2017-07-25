import java.util.ArrayList;

public class Users {
    private int id;
    private String name;
    private String surname;
    private int birthdate;
    private String email;
    private ArrayList<UsersKart> usersKartList;

    public Users(int id_kart, String strana, int schot, String valuta, int id_user) {}

    public Users(int id, String name, String surname, int birthdate, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.email = email;
    }

    public Users(int id, String name, String surname, int birthdate, String email,
                  ArrayList<UsersKart> usersKartListv) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.email = email;
        this.usersKartList = usersKartListv;
    }

    public Users(String name, ArrayList<UsersKart> usersKartList) {
        this.name = name;
        this.usersKartList = usersKartList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(int birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<UsersKart> getUsersKartList() {
        return usersKartList;
    }

    public void setUsersKartList(ArrayList<UsersKart> usersKartList) {
        this.usersKartList = usersKartList;
    }
}


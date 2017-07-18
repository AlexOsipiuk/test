package interfaces;

import model.Users;
import model.UsersKart;

import java.io.Writer;
import java.util.ArrayList;

public interface IntUsersDao extends IntGenericDao<UsersKart,Integer>{
    ArrayList<UsersKart> getBank_kartById_user(int id);
    Users getUserInfoByName(String name);

    void insert(Users model);

    void update(Users model);

    ArrayList<UsersKart> getUsersKartById_user(int id);

    Users getEntityById(Integer id);

    Users getWriterInfoByName(String name);
}

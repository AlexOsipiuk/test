package interfaces;

import model.UsersKart;

import java.util.List;

public interface IntUsersKartDao extends IntGenericDao<UsersKart,Integer> {

    List<UsersKart> getUsersKartById_user(int id_user);

    List<UsersKart> getBank_kartById_user(int writerId);

    UsersKart getUsersKartInfoByStrana(String strana);
}



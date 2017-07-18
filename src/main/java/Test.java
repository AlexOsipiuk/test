import config.ConnectionDB;
import dao.UsersDao;
import dao.UsersKartDao;
import model.Users;
import model.UsersKart;
import java.util.ArrayList;
import java.util.List;

import static config.ConnectionDB.closeConnection;

public class Test {
    public static void main(String[] args){


        UsersDao impl= new UsersDao() {
            @Override
            public void insert(UsersKart model) {

            }

            @Override
            public void update(UsersKart model) {

            }

            @Override
            public List<UsersKart> getAllModel() {
                return null;
            }

            @Override
            public UsersKart getModelById(Integer id) {
                return null;
            }
        };
        UsersKartDao usersKartDao= new UsersKartDao() {
            @Override
            public UsersKart getModelById(Integer id) {
                return null;
            }

            @Override
            public List<UsersKart> getAllUsersKartByUserName(String name) {
                return null;
            }

            @Override
            public List<UsersKart> getUsersKartById_user(int id_user) {
                return null;
            }
        };
        StringBuilder stringBuilder=new StringBuilder();



        closeConnection();
    }
}


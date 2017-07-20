import dao.UsersDao;
import dao.UsersKartDao;
import model.Users;
import model.UsersKart;

import java.util.List;

import static config.ConnectionDB.closeConnection;

public class Test {
    public static void main(String[] args){

        StringBuilder stringBuilder=new StringBuilder();
        UsersDao impl= new UsersDao() {
            @Override
            public void insert(Users model) {
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


        List<UsersKart> usersKarts=impl.getAllModel();

        for(UsersKart usersKart:usersKarts){
                UsersKart users= impl.getModelById(2);
        stringBuilder.append(users.getId()+". Name: "+users.getName()+"; Surname: "+users.getSurname()+"; Birthdate: "+users.getBirthdate()+"; Email: "+users.getEmail());
        System.out.println(stringBuilder);


        closeConnection();
    }
}


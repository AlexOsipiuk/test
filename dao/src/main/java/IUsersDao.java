import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public interface IUsersDao extends IGenericDao<UsersKart,Integer>{

    List<UsersKart> getUsersKartByUserId(int id, Connection connection);
    Users getUserInfoByName(String name, Connection connection);
    String getUserInfoByEmail(String email, Connection connection);
}

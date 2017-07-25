import java.sql.Connection;
import java.util.List;

public interface IUsersKartDao extends IGenericDao<UsersKart,Integer> {

    List<UsersKart> getUsersKartByIdUsers(int id_user, Connection connection);
    Users getBank_kartByUserName(String name, Connection connection);
    String  getEmailInfoByStrana(String email, Connection connection);
}

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        ServiceUser serviceUser =new ServiceUser();
        List<UsersKart> users=serviceUser.getAllUsersName();
        for(int i=0;i<users.size();i++){
            System.out.println(users.get(i).getStrana());
        }

    }
}

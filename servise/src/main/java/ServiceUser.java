import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ServiceUser {
    private static UsersKartDao usersKartDao=new UsersKartDao();
    final Logger logger=Logger.getLogger(String.valueOf(ServiceUser.class));

    public List<UsersKart> getAllUsersName(){
        Connection connection=null;
        List<UsersKart> users=null;

        try {
            connection.setAutoCommit(false);
            users= usersKartDao.getAllEntity(connection);
            connection.commit();
        }
        catch (SQLException ex){
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            logger.info("Transaction not executed");

        }
        if(users!=null){

        ArrayList<String> usersName=new ArrayList<String>();
        for(UsersKart ignored :users){
            String name=Users.getName();
            usersName.add(name);
        }
        }
        else{
            logger.info("List Users - null");
        }
        return users;
    }


}

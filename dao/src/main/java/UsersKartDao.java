
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UsersKartDao implements IUsersKartDao {
    private static Logger logger=Logger.getLogger(String.valueOf(UsersDao.class));

    private static final String SELECT_ALL_FROM_BANK_KART = "SELECT * FROM BANK_KART";
    private static final String SELECT_BY_ID_USER = "SELECT * FROM BANK_KART WHERE id_user=?;";
    private static final String INSERT_INTO_BANK_KART = "INSERT INTO BANK_KART (strana,schot,valuta,id_user)  VALUES (?,?,?,?);";
    private static final String DELETE_BANK_KART_BY_ID_KART = "DELETE FROM BANK_KART WHERE id_kart=?";
    private static final String GET_BANK_KART_BY_ID_USER = "SELECT name,surname,schot,valuta FROM USERS INNER JOIN BANK_KART ON USERS .id=BANK_KART.id_user AND BANK_KART.id_user=?;";
    private static final String GET_BANK_KART_BY_STRANA = "SELECT * FROM BANK_KART WHERE strana=?;";

    @Override
    public List<UsersKart> getAllUsersKartByUsersName(String name, Connection connection){
        return null;
    }

    @Override
    public void birthdate(Integer id, Connection connection) {
    }

    @Override
    public void update(UsersKart entity, Connection connection) {
    }

    @Override
    public List<UsersKart> getUsersKartByUserId(int userId, Connection connection) {
        List<UsersKart> usersKarts=new ArrayList<>();
        try(PreparedStatement preparedStatement=connection.prepareStatement(SELECT_BY_ID_USER)){
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                int iduser=resultSet.getInt("id_user");
                String strana=resultSet.getString("strana");
                int schot=resultSet.getInt("schot");
                String valuta=resultSet.getString("valuta");
                usersKarts.add(new UsersKart(iduser,strana,schot,valuta));
            }
        }
        catch (SQLException ex){
            System.out.println("Error entry information");
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return usersKarts;
    }

    @Override
    public List<UsersKart> getAllBankKart(Connection connection) {
        List<UsersKart> usersKarts=new ArrayList<>();
        try(PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_FROM_BANK_KART)){
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idkart=resultSet.getInt("id_kart");
                int iduser=resultSet.getInt("id_user");
                String strana=resultSet.getString("strana");
                int schot=resultSet.getInt("schot");
                String valuta=resultSet.getString("valuta");
                usersKarts.add(new UsersKart(idkart,iduser,strana,schot,,valuta));
            }
        }
        catch (SQLException ex){
            System.out.println("Error entry information");
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return usersKarts;
    }

    @Override
    public void insert(UsersKart entity, Connection connection) {
        try(PreparedStatement preparedStatement=connection.prepareStatement(INSERT_INTO_BANK_KART)){
            preparedStatement.setString(1,entity.getStrana());
            preparedStatement.setInt(2,entity.getSchot());
            preparedStatement.setString(3,entity.getValuta());
            preparedStatement.setInt(4,entity.getId_user());
            preparedStatement.executeUpdate();
            System.out.println("Added entry in BANK_KART table");
        }
        catch(SQLException ex) {
            System.out.println("Error added entry in BANK_KART table");
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public UsersKart getEntityById(Integer id, Connection connection) {
        return null;
    }

    @Override
    public void delete(Integer id_kart, Connection connection) {

        try (PreparedStatement preparedStatement=connection.prepareStatement(DELETE_BANK_KART_BY_ID_KART){
            preparedStatement.setInt(1,id_kart);
            preparedStatement.executeUpdate();
            System.out.println("Entry delete");
        }
        catch (SQLException ex){
            System.out.println("Error delete entry");
            ex.printStackTrace();

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public List<UsersKart> getAllEntity(Connection connection) {
        return null;
    }

    @Override
    public List<UsersKart> getBankKartByIdUser(int writerId, Connection connection) {
        ArrayList<UsersKart> usersKarts=new ArrayList<>();
        try (PreparedStatement preparedStatement=connection.prepareStatement(GET_BANK_KART_BY_ID_USER)){
            preparedStatement.setInt(1,writerId);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                String userName=resultSet.getString("name");
                String strana=resultSet.getString("strana");
                int schot=resultSet.getInt("schot");
                String valuta=resultSet.getString("valuta");
                usersKarts.add(new UsersKart(userName,strana,schot,valuta));
            }
        }
        catch (SQLException ex){
            System.out.println("Error getting record");
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return usersKarts;
    }

    @Override
    public Users getUsersKartInfoByStrana(String strana, Connection connection) {
        ResultSet resultSet;
        Users users = null;
        try(PreparedStatement preparedStatement=connection.prepareStatement(GET_BANK_KART_BY_STRANA)){
            preparedStatement.setString(1,strana);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id_kart=resultSet.getInt("id_kart");
                String strana=resultSet.getString("strana");
                int schot=resultSet.getInt("schot");
                String valuta=resultSet.getString("valuta");
                int id_user=resultSet.getInt("id_user");
                users=new Users(id_kart,strana,schot,valuta,id_user);
            }
        }
        catch (SQLException ex){
            System.out.println("Error getting record");
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return users;
    }

    @Override
    public List<UsersKart> getUsersKartByIdUsers(int id_user, Connection connection) {
        return null;
    }

    @Override
    public List<UsersKart> getBank_kartByUserName(String name, Connection connection) {
        return null;
    }

    @Override
    public String getEmailInfoByStrana(String email, Connection connection) {
        return null;
    }

}

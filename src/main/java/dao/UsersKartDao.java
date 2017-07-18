package dao;

import config.ConnectionDB;
import model.UsersKart;
import model.Users;
import interfaces.IntUsersKartDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class UsersKartDao implements IntUsersKartDao {
    private static final String SELECT_ALL_FROM_BANK_KART = "SELECT * FROM BANK_KART;";

    // private static final String SELECT_ALL_BY_ID_KART = "SELECT * FROM BANK_KART WHERE id_kart=?;";
    private static final String INSERT_INTO_BANK_KART = "INSERT INTO BANK_KART (strana,schot,valuta,id_user)  VALUES (?,?,?,?);";
    private static final String DELETE_BANK_KART_BY_ID_KART = "DELETE FROM BANK_KART WHERE id_kart=?";
    private static final String GET_BANK_KART_BY_ID_USER = "SELECT name,surname,schot,valuta FROM USERS INNER JOIN BANK_KART ON USERS .id=BANK_KART.id_user AND BANK_KART.id_user=?;";
   // private static final String GET_EMAIL_BY_USERS = "SELECT name,email FROM USERS WHERE name=?;";
    private static final String GET_BANK_KART_INFO_BY_STRANA = "SELECT * FROM BANK_KART WHERE strana=?;";

    PreparedStatement preparedStatement;
    Connection connection= ConnectionDB.getConnection();
    ResultSet resultSet;

    @Override
    public void delete(Integer id_kart) {
        PreparedStatement preparedStatement;
        Connection connection= ConnectionDB.getConnection();

        try{
            preparedStatement=connection.prepareStatement(DELETE_BANK_KART_BY_ID_KART);
            preparedStatement.setInt(1,id_kart);
            preparedStatement.executeUpdate();
            System.out.println("Entry delete");
        }
        catch (SQLException ex){
            System.out.println("Error entry deleteL");
            ex.printStackTrace();

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void insert(UsersKart model) {
        PreparedStatement preparedStatement;
        Connection connection= ConnectionDB.getConnection();

        try{
            preparedStatement=connection.prepareStatement(INSERT_INTO_BANK_KART);
            preparedStatement.setString(1,model.getStrana());
            preparedStatement.setInt(2,model.getSchot());
            preparedStatement.setString(3,model.getValuta());
            preparedStatement.setInt(4,model.getId_user());
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
    public void update(UsersKart model) {
    }

    @Override
    public List<UsersKart> getAllBank_kartByUserName(String name);
    return null;
   }

    @Override
    public List<UsersKart> getAllModel() {
        PreparedStatement preparedStatement;
        Connection connection= ConnectionDB.getConnection();
        ResultSet resultSet;
        List<UsersKart> bank_kart=new ArrayList<>();
        try{
            preparedStatement=connection.prepareStatement(SELECT_ALL_FROM_BANK_KART);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id_kart=resultSet.getInt("id_kart");
                String strana=resultSet.getString("strana");
                int schot=resultSet.getInt("schot");
                int id_user=resultSet.getInt("id_user");
                bank_kart.add(new UsersKart(id_kart,strana,schot,id_user));
            }
        }
        catch (SQLException ex){
            System.out.println("Error entry information");
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return bank_kart;
    }

    @Override
    public List<UsersKart> getBank_kartById_user(int writerId) {
        PreparedStatement preparedStatement;
        Connection connection= ConnectionDB.getConnection();
        ArrayList<UsersKart> usersKarts=new ArrayList<>();
        try {
            preparedStatement=connection.prepareStatement(GET_BANK_KART_BY_ID_USER);
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

   // @Override
   // public UsersKart getModelById_kart(Integer id_kart) {
   //     return null;
  //  }

    @Override
    public UsersKart getUsersKartInfoByStrana(String strana) {
        PreparedStatement preparedStatement;
        Connection connection= ConnectionDB.getConnection();
        ResultSet resultSet;
        UsersKart usersKart=null;

        try{
            preparedStatement=connection.prepareStatement(GET_BANK_KART_INFO_BY_STRANA);
            preparedStatement.setString(1,strana);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id_kart=resultSet.getInt("id_kart");
                String stranaKart=resultSet.getString("strana");
                int schot=resultSet.getInt("schot");
                String valuta=resultSet.getString("valuta");
                int id_user=resultSet.getInt("id_user");
                usersKart=new UsersKart(id_kart,stranaKart,schot,valuta,id_user);
            }

        }
        catch (SQLException ex){
            System.out.println("Error getting record");
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return usersKart;
    }
}

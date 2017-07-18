package dao;

import config.ConnectionDB;
import model.UsersKart;
import model.Users;
import interfaces.IntUsersDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class UsersDao implements IntUsersDao {
    public ArrayList<UsersKart> getBank_kartById_user(int id) {
        return null;
    }

    public Users getUserInfoByName(String name) {
        return null;
    }
    

    private static final String SELECT_ALL_FROM_USERS="SELECT * FROM BANK_KART;";
    private static final String SELECT_ALL_BY_ID="SELECT * FROM USERS id=?;";
    private static final String INSERT_INTO_USERS="INSERT INTO USERS (name,surname,birthdate,email)  VALUES (?,?,?,?);";
    private static final String DELETE_USERS_BY_ID="DELETE FROM USERS WHERE id=?";
    private static final String GET_BANK_KART_BY_USERS_ID="SELECT strana,schot,valuta FROM USERS INNER JOIN BANK_KART ON USERS.id=BANK_KART.USERS_id AND BANK_KART.USERS_id=?;";
    private static final String GET_ALEXANDR_BY_USERS="SELECT name,ALEXANDR FROM USERS WHERE name=?;";
    private static final String GET_USERS_INFO_BY_NAME="SELECT * FROM USERS WHERE name=?;";

    private PreparedStatement preparedStatement;
    private Connection connection=ConnectionDB.getConnection();
    private ResultSet resultSet;



    @Override
    public void delete(Integer id) {
        try{
            preparedStatement=connection.prepareStatement(DELETE_USERS_BY_ID);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            System.out.println("Entry delete");
        }
        catch (SQLException ex){
            System.out.println("Error entry delete");
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
        }

    }

    @Override
    public void insert(Users model) {
        try{
            preparedStatement=connection.prepareStatement(INSERT_INTO_USERS);
            preparedStatement.setString(1,model.getName());
            preparedStatement.setString(2,model.getSurname());
            preparedStatement.setString(3, String.valueOf(model.getBirthdate()));
            preparedStatement.setString(4,model.getEmail());
            preparedStatement.executeUpdate();
            System.out.println("Added entry in Users table");
        }
        catch(SQLException ex) {
            System.err.println("Error added entry in Users table");
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Users model) {

    }

    @Override
    public ArrayList<UsersKart> getUsersKartById_user(int id) {

        ArrayList<UsersKart> bank_karts=new ArrayList<>();
        try {
            preparedStatement=connection.prepareStatement(GET_BANK_KART_BY_USERS_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id_user=resultSet.getInt("id_user");
                String strana=resultSet.getString("strana");
                int schot=resultSet.getInt("schot");
                String valuta=resultSet.getString("valuta");
                bank_karts.add(new UsersKart(id_user, strana, schot, valuta));
            }
        }
        catch (SQLException ex){
            System.err.println("Error entry information");
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return bank_karts;
    }

   /* @Override
    public List<UsersKart> getAllModel() {
        List<Users> usersList=new ArrayList<>();
        try{
            preparedStatement=connection.prepareStatement(SELECT_ALL_FROM_USERS);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String surname=resultSet.getString("surname");
                int birthdate=resultSet.getInt("birthdate");
                String email=resultSet.getString("email");
                usersList.add(new Users(id,name,surname,birthdate,email));
            }
        }
        catch (SQLException ex){
            System.out.println("Error getting record");
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return  usersList;
    }*/

    @Override
    public Users getEntityById(Integer id) {
        Users users=null;
        try{
            preparedStatement=connection.prepareStatement(SELECT_ALL_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {

                String name=resultSet.getString("name");
                String surname=resultSet.getString("surname");
                int birthdate=resultSet.getInt("birthdate");
                String email=resultSet.getString("email");
                users=new Users(id,name,surname,birthdate,email);

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
    public Users getWriterInfoByName(String name) {
        Users users=null;


        try{
            preparedStatement=connection.prepareStatement(GET_USERS_INFO_BY_NAME);
            preparedStatement.setString(1,name);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id=resultSet.getInt("id");
                String writer=resultSet.getString("name");
                String surname=resultSet.getString("surname");
                int birthdate=resultSet.getInt("birthdate");
                String email=resultSet.getString("email");
                users=new Users(id,name,surname,birthdate,email);

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
}
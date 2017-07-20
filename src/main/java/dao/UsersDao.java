package dao;

import config.ConnectionDB;
import model.UsersKart;
import model.Users;
import interfaces.IntUsersDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDao implements IntUsersDao {
    public ArrayList<UsersKart> getBank_kartById_user(int id) {
        return null;
    }

    public Users getUserInfoByName(String name) {
        return null;
    }


    private static final String SELECT_ALL_FROM_USERS = "SELECT * FROM BANK_KART;";
    private static final String SELECT_ALL_BY_ID = "SELECT * FROM USERS id=?;";
    private static final String INSERT_INTO_USERS = "INSERT INTO USERS (name,surname,birthdate,email)  VALUES (?,?,?,?);";
    private static final String DELETE_USERS_BY_ID = "DELETE FROM USERS WHERE id=?";
    private static final String GET_BANK_KART_BY_USERS_ID = "SELECT strana,schot,valuta FROM USERS INNER JOIN BANK_KART ON USERS.id=BANK_KART.USERS_id AND BANK_KART.USERS_id=?;";
    private static final String GET_USERS_INFO_BY_NAME = "SELECT * FROM USERS WHERE name=?;";


    @Override
    public void delete(Integer id) {
        PreparedStatement preparedStatement;
        Connection connection = ConnectionDB.getConnection();

        try {
            preparedStatement = connection.prepareStatement(DELETE_USERS_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Entry delete");
        } catch (SQLException ex) {
            System.out.println("Error entry delete");
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }

    }

    @Override
    public void insert(UsersKart model) {

    }

    @Override
    public void update(UsersKart model) {

    }


    @Override
    public void insert(Users model) {
        PreparedStatement preparedStatement;
        Connection connection = ConnectionDB.getConnection();

        try {
            preparedStatement = connection.prepareStatement(INSERT_INTO_USERS);
            preparedStatement.setString(1, model.getName());
            preparedStatement.setString(2, model.getSurname());
            preparedStatement.setString(3, String.valueOf(model.getBirthdate()));
            preparedStatement.setString(4, model.getEmail());
            preparedStatement.executeUpdate();
            System.out.println("Added entry in Users table");
        } catch (SQLException ex) {
            System.err.println("Error added entry in Users table");
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override

    public void update(Users model) {

    }

    @Override
    public ArrayList<UsersKart> getUsersKartById_user(int id) {
        PreparedStatement preparedStatement;
        Connection connection = ConnectionDB.getConnection();
        ResultSet resultSet;
        ArrayList<UsersKart> bank_karts = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(GET_BANK_KART_BY_USERS_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                id = resultSet.getInt("id");
                String strana = resultSet.getString("strana");
                int schot = resultSet.getInt("schot");
                String valuta = resultSet.getString("valuta");
                bank_karts.add(new UsersKart(name, strana, schot, valuta));
            }
        } catch (SQLException ex) {
            System.err.println("Error entry information");
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bank_karts;
    }

    @Override
    public List<UsersKart> getAllModel() {
        PreparedStatement preparedStatement;
        Connection connection = ConnectionDB.getConnection();
        ResultSet resultSet;
        List<Users> usersList = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL_FROM_USERS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int birthdate = resultSet.getInt("birthdate");
                String email = resultSet.getString("email");
                usersList.add(new Users(id, name, surname, birthdate, email));
            }
        } catch (SQLException ex) {
            System.out.println("Error getting record");
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
        return null;
    }


    @Override
    public UsersKart getModelById(Integer id) {
        return null;
    }

    @Override
    public Users getEntityById(Integer id) {
        PreparedStatement preparedStatement;
        Connection connection=ConnectionDB.getConnection();
        ResultSet resultSet;
        Users users=null;
        try{
            preparedStatement=connection.prepareStatement(SELECT_ALL_BY_ID);
            preparedStatement.setInt(1,id);
            resultSet=preparedStatement.executeQuery();
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
        PreparedStatement preparedStatement;
        Connection connection=ConnectionDB.getConnection();
        ResultSet resultSet;
        Users users=null;

        try{
            preparedStatement=connection.prepareStatement(GET_USERS_INFO_BY_NAME);
            preparedStatement.setString(1,name);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id=resultSet.getInt("id");
                name=resultSet.getString("name");
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
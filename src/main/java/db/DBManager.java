package db;

import java.awt.image.AreaAveragingScaleFilter;
import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    //private static ArrayList<User> users = new ArrayList<>();
    //private static Long id = 4L;
    public static Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //подтягиваю базу даннных

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_javaee?serverTimezone=UTC", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


 /*users.add(new User(1L, "Askar", "Aidosuly", 23, "male"));
        users.add(new User(2L, "Tolkyn", "Aidoskyzy", 26, "female"));
        users.add(new User(3L, "Aslan", "Amanbekov", 21, "male"));*/
    }

    public static boolean addUser(User user) {
        int rows = 0;

        try {
            PreparedStatement ps = connection.prepareStatement("" +
                    "INSERT INTO user(name,surname,age,gender,country_id) " +
                    "VALUES (?, ?, ?, ?, ?)");

            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setInt(3, user.getAge());
            ps.setString(4, user.getGender());
            ps.setLong(5, user.getCountry().getId());

            rows = ps.executeUpdate();
            System.out.println(rows);
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows > 0;

        /* user.setId(id);
        users.add(user);
        id++;*/
    }

    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        //return users;
        try {
            PreparedStatement ps = connection.prepareStatement("" +
                    "SELECT u.id,u.name,u.surname,u.age,u.gender,u.country_id,c.name AS CountryName,c.code,c.population " +
                    "FROM user u " +
                    "INNER JOIN country c on u.country_id = c.id");

            ResultSet resultSet = ps.executeQuery();
            System.out.println(resultSet.toString());

            while (resultSet.next()) {
                users.add(
                        new User(
                                resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getString("surname"),
                                resultSet.getInt("age"),
                                resultSet.getString("gender"),
                                new Country(
                                        resultSet.getLong("country_id"),
                                        resultSet.getString("CountryName"),
                                        resultSet.getString("code"),
                                        resultSet.getInt("population")
                                )
                        )
                );
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static ArrayList<Country> getCountries() {
        ArrayList<Country> countries = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("" +
                    "SELECT * FROM country");

            ResultSet resultSet = ps.executeQuery();
            System.out.println(resultSet.toString());

            while (resultSet.next()) {
                countries.add(
                        new Country(
                                resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getString("code"),
                                resultSet.getInt("population")
                        )
                );
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }

    public static User getUser(Long id) {
        User user = null;

        try {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT u.id,u.name,u.surname,u.age,u.gender,u.country_id,c.name AS CountryName,c.code,c.population " +
                            "FROM user u " +
                            "INNER JOIN country c on u.country_id = c.id" + "" +
                            "WHERE u.id =?");

            ps.setLong(1, id);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getString("gender"),
                        new Country(
                                resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getString("code"),
                                resultSet.getInt("population")
                        )
                );
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

           /*  for (User user:
             users) {
            if (user.getId().equals(id)){
                return user;
            }
        }

        return null;



     */
    }

    public static boolean updateUser(Long id, User user) {
        int rows = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE user SET name = ?,surname = ?,age = ?,country_id = ? WHERE id = ?");
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setInt(3, user.getAge());
            ps.setLong(4, user.getCountry().getId());
            ps.setLong(5, id);

            rows = ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows > 0;
    }

    public static boolean deleteUser(Long id) {
        int rows = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "DELETE FROM user WHERE id=?"
            );

            ps.setLong(1, id);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows  > 0;
    }

    public static Account getAccount(String email){
        Account account = null;

        try {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT * FROM account WHERE email=?");

            ps.setString(1,email);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                account = new Account(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name")
                );
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
}






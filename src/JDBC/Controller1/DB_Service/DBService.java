package JDBC.Controller1.DB_Service;

import java.sql.*;

public class DBService {
    static Connection con;

    public static Connection getConnection(String db, String user, String pass) {
        db = "ecommerce";
        user = "root";
        pass = "Mexico18";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con  =DriverManager.getConnection("jdbc:mysql://localhost/"+db+"?user="+user+"&password="+pass);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }

     public static void close(Statement statement, Connection connection) {
            try {

                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {

            }
        }

    }

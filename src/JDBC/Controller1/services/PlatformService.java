package JDBC.Controller1.services;

import JDBC.Controller1.DB_Service.DBService;
import JDBC.Controller1.Data.PlatformData;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PlatformService {

    private static ResultSet resultSet = null;
    private static Connection connection = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;


    public void listAllPlatforms() {
        connection = DBService.getConnection("a", "b", "c");

        // Statements allow to issue SQL queries to the database
        try {
            statement = connection.createStatement();
            //use statement object because we did not have to use any values.
            //build in method. need to call this before executing. prepping connection by creating a statement object
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select * from ecommerce.platforms;");
            //anytime you execute a query you get something back

            writeResultSet(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBService.close(preparedStatement, connection);        }
    }


    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String name = resultSet.getString("name");         //String description = resultSet.getString("description");
            String url = resultSet.getString("url");        //get the string which is in column url
            double sales_fee = resultSet.getDouble("sales_fee");

            System.out.println("Name: " + name);
            System.out.println("---------------------------------");

            // System.out.println("Description: " + description);
            System.out.println("URL: " + url);
            System.out.println("---------------------------------");

            System.out.println("Sales_fee: " + sales_fee);
            System.out.println("---------------------------------");

        }
    }


    public void createNewPlatform() {
        connection = DBService.getConnection("a", "b", "c");
        try {
            preparedStatement = connection.prepareStatement("insert into  ecommerce.platforms (name, url, sales_fee) " +
                    "values (?, ?, ?)");

            // Parameters start with 1
            System.out.println("please enter name");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();
            preparedStatement.setString(1, name);
            // preparedStatement.setString(2, credits);
            System.out.println("please enter url");

            String url = scanner.next();
            preparedStatement.setString(2, url);
            System.out.println("please enter the sales fee");

            double sales_fee = scanner.nextDouble();
            preparedStatement.setDouble(3, sales_fee);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBService.close(preparedStatement, connection);
        }
    }



    public void deleteNewPlatform () {
        connection = DBService.getConnection("a", "b", "c");
        try {
            preparedStatement = connection.prepareStatement("delete from ecommerce.platforms where name = ?");

            System.out.println("enter name you want to delete");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBService.close(preparedStatement, connection);
        }
    }
    private ArrayList<PlatformData> mapResultSetToObjects(ResultSet resultSet) throws SQLException {

        ArrayList<PlatformData> platformList = new ArrayList();

        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            PlatformData c = new PlatformData();
            c.setId(resultSet.getInt("id"));
            c.setName(resultSet.getString("name"));
            c.setUrl(resultSet.getString("url"));
            c.setSales_fee(resultSet.getDouble("sales_fee"));


            platformList.add(c);
        }

        return platformList;
    }


}


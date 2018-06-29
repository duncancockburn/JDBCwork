package JDBC.Controller1.services;

import JDBC.Controller1.DB_Service.DBService;
import JDBC.Controller1.Data.ProductData;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EcommerceDBProduct {

    private static ResultSet resultSet = null;
    private static Connection connection = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;


    public void listAllProducts() {
        connection = DBService.getConnection("a", "b", "c");
        // Statements allow to issue SQL queries to the database
        try {
            statement = connection.createStatement();
            //use statement object because we did not have to use any values.
            //build in method. need to call this before executing. prepping connection by creating a statement object
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select * from ecommerce.products;");
            //anytime you execute a query you get something back

            writeResultSet(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBService.close(statement, connection);
        }
    }


    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String product_name = resultSet.getString("product_name");         //String description = resultSet.getString("description");
            String product_description = resultSet.getString("product_description");        //get the string which is in column url

            System.out.println("Name: " + product_name);
            System.out.println("---------------------------------");

            // System.out.println("Description: " + description);
            System.out.println("product description: " + product_description);
            System.out.println("---------------------------------");
        }
    }


    public void createNewProduct () {
        connection = DBService.getConnection("a", "b", "c");
        try {
            preparedStatement = connection.prepareStatement("insert into  ecommerce.products (product_name, product_description" +
                    "values (?, ?)");

            // Parameters start with 1
            System.out.println("please enter name");
            Scanner scanner = new Scanner(System.in);
            String product_name = scanner.next();
            preparedStatement.setString(1, product_name);
            // preparedStatement.setString(2, credits);
            System.out.println("please enter product name");

            String product_description = scanner.next();
            preparedStatement.setString(2, product_description);
            System.out.println("please enter the product description");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBService.close(preparedStatement, connection);
        }
    }


    public void deleteProductByID () {
        connection = DBService.getConnection("a", "b", "c");
        try {
            preparedStatement = connection.prepareStatement("delete from ecommerce.products where product_name = ?");

            System.out.println("enter product name you want to delete");
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





    private ArrayList<ProductData> mapResultSetToObjects(ResultSet resultSet) throws SQLException {

        ArrayList<ProductData> productList = new ArrayList();

        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            ProductData c = new ProductData();
            c.setId(resultSet.getInt("id"));
            c.setP_name(resultSet.getString("name"));
            c.setP_description(resultSet.getString("description"));

            productList.add(c);
        }

        return productList;
    }



}


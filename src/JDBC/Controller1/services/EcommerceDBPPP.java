package JDBC.Controller1.services;

import JDBC.Controller1.DB_Service.DBService;
import JDBC.Controller1.Data.PPPDate;

import java.sql.*;
import java.util.ArrayList;

public class EcommerceDBPPP {

    private static ResultSet resultSet = null;
    private static Connection connection = null;
    private static Statement statement = null;


    public void listAllPPP() {
        connection = DBService.getConnection("a", "b", "c");
        // Statements allow to issue SQL queries to the database
        try {
            statement = connection.createStatement();
            //use statement object because we did not have to use any values.
            //build in method. need to call this before executing. prepping connection by creating a statement object
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select * from ecommerce.ppp;");
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
            String product_id = resultSet.getString("product_id");         //String description = resultSet.getString("description");
            String platform_id = resultSet.getString("platform_id");        //get the string which is in column url
            String price = resultSet.getString("price");

            System.out.println("Name: " + product_id);
            System.out.println("---------------------------------");

            // System.out.println("Description: " + description);
            System.out.println("platform_id: " + platform_id);
            System.out.println("---------------------------------");

            // System.out.println("Description: " + description);
            System.out.println("price: " + price);
            System.out.println("---------------------------------");

        }
    }
    private ArrayList<PPPDate> mapResultSetToObjects(ResultSet resultSet) throws SQLException {

        ArrayList<PPPDate> priceList = new ArrayList();

        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            PPPDate c = new PPPDate();
            c.setId(resultSet.getInt("id"));
            c.setPrice(resultSet.getInt("id"));

            priceList.add(c);
        }

        return priceList;
    }

}

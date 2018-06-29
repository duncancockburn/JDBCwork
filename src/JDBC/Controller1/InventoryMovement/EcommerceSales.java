package JDBC.Controller1.InventoryMovement;

import JDBC.Controller1.DB_Service.DBService;

import java.sql.*;

public class EcommerceSales {

    private static ResultSet resultSet = null;
    private static Connection connection = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;


    public void getPriceData() {
        connection = DBService.getConnection("a", "b", "c");

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select price from ecommerce.inventory;");

            listAll(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DBService.close(statement, connection);
        }
    }

    private void listAll(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            String product_id = resultSet.getString("product_id");         //String description = resultSet.getString("description");
            String quantity = resultSet.getString("quantity");        //get the string which is in column url

            System.out.println("product_id: " + product_id);
            System.out.println("---------------------------------");

            // System.out.println("Description: " + description);
            System.out.println("product quantity: " + quantity);
            System.out.println("---------------------------------");
        }
    }
}

package JDBC.Controller1.InventoryMovement;

import JDBC.Controller1.DB_Service.DBService;

import java.sql.*;
import java.util.Scanner;

public class EcommerceInventory {


    private static ResultSet resultSet = null;
    private static Connection connection = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;


    public void listStock() {
        connection = DBService.getConnection("a", "b", "c");

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from ecommerce.inventory;");

            listAll(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DBService.close(statement, connection);
        }
    }


    private void listAll(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String product_id = resultSet.getString("product_id");
            String quantity = resultSet.getString("quantity");

            System.out.println("product_id: " + product_id);
            System.out.println("---------------------------------");

            System.out.println("product quantity: " + quantity);
            System.out.println("---------------------------------");
        }
    }


    public void buyProductbyID() {
        connection = DBService.getConnection("a", "b", "c");

        try {
            preparedStatement = connection.prepareStatement("insert into  ecommerce.inventory (product_id, quantity) " +
                    "values (?, ?)");

            System.out.println("what did you buy??");
            Scanner scanner = new Scanner(System.in);

            int quantity = Integer.parseInt(scanner.next());
            preparedStatement.setInt(1, quantity);
            System.out.println("what quantity did you buy?");

            int product_id = Integer.parseInt(scanner.next());
            preparedStatement.setInt(2, product_id);
            System.out.println("please enter the sales fee");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void returnProductbyID() {
        connection = DBService.getConnection("a", "b", "c");


    }

    public void sellProductbyID() {

    }

}

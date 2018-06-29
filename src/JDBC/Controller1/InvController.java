package JDBC.Controller1;

import JDBC.Controller1.InventoryMovement.EcommerceInventory;
import JDBC.Controller1.InventoryMovement.EcommerceSales;
import JDBC.Controller1.services.EcommerceDBPPP;
import JDBC.Controller1.services.EcommerceDBProduct;

import java.util.Scanner;


public class InvController {

    public static void main(String[] args) {
        JDBC.Controller1.Controller c = new JDBC.Controller1.Controller();
        c.loopingController();      //calling the looping controller method

    }


    public void loopingController() {
        EcommerceDBProduct db2 = new EcommerceDBProduct();
        EcommerceDBPPP db3 = new EcommerceDBPPP();
        EcommerceInventory db4 = new EcommerceInventory();
        EcommerceSales db5 = new EcommerceSales();



        int user_input = 0;
        Scanner scanner = new Scanner(System.in);

        do {                                        //do while because want to print at least once
            printMenu();
            user_input = scanner.nextInt();

            switch (user_input) {
                case 0:
                    db4.listStock();
                    break;
                case 1:
                    db4.buyProductbyID();
                    db2.createNewProduct();
                    break;
                case 2:
                    db2.deleteProductByID();
                    db4.returnProductbyID();
                    break;
                case 3:
                    db4.sellProductbyID();
                    db2.deleteProductByID();
                    break;
                case 4:
                    db2.deleteProductByID();
                    break;
                case 5:
                    db3.listAllPPP();
                    break;
            }
        } while (user_input != -1);
    }

    public void printMenu() {
        System.out.println("**************");
        System.out.println("Ecommerce Menu - Please choose one of the following options: ");
        System.out.println("Choose 0 to buy a product");
        System.out.println("Choose 1 to buy a product");
        System.out.println("Choose 2 return a product");
        System.out.println("Choose 3 to sell a product");
        System.out.println("Choose 4 if stock is obsolete");
        System.out.println("Enter -1-> to exit");
    }
}

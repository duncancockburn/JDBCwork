package JDBC.Controller1;

import JDBC.Controller1.services.EcommerceDBPPP;
import JDBC.Controller1.services.EcommerceDBProduct;
import JDBC.Controller1.services.PlatformService;

import java.util.Scanner;

public class Controller {

    public static void main(String[] args) {
        Controller c = new Controller();
        c.loopingController();      //calling the looping controller method

    }

    public void loopingController() {
        PlatformService db1 = new PlatformService();
        EcommerceDBProduct db2 = new EcommerceDBProduct();
        EcommerceDBPPP db3 = new EcommerceDBPPP();


        int user_input = 0;
        Scanner scanner = new Scanner(System.in);

        do {                                        //do while because want to print at least once
            printMenu();
            user_input = scanner.nextInt();

            switch (user_input) {
                case 1:
                    db2.listAllProducts();
                    break;
                case 2:
                    db2.createNewProduct();
                    break;
                case 3:
                    db2.deleteProductByID();
                    break;
                case 4:
                    db1.listAllPlatforms();
                    break;
                case 5:
                    db1.createNewPlatform();
                    break;
                case 6:
                    db1.deleteNewPlatform();
                    break;
                case 7:
                    db3.listAllPPP();

            }
        } while (user_input != -1);
    }

    public void printMenu(){
        System.out.println("**************");
        System.out.println("Ecommerce Menu - Please choose one of the following options: ");
        System.out.println("Enter 1-> to view all products");
        System.out.println("Enter 2-> to create a new product");
        System.out.println("Enter 3-> to delete a product by ID");
        System.out.println("Enter 4-> to view all platforms");
        System.out.println("Enter 5-> to create a new platform");
        System.out.println("Enter 6-> to delete a platform by ID");
        System.out.println("Enter -1-> to exit");
    }
}






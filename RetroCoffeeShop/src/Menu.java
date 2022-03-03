import java.sql.*;
import java.util.*;


public class Menu {
    public static double subTotal;
    public static double runningTotal;
    private static double itemPrice;
    static boolean ordering = true;
    public static String name;
    public static String phone;
    public static int tax=100;
//    public double total;
    static Scanner input = new Scanner(System.in);

    public static void menu() {
		System.out.println("Enter your name: ");
		String name = input.nextLine();
		
		System.out.println("Enter your Mobilenumber: ");
		String phone = input.nextLine();

  
        System.out.println("Welcome \n1. Espresso (265) \n2. Americano (250)\n3. Cappuccino (260) \n4. Vanilla Latte (419) \n5.Mocha(325) \n6. Macchiato(495) \n7.Hot chocolate(240) \n8.cold brew black(280) \n9.Caramel Frappuccino (299) \n10.Done");
    }

    public static double itemPrice(int foodItem) {
        if (foodItem == 1) {
            System.out.println("You've ordered a Espresso");
            itemPrice = 265;
        }
        if (foodItem == 2) {
            System.out.println("You've ordered Americano");
            itemPrice = 250;
        }
        if (foodItem == 3) {
            System.out.println("You've ordered a Cappuccino");
            itemPrice = 260;
        }
        if (foodItem == 4) {
            System.out.println("You've ordered a Vanilla Latte");
            itemPrice = 419;
        }
        if (foodItem == 5) {
            System.out.println("You've ordered a Mocha");
            itemPrice = 325;
        }
        if (foodItem == 6) {
            System.out.println("You've ordered a Macchiato");
            itemPrice = 495;
        }
        if (foodItem == 7) {
            System.out.println("You've ordered a Hot chocolate");
            itemPrice = 240;
        }
        if (foodItem == 8) {
            System.out.println("You've ordered a cold brew black");
            itemPrice = 280;
        }
        if (foodItem == 9) {
            System.out.println("You've ordered a Caramel Frappuccino");
            itemPrice = 299;
        }
        quantity();
        return itemPrice;
    }

    public static double quantity() {
        System.out.println("Enter quantity");
        double quantity = input.nextDouble();
        subTotal(quantity, itemPrice);
        return quantity;
    }

    public static double subTotal(double quantity, double itemPrice) {
        double subTotal = quantity * itemPrice;
        System.out.println("Subtotal: " + subTotal);
        return subTotal;
    }

    public static void done(double runningTotal) {
        ordering = false;
        System.out.println(runningTotal);
        System.out.println("Enjoy your meal");
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    	String url="jdbc:mysql://sql3.freesqldatabase.com:3306/sql3476648";
		String username="sql3476648";
		String password="SU7K3fmlti";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		Connection connection=DriverManager.getConnection(url,username,password);
		
		Statement statement=connection.createStatement();
		String query1 = "INSERT INTO `order` (`name`, `phone`, `beverage`, `quantity`, `price`, `subtotal`, `tax`, `total`) VALUES ('Laks', '9345323858', 'Mocha ', '2', '500', '1000', '100', '1600')";
		  statement.executeUpdate(query1);
		
        int menuOption;
        int foodItem = 0;
        input = new Scanner(System.in);
        menu();
        do {
            double runningTotal = 0;
           
            menuOption = input.nextInt();
            switch (menuOption) {
            case 1:
                foodItem = 1;
                itemPrice(foodItem);
                break;
            case 2:
                foodItem = 2;
                itemPrice(foodItem);
                break;
            case 3:
                foodItem = 3;
                itemPrice(foodItem);
                break;
            case 4:
                foodItem = 4;
                itemPrice(foodItem);
                break;
            case 5:
                foodItem = 5;
                itemPrice(foodItem);
                break;
            case 6:
                foodItem = 6;
                itemPrice(foodItem);
                break;
            case 7:
                foodItem = 7;
                itemPrice(foodItem);
                break;
            case 8:
                foodItem = 8;
                itemPrice(foodItem);
                break;
            case 9:
                foodItem = 9;
                itemPrice(foodItem);
                break;
            case 10:
                done(runningTotal);
                break;
            default:
                System.out.println("Invalid option.");
            }
        } while (ordering);
        {
          subTotal(quantity(), itemPrice(foodItem));
            runningTotal = runningTotal + subTotal(quantity(), itemPrice(foodItem));
   
        }
        try {
 	       
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			
//			
//			Connection connection=DriverManager.getConnection(url,username,password);
//			
//			Statement statement=connection.createStatement();
////			String query1 = "INSERT INTO `order`(`name`, `phone`, `beverage`, `price`, `subtotal`,`tax`,`total`) VALUES ("+name+",'"+phone+"',"+foodItem+",'"+itemPrice+"','"+subTotal+"','"+tax+"','"+runningTotal+"')";
////     	    statement.executeUpdate(query1);
//			String query1 = "INSERT INTO `order` (`name`, `phone`, `beverage`, `quantity`, `price`, `subtotal`, `tax`, `total`) VALUES ('Laks', '9345323858', 'Mocha ', '2', '500', '1000', '100', '1600')";
//			  statement.executeUpdate(query1);
     	   connection.close();
    }
catch(Exception e) {
			
			System.out.println(e);
		}
 }
}



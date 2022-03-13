import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Menu{
	public static int quantity;
	public static int subTotal;
    public static double runningTotal;
    private static int itemPrice;
    static boolean ordering = true;
    public static String name;
    public static String name1;
    public static String name2;
    public static String date1;
    public static String phone;
    public static String bev;
    public static double tax;
    public static double points;
    public static Date TodayDate =new Date();
    public static SimpleDateFormat dateForm= new SimpleDateFormat("YYYY-MM-dd");
    static Scanner input = new Scanner(System.in);
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		int menuOption;
        int foodItem = 0;
        String name;
        String phone;
        boolean x = true;
        input = new Scanner(System.in);
		
		String url="jdbc:mysql://sql3.freesqldatabase.com:3306/sql3478781";
		String username="sql3478781";
		String password="apHwkDTRBT";
		
		try {
	
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			Connection connection=DriverManager.getConnection(url,username,password);
			
			Statement statement=connection.createStatement();
	        while(x) {
			System.out.println("Welcome\n 1.Order Entry\n 2.Bill\n 3.Points\n 4.Report\n");
			int option=input.nextInt();
			switch(option)
			{
			case 1:
			{
				System.out.println("Enter your name: ");
				name = input.next();
				
				System.out.println("Enter your Mobilenumber: ");
				phone = input.next();
				
				System.out.println(" \n1. Espresso (265) \n2. Americano (250)\n3. Cappuccino (260) \n4. Vanilla Latte (419) \n5.Mocha(325) \n6. Macchiato(495) \n7.Hot chocolate(240) \n8.cold brew black(280) \n9.Caramel Frappuccino (299) \n10.Exit");
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
	            default:
	                System.out.println("Invalid option.");
	                break;
	            }
				String query1 = "INSERT INTO `shop` (`name`, `phone`, `beverage`, `quantity`, `price`, `subtotal`, `tax`, `total`,`points`,`date`) VALUES ('"+name+"', '"+phone+"', '"+bev+"',"+quantity+","+itemPrice+","+subTotal+","+tax+","+runningTotal+","+points+",'"+dateForm.format(TodayDate)+"')";
         	    statement.executeUpdate(query1);
         	    break;
			}
			case 2:{
				System.out.println("Enter your name: ");
				name1 = input.next();
				
			ResultSet result = statement.executeQuery("SELECT * FROM `shop` WHERE name='"+name1+"'");
       	 while(result.next()) {
					
 				System.out.println(result.getString(1)+ "\nBeverage:" + result.getString(3)+"\nQuantity:"+ result.getInt(4)+"\nCost:"+ result.getInt(5)+"\nSubtotal "+result.getInt(6)+"\nGST%:"+result.getInt(7)+"\nTotal:"+result.getInt(8));
 			    
			  }
       	 break;
			}
			case 3:{
				System.out.println("Enter your name: ");
				name2 = input.next();
				
			ResultSet result = statement.executeQuery("SELECT * FROM `shop` WHERE name='"+name1+"'");
       	 while(result.next()) {
					
 				System.out.println("Points:"+result.getString(9));
 			
			  }
       	 break;
			}
			case 4:{
				System.out.println("Enter date: ");
				date1 = input.next();
				
			ResultSet result = statement.executeQuery("SELECT * FROM `shop` WHERE date='"+date1+"'");
       	 while(result.next()) {
					
       		System.out.println(result.getString(1)+ "\nBeverage:" + result.getString(3)+"\nQuantity:"+ result.getInt(4)+"\nCost:"+ result.getInt(5)+"\nSubtotal "+result.getInt(6)+"\nGST%:"+result.getInt(7)+"\nTotal:"+result.getInt(8));
 			
			  }
       	System.out.println("press 1 to continue and 0 to stop");
		int y=input.nextInt();
		if(y==1)
		{
			x=true;
		}
		else {
			x=false;
			exit();
		}
       	 break;
			}
			}
			System.out.println("press 1 to continue and 0 to stop");
			int y=input.nextInt();
			if(y==1)
			{
				x=true;
			}
			else {
				x=false;
				done();
			}
	        }
	         
			
			
			connection.close();
				
				
			
		}
		catch(Exception e) {
			
			System.out.println(e);
		}
		

	}


	private static void done() {
        System.out.println("Enjoy your drink!");
	}
	private static void exit() {
        System.out.println("Thank you!");
        System.exit(0);
	}


	private static int itemPrice(int foodItem) {
		if (foodItem == 1) {
			bev="Espresso";
            System.out.println("You've ordered a Espresso");
            itemPrice = 265;
        }
        if (foodItem == 2) {
        	bev="Americano";
            System.out.println("You've ordered Americano");
            itemPrice = 250;
        }
        if (foodItem == 3) {
        	bev="Cappuccino";
            System.out.println("You've ordered a Cappuccino");
            itemPrice = 260;
        }
        if (foodItem == 4) {
        	bev="Vanilla Latte";
            System.out.println("You've ordered a Vanilla Latte");
            itemPrice = 419;
        }
        if (foodItem == 5) {
        	bev="Mocha";
            System.out.println("You've ordered a Mocha");
            itemPrice = 325;
        }
        if (foodItem == 6) {
        	bev="Macchiato";
            System.out.println("You've ordered a Macchiato");
            itemPrice = 495;
        }
        if (foodItem == 7) {
        	bev="Hot chocolate";
            System.out.println("You've ordered a Hot chocolate");
            itemPrice = 240;
        }
        if (foodItem == 8) {
        	bev="cold brew black";
            System.out.println("You've ordered a cold brew black");
            itemPrice = 280;
        }
        if (foodItem == 9) {
        	bev="Caramel Frappuccino";
            System.out.println("You've ordered a Caramel Frappuccino");
            itemPrice = 299;
        }
        quantity();
        return (int)itemPrice;
	}


	private static int quantity() {
		System.out.println("Enter quantity");
        quantity = input.nextInt();
        subTotal(quantity, itemPrice);
        return quantity;
	}


	private static int subTotal(int quantity, int itemPrice2) {
		subTotal = quantity * itemPrice;
		tax=(subTotal*0.05);
		runningTotal = subTotal + tax;
		points = runningTotal/10;
        return subTotal;
	}

}

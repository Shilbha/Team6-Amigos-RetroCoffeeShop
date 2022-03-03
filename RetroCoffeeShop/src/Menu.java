import java.util.Scanner;

public class Menu {
    public double subTotal;
    public static double runningTotal;
    private static double itemPrice;
    static boolean ordering = true;
    static Scanner input = new Scanner(System.in);

    public static void menu() {
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

    public static void main(String[] args) {
        int menuOption;
        int foodItem = 0;
        input = new Scanner(System.in);
        do {
            double runningTotal = 0;
            menu();
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
    }
}

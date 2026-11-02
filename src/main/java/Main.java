import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    static void main() {

        //setting up transactions.csv
        try {
            FileWriter writer = new FileWriter("transactions.csv");

            writer.write("date|time|description|vendor|amount\n" +
                    "2023-04-15|10:13:25|ergonomic keyboard|Amazon|-89.50\n" +
                    "2023-04-15|11:15:00|Invoice 1001 paid|Joe|1500.00");

            writer.close();
        }
        catch (IOException e) {
            System.out.println("ERROR could not read/create transactions.csv");
            e.printStackTrace();
        }
        //end

        //running first-time home screen
        homeScreen();
    }

    public static void homeScreen() {
        //method to initialize the home screen

        boolean running = true;

        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (running) {
            System.out.println("Welcome to the Accounting Ledger home screen");
            System.out.println("Please choose an option:");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");

            input = scanner.nextLine();

            //cases depending on what the user inputs
            switch (input) {
                case "D":
                    homeScreenMethods.addDeposit();
                    break;

                case "P":
                    homeScreenMethods.addPayment();
                    break;

                case "L":
                    homeScreenMethods.viewLedger();
                    break;

                case "X":
                    System.out.println("Exiting\n Goodbye");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option");
                    break;
            }

        }
    }


}

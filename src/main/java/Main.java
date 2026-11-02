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

        while (running) {
            System.out.println("Welcome to the Accounting Ledger");
            System.out.println("Please choose an option:");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            //cases depending on what the user inputs
            switch (input) {
                case "D":
                    addDeposit();
                    break;

                case "P":
                    System.out.println("Adding payment");
                    break;

                case "L":
                    System.out.println("Viewing ledger");
                    break;

                case "X":
                    System.out.println("Exiting\n Goodbye");
                    running = false;
                    scanner.close();
                    break;

                default:
                    System.out.println("Invalid option");
                    break;
            }

        }
    }

    public static void addDeposit() {
        //method to initialize the add deposit option

        Scanner depScanner = new Scanner(System.in);

        System.out.println("Please input your deposit information in this format:");
        System.out.println("date|time|description|vendor|amount");
        String depInput = depScanner.nextLine();

        //reading the transactions.csv file and then adding the user's input to the file
        try {
            FileWriter writer = new FileWriter("transactions.csv", true);

            writer.write("\n" + depInput);
            writer.close();

            System.out.println("Information added successfully");
        }
        catch (IOException e) {
            System.out.println("ERROR could not add information");
            e.printStackTrace();
        }
    }
}

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
                    addDeposit();
                    break;

                case "P":
                    addPayment();
                    break;

                case "L":
                    viewLedger();
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

    public static void addPayment() {

    }

    public static void viewLedger() {
        //method to initialize the ledger

        boolean active = true;

        while (active) {
            System.out.println("Welcome to the Ledger page");
            System.out.println("Please select an option:");
            System.out.println("A) Display all entries");
            System.out.println("D) Display entries that are only deposits");
            System.out.println("P) Display only negative entries (or payments)");
            System.out.println("R) View Reports screen");
            System.out.println("H) Go back to home screen");

            Scanner ledgScanner = new Scanner(System.in);
            String ledgInput = ledgScanner.nextLine();

            //cases depending on what user inputs
            switch (ledgInput) {
                case "A":
                    viewLedgerMethods.displayAllEntries();
                    break;

                case "D":
                    System.out.println("Only deposits");
                    break;

                case "P":
                    System.out.println("Only negatives/payments");
                    break;

                case "R":
                    System.out.println("Reports");
                    break;

                case "H":
                    return;

                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}

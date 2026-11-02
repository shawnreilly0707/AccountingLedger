import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;

public class homeScreenMethods {
    //all below are methods for the homeScreen() method

    public static void addDeposit() {
        //method to initialize the add deposit option

        Scanner depScanner = new Scanner(System.in);

        System.out.println("Please input your deposit information in this format:");
        System.out.println("date|time|description|vendor|amount");
        String depInput = depScanner.nextLine();

        //reading the transactions.csv file and then adding the user's input to the file
        try {
            FileWriter writer = new FileWriter("transactions.csv", true);

            writer.write("\n" + depInput + " - Deposit Entry");
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
                    viewLedgerMethods.displayDeposits();
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

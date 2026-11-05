import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;

public class homeScreenMethods {
    //all below are methods for the homeScreen() method
    public static ArrayList<Entry> entries = new ArrayList<>(); //global array for entries that can be used anywhere

    public static void addDeposit() {
        //method to initialize the add deposit option

        Scanner depScanner = new Scanner(System.in); //main scanner that user will use to make inputs for adding deposits

        System.out.println("Please input your deposit information in this format: \n date|time|description|vendor|amount");
        System.out.println("Example: \n 2026-11-06|3:26AM|Paycheck|Sony Interactive|1000.00");

        //adding a deposit will iterate by each variable of an Entry
        System.out.println("Date:");
        String dateInput = depScanner.nextLine(); //the date of an Entry

        System.out.println("Time:");
        String timeInput = depScanner.nextLine(); //the time of an Entry

        System.out.println("Description:");
        String descInput = depScanner.nextLine(); //description of an Entry

        System.out.println("Vendor:");
        String venInput = depScanner.nextLine(); //vendor of an Entry

        System.out.println("Amount (without $):");
        float amntInput = depScanner.nextFloat(); //how much the deposit was

        Entry entry = new Entry(dateInput,
                timeInput,
                descInput,
                venInput,
                amntInput,
                true); //creating a new Entry object based on the user's input, true because it is a deposit

        homeScreenMethods.entries.add(entry); //adding that new Entry to the array of Entries

        try {
            FileWriter writer = new FileWriter("transactions.csv", true); //attempting to read the csv file

            writer.write("\n" + dateInput + "|" + timeInput + "|" +
                    descInput + "|" + venInput + "|" + amntInput); //adding the user's inputs to the csv file
            writer.close();

            System.out.println("Information added successfully"); //confirmation message

        }
        catch (IOException e) {
            System.out.println("ERROR could not obtain transactions.csv");
            e.printStackTrace(); //error message in case anything breaks
        }
    }

    public static void addPayment() {
        //method to initialize  the add payment option

        Scanner payScanner = new Scanner(System.in); //main scanner used for adding payments

        System.out.println("Please input your payment information in this format: \n date|time|description|vendor|amount");
        System.out.println("Example: \n 2026-11-02|1:18PM|Food and drink|Starbucks|-10.99");

        //adding a payment will iterate by an Entry's variables much like deposits
        System.out.println("Date:");
        String dateInput = payScanner.nextLine(); //date of an Entry

        System.out.println("Time:");
        String timeInput = payScanner.nextLine(); //time of an Entry

        System.out.println("Description:");
        String descInput = payScanner.nextLine(); //description of an Entry

        System.out.println("Vendor:");
        String venInput = payScanner.nextLine(); //vendor of Entry

        System.out.println("Amount (without $):");
        float amntInput = payScanner.nextFloat(); //how much the payment costs

        Entry entry = new Entry(dateInput,
                timeInput,
                descInput,
                venInput,
                amntInput,
                false); //creating a new Entry object based on user's inputs, false because it is not a deposit

        homeScreenMethods.entries.add(entry); //adding new Entry to array of Entries

        try {
            FileWriter writer = new FileWriter("transactions.csv", true); //attempting to read csv file
            writer.write("\n" + dateInput + "|" + timeInput + "|" +
                    descInput + "|" + venInput + "|" + "-" + amntInput); //adding new payment Entry to file

            writer.close();
        }
        catch (IOException e) {
            System.out.println("ERROR could not obtain transactions.csv");
            e.printStackTrace(); //error message in case anything breaks
        }
    }

    public static void viewLedger() {
        //method to initialize the ledger

        boolean active = true; //boolean to control while loop

        while (active) {
            System.out.println("Welcome to the Ledger page");
            System.out.println("Please select an option:");
            System.out.println("A) Display all entries");
            System.out.println("D) Display entries that are only deposits");
            System.out.println("P) Display only negative entries (or payments)");
            System.out.println("R) View Reports screen");
            System.out.println("H) Go back to home screen");

            Scanner ledgScanner = new Scanner(System.in); //main scanner used for inputs
            String ledgInput = ledgScanner.nextLine();

            //cases depending on what user inputs
            switch (ledgInput) {
                case "A": //displaying all entries
                    viewLedgerMethods.displayAllEntries();
                    break;

                case "D": //displaying only deposits
                    viewLedgerMethods.displayDeposits();
                    break;

                case "P": //displaying only payments
                    viewLedgerMethods.displayPayments();
                    break;

                case "R": //viewing reports page
                    viewLedgerMethods.viewReports();
                    break;

                case "H": //return to home page
                    return;

                default: //in case user inputs anything not listed as a case
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;

public class viewLedgerMethods {
    //all below are methods created for viewLedger() method

    public static void displayAllEntries() {
        //method to display all entries in csv file

        try {
            File writer = new File("transactions.csv"); //attempting to pull csv file
            Scanner fileScanner = new Scanner(writer); //scanner to index through file

            while (fileScanner.hasNextLine()) { //looking through the file to find printable text
                String line = fileScanner.nextLine(); //the text that will be printed
                System.out.println(line); //printing the text
            }

            fileScanner.close(); //closing because no longer needed
        }
        catch (IOException e) {
            System.out.println("ERROR could not print transactions.csv");
            e.printStackTrace(); //error message in case anything breaks
        }
    }

    public static void displayDeposits() {
        //method to display only deposits

        for (Entry entry : Entry.entries) { //iterating through array of Entries
            if (entry.isDepositEntry()) { //checking if an Entry has true or false boolean; in this case we want true
                Entry.printEntry(entry); //printing the Entry if found
            }
        }
    }

    public static void displayPayments() {
        //method to display only payments

        for (Entry entry : Entry.entries) { //iterating through array of Entries
            if (!entry.isDepositEntry()) { //checking if Entry has true or false boolean; in this case we want false
                Entry.printEntry(entry); //printing Entry if found
            }
        }
    }

    public static void viewReports() {
        //method to initialize reports screen

        boolean running = true; //boolean to control while loop

        Scanner repScanner = new Scanner(System.in); //main scanner used for user's inputs on reports

        while (running) {
            System.out.println("Welcome to the Reports screen");
            System.out.println("You may sort entries by however you like");
            System.out.println("Please choose an option:");
            System.out.println("1) Month to Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year to Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("0) Go back to Ledger page");

            int repInput = repScanner.nextInt(); //the input the user will put

            switch (repInput) {
                case 1: //month to date
                    viewReportsMethods.monthToDate();
                    break;

                case 2: //previous month
                    viewReportsMethods.prevMonth();
                    break;

                case 3: //year to date
                    viewReportsMethods.yearToDate();
                    break;

                case 4: //previous year
                    viewReportsMethods.prevYear();
                    break;

                case 5: //search by vendor
                    viewReportsMethods.searchByVendor();
                    break;

                case 0: //return to ledger page
                    return;

                default: //in case user puts something not listed in a case
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}

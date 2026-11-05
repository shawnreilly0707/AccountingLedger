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

        for (Entry entry : homeScreenMethods.entries) { //iterating through array of Entries
            if (entry.isDepositEntry()) { //checking if an Entry has true or false boolean; in this case we want true
                System.out.println(entry.getDate() + "|" +
                        entry.getTime() + "|" +
                        entry.getDescription() + "|" +
                        entry.getVendor() + "|" +
                        entry.getAmount()); //printing the Entry if found
            }
        }
    }

    public static void displayPayments() {
        //method to display only payments

        for (Entry entry : homeScreenMethods.entries) { //iterating through array of Entries
            if (!entry.isDepositEntry()) { //checking if Entry has true or false boolean; in this case we want false
                System.out.println(entry.getDate() + "|" +
                        entry.getTime() + "|" +
                        entry.getDescription() + "|" +
                        entry.getVendor() + "|" +
                        entry.getAmount()); //printing Entry if found
            }
        }
    }

    public static void viewReports() {
        //method to initialize reports screen

        boolean running = true;

        Scanner repScanner = new Scanner(System.in);

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

            int repInput = repScanner.nextInt();

            switch (repInput) {
                case 1:
                    viewReportsMethods.monthToDate();
                    break;

                case 2:
                    viewReportsMethods.prevMonth();
                    break;

                case 3:
                    viewReportsMethods.yearToDate();
                    break;

                case 4:
                    viewReportsMethods.prevYear();
                    break;

                case 5:
                    viewReportsMethods.searchByVendor();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}

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
        //method to intialize reports screen


    }
}

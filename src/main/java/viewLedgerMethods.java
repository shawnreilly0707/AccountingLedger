import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;

public class viewLedgerMethods {
    //all below are methods created for viewLedger() method

    public static void displayAllEntries() {
        try {
            File writer = new File("transactions.csv");
            Scanner fileScanner = new Scanner(writer);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }

            fileScanner.close();
        }
        catch (IOException e) {
            System.out.println("ERROR could not print transactions.csv");
            e.printStackTrace();
        }
    }

    public static void displayDeposits() {
        //method to display only deposits

        for (Entry entry : homeScreenMethods.entries) {
            if (entry.isDepositEntry()) {
                System.out.println(entry.getDate() + "|" +
                        entry.getTime() + "|" +
                        entry.getDescription() + "|" +
                        entry.getVendor() + "|" +
                        entry.getAmount());
            }
        }
    }

    public static void displayPayments() {
        //method to display only payments

        for (Entry entry : homeScreenMethods.entries) {
            if (!entry.isDepositEntry()) {
                System.out.println(entry.getDate() + "|" +
                        entry.getTime() + "|" +
                        entry.getDescription() + "|" +
                        entry.getVendor() + "|" +
                        entry.getAmount());
            }
        }
    }

    public static void viewReports() {

    }
}

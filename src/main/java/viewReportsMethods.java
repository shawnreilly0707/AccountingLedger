//class to initialize methods used for viewReports() method
import java.util.Scanner;

public class viewReportsMethods {
    public static void monthToDate() {

    }

    public static void prevMonth() {

    }

    public static void yearToDate() {

    }

    public static void prevYear() {

    }

    public static void searchByVendor() {
        //method to search through Entries by vendor

        System.out.println("Please enter the name of the vendor:");

        Scanner venScanner = new Scanner(System.in);
        String venInput = venScanner.nextLine();

        boolean found = false;

        for (Entry entry : Entry.entries) {
            if (entry.getVendor().equalsIgnoreCase(venInput)) {
                System.out.println(entry.getDate() + "|" +
                        entry.getTime() + "|" +
                        entry.getDescription() + "|" +
                        entry.getVendor() + "|" +
                        entry.getAmount());

                found = true;
            }
        }

        if (!found) {
            System.out.println("No entries found for vendor: " + venInput);

        }
    }
}

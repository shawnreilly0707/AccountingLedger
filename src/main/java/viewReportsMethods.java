//class to initialize methods used for viewReports() method
import java.util.Scanner;
import java.time.LocalDate;

public class viewReportsMethods {
    public static void monthToDate() {
        //method to sort Entries by date

        LocalDate today = LocalDate.now(); //today's date

        boolean mtdFound = false; //boolean to check if there is a valid Entry

        for (Entry entry : Entry.entries) { //iterating through array of Entries
            LocalDate entryDate = LocalDate.parse(entry.getDate()); //converting the Entry's date into a string

            if (entryDate.getMonth() == today.getMonth() &&
                    entryDate.getYear() == today.getYear()) { //checking if the Entry's month and year are equivalent to today's month and year
                Entry.printEntry(entry);

                mtdFound = true; //setting to true because a valid Entry was found
            }
        }

        if (!mtdFound) { //in case a valid Entry was not found
            System.out.println("No entries from this month");
        }
    }

    public static void prevMonth() {
        //method to sort by previous month

        LocalDate previousMonth = LocalDate.now().minusMonths(1);

        //variable for the previous month based on today's month

        boolean pmFound = false;

        for (Entry entry : Entry.entries) {
            LocalDate entryDate = LocalDate.parse(entry.getDate());

            if (entryDate.getMonth() == previousMonth.getMonth() &&
            entryDate.getYear() == previousMonth.getYear()) { //checking if the Entry's month and year are equivalent to the month before
                Entry.printEntry(entry);

                pmFound = true;
            }
        }

        if (!pmFound) {
            System.out.println("No entries from previous month");
        }
    }

    public static void yearToDate() {
        //method to sort by year

        int currentYear = LocalDate.now().getYear(); //integer that is today's year

        boolean ytdFound = false;

        for (Entry entry : Entry.entries) {
            LocalDate entryDate = LocalDate.parse(entry.getDate());

            if (entryDate.getYear() == currentYear) { //checking if the Entry's year is equal to today's year
                Entry.printEntry(entry);

                ytdFound = true;
            }
        }
        if (!ytdFound) {
            System.out.println("No entries from this year");
        }

    }

    public static void prevYear() {
        //method to search by previous year

        int previousYear = LocalDate.now().getYear() - 1; //integer that is the year minus one from today's year

        boolean pyFound = false;

        for (Entry entry : Entry.entries) {
            LocalDate entryDate = LocalDate.parse(entry.getDate());

            if (entryDate.getYear() == previousYear) { //checking if Entry's year is equal to previous year
                Entry.printEntry(entry);

                pyFound = true;
            }
        }

        if (!pyFound) {
            System.out.println("No entries from previous year");
        }
    }

    public static void searchByVendor() {
        //method to search through Entries by vendor

        System.out.println("Please enter the name of the vendor:");

        Scanner venScanner = new Scanner(System.in); //scanner used for this method
        String venInput = venScanner.nextLine(); //the user's input; should be the name of a vendor

        boolean sbvFound = false;

        for (Entry entry : Entry.entries) {
            if (entry.getVendor().equalsIgnoreCase(venInput)) { //checking if the inputted vendor is in the csv
                Entry.printEntry(entry);

                sbvFound = true;
            }
        }

        if (!sbvFound) {
            System.out.println("No entries found for vendor: " + venInput);

        }
    }
}

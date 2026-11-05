import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    static void main() {

        //setting up transactions.csv
        try {
            FileWriter writer = new FileWriter("transactions.csv"); //creating csv file

            writer.write("date|time|description|vendor|amount\n" +
                    "2023-04-15|10:13:25|ergonomic keyboard|Amazon|-89.50\n" +
                    "2023-04-15|11:15:00|Invoice 1001 paid|Joe|1500.00"); //writing to csv file

            Entry entry1 = new Entry("2023-04-15",
                    "10:13:25",
                    "ergonomic keyboard",
                    "Amazon",
                    89.50f,
                    true); //turning into manipulable objects

            Entry entry2 = new Entry("2023-04-15",
                    "11:15:00",
                    "Invoice 1001 paid",
                    "Joe",
                    1500.00f,
                    false); //turning into manipulable objects

            Entry.entries.add(entry1);
            Entry.entries.add(entry2); //^^ adding to array of entries

            writer.close(); //closing because it is no longer needed
        }
        catch (IOException e) {
            System.out.println("ERROR could not read/create transactions.csv");
            e.printStackTrace(); //error message in case it breaks
        }
        //end

        //running first-time home screen
        homeScreen();
    }

    public static void homeScreen() {
        //method to initialize the home screen

        boolean running = true; //boolean for the later while loop

        Scanner scanner = new Scanner(System.in);
        String input = ""; //the main scanner that will be used for the user's inputs on home screen

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
                case "D": //to make deposits
                    homeScreenMethods.addDeposit();
                    break;

                case "P": //to make payments
                    homeScreenMethods.addPayment();
                    break;

                case "L": //to view the ledger screen
                    homeScreenMethods.viewLedger();
                    break;

                case "X": //to exit program
                    System.out.println("Exiting\n Goodbye");
                    running = false;
                    break;

                default: //in case user makes any other input that is not listed as a case
                    System.out.println("Invalid option");
                    break;
            }

        }
    }


}

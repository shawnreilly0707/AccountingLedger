import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.File;

public class Main {
    static void main() {

        //the try catch will read through transactions.csv and add each entry to the public entries array
        //at each initialization of the program
        try {
            File file = new File("transactions.csv");

            Scanner fileScanner = new Scanner(file);

            fileScanner.nextLine(); //skipping first line

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                String[] parts = line.split("\\|"); //splits each entry by "|"

                float amount = Float.parseFloat(parts[4]);

                Entry entry = new Entry(
                        parts[0], //date
                        parts[1], //time
                        parts[2], //description
                        parts[3], //vendor
                        amount, //amount
                        amount > 0 //isDepositEntry or not
                );

                Entry.entries.add(entry);
            }
            fileScanner.close();
        }
        catch (IOException e) {
            System.out.println("ERROR could not obtain transactions.csv");
            e.printStackTrace();
        }

        //running first-time home screen
        homeScreen();
    }

    public static void homeScreen() {
        //method to initialize the home screen

        boolean running = true; //boolean for the later while loop

        Scanner scanner = new Scanner(System.in);
        String input = ""; //the main scanner that will be used for the user's inputs on home screen

        while (running) {
            System.out.println("===========================================");
            System.out.println("Welcome to the Accounting Ledger home screen");
            System.out.println("Please choose an option:");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.println("===========================================");

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

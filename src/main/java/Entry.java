//class to create Entry objects using OOP
import java.util.ArrayList;

public class Entry {
    public static ArrayList<Entry> entries = new ArrayList<>(); //global array for entries that can be used anywhere

    private String date;
    private String time;
    private String description;
    private String vendor;
    private float amount;
    private boolean depositEntry;

    public Entry(String date,
                 String time,
                 String description,
                 String vendor,
                 float amount,
                 boolean depositEntry) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
        this.depositEntry = depositEntry;
    }

    public String getDate() {
        return this.date;
    }

    public String getTime() {
        return this.time;
    }

    public String getDescription() {
        return this.description;
    }

    public String getVendor() {
        return this.vendor;
    }

    public float getAmount() {
        return this.amount;
    }

    public boolean isDepositEntry() {
        return this.depositEntry;
    }

    public static void printEntry(Entry entry) {
        if (entry.isDepositEntry()) {
            System.out.println(entry.getDate() + "|" +
                    entry.getTime() + "|" +
                    entry.getDescription() + "|" +
                    entry.getVendor() + "|" +
                    entry.getAmount());
        }
        if (!entry.isDepositEntry()) {
            System.out.println(entry.getDate() + "|" +
                    entry.getTime() + "|" +
                    entry.getDescription() + "|" +
                    entry.getVendor() + "|" + "-" +
                    entry.getAmount());
        }


    }
}

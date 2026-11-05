//class to create Entry objects using OOP

public class Entry {
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
}

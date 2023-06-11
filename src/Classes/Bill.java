package Classes;

public class Bill {

    static int counter=10001;
    String BillType;
    int amount;
    int billID;

    public Bill(String BillType, int amount) {
        this.BillType = BillType;
        this.amount = amount;
        this.billID = counter;
        counter++;
    }


    public String getBillType() {
        return BillType;
    }

    public int getAmount() {
        return amount;
    }

    public int getID() {
        return billID;
    }

    public void setBillType(String billType) {
        BillType = billType;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "ID=" + billID +
                ", amount=" + amount +
                ", Bill Type='" + BillType +
                '}';
    }
}

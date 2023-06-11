package Classes;

import java.util.Date;

public class Transaction {

    static int counter=978;

    int ID;
    double amount;
    Date date;
    String type;

    public Transaction(double amount, String type) {
        this.ID = counter;
        this.amount = amount;
        this.date = new Date(System.currentTimeMillis());
        this.type = type;
        counter++;
    }

    public void withDraw(Account acc){
        acc.setBalance(acc.getBalance() - amount);
    }
    public void deposit(Account acc){
        acc.setBalance(acc.getBalance() + amount);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void transferMoney(Account sender, Account receiver){
        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);
    }
    public void buyItem(Item item, Account acc){
        acc.setBalance(acc.getBalance() - item.getPrice());
    }
    public void payBill(Bill bill, Account acc){
        acc.setBalance(acc.getBalance() - bill.getAmount());
    }

}

package Classes;

import java.util.ArrayList;

public class Account {
    static int counter = 111;

    int ID;
    String Type;
    boolean hasUser;
    double Balance;



    ArrayList<Transaction> transactions = new ArrayList<>();

    public Account(String type, double balance) {
        this.ID = counter;
        Type = type;
        Balance = balance;
        hasUser = false;
        counter++;

    }


    public Boolean withDraw(double amount){
        if(hasUser) {

            if (this.getBalance() >= amount && amount>0) {
                Transaction t1 = new Transaction(amount, "WithDraw");
                t1.withDraw(this);
                transactions.add(t1);
                return true;
            } else
                return false;

        }
        System.out.println("Account has no user");
        return false;
    }

    public Boolean Deposit(double amount){
        if (hasUser && amount > 0){
            Transaction t1 = new Transaction(amount,"Deposit");
            t1.deposit(this);
            transactions.add(t1);
            return true;
        }

        System.out.println("Account has no user");
        return false;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public Boolean transferMoney(int receiverID, double amount){

        if(hasUser){


            if (receiverID != ID){


                Account receiver = DummyDB.getSingleAccount(receiverID);

                if(receiver == null){
                    System.out.println("account doesn't exist");
                    return false;
                }

                if (this.getBalance()>= amount && amount > 0) {
                    Transaction t1 = new Transaction(amount, "Transfer Money");
                    t1.transferMoney(this, receiver);
                    transactions.add(t1);
                    return true;
                }
                else
                    return false;



            }

            System.out.println("Cannot transfer money to the same account");
            return false;


        }

        System.out.println("Account has no user");
        return false;

    }

    public Boolean buyItem(int id){

        if (hasUser){
            Item item = DummyDB.getItem(id);

            if(item == null){
                System.out.println("item doesn't exist");
                return false;
            }
            if (this.getBalance()>= item.getPrice()){
                Transaction t1 = new Transaction(item.getPrice(), "Buy Item");
                t1.buyItem(item, this);
                transactions.add(t1);
                return true;
            }
            else
                return false;

        }

        System.out.println("Account has no user");
        return false;

    }

    public Boolean payBill(String type){

        if(hasUser){

            Bill bill = DummyDB.getBill(type);

            if(bill == null){
                System.out.println("bill doesn't exist");
                return false;
            }
            if (this.getBalance()>= bill.getAmount()){
                Transaction t1 = new Transaction(bill.getAmount(), type + " Bill");
                t1.payBill(bill,this);
                transactions.add(t1);
                return true;
            }
            else
                return false;

        }

        System.out.println("Account has no user");
        return false;

    }
    public int getID() {
        return ID;
    }

    public double getBalance() {
        return Balance;
    }
    public boolean isHasUser() {
        return hasUser;
    }

    public void setHasUser(boolean hasUser) {
        this.hasUser = hasUser;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public String getType() {
        return Type;
    }

    @Override
    public String toString() {
        return "Account{" +
                "ID=" + ID +
                ", Type='" + Type + '\'' +
                ", Balance=" + Balance +
                '}';
    }
}

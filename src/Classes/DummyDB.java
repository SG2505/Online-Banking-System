package Classes;

import java.util.ArrayList;

public class DummyDB {
    public static ArrayList<Item> ItemsDB = new ArrayList<>();
    public static ArrayList<Account> AccountsDB = new ArrayList<>();
    public static ArrayList<User> UsersDB = new ArrayList<>();
    public static ArrayList<Bill> BillsDB = new ArrayList<>();




    // fill dummy data
   //3ashan ncreate accounts mlhash user bs mogard 3ashan nst5dmha fel transfer

    public DummyDB() {
        //fillAccount();
        fillBill();
        fillItem();
    }

//    public void fillAccount(){
//       for (int i =0; i<10; i++){
//           if(i%2 == 0){
//               AccountsDB.add(new Account("Checking",i*200));
//           }
//           else {
//               AccountsDB.add(new Account("Savings", i*500));
//           }
//       }
//   }

   public static void fillBill(){

       BillsDB.add(new Bill("Internet",300));
       BillsDB.add(new Bill("Water",200));
       BillsDB.add(new Bill("Electricity",600));
       BillsDB.add(new Bill("Gas",80));
       BillsDB.add(new Bill("Phone",150));

   }

   public static void fillItem(){
       ItemsDB.add(new Item("T-shirt","AE",200));
       ItemsDB.add(new Item("Trousers","Hollister",600));
       ItemsDB.add(new Item("Certificate","CIB 20% interest rate",1000));
   }



    //searching algorithms
    public static Account getSingleAccount(int id){
        for(int i = 0; i< AccountsDB.size(); i++){
            if((AccountsDB.get(i).getID())== id) {
                return (AccountsDB.get(i));
            }

        }
        return null;
    }

    public static User getSingleUser(String EmailAddress){
        for(int i = 0; i< UsersDB.size(); i++){
            if((UsersDB.get(i).getEmailAddress()).equals(EmailAddress)) {
                return (UsersDB.get(i));
            }

        }
        return null;
    }
    public static Bill getBill(String type){

        for(int i = 0; i< BillsDB.size(); i++){
            if((BillsDB.get(i).getBillType()).equals(type)) {
                return (BillsDB.get(i));
            }

        }
        return null;
    }

    public static Item getItem(int id){

        for(int i = 0; i< ItemsDB.size(); i++){
            if((ItemsDB.get(i).getID())== id) {
                return (ItemsDB.get(i));
            }

        }
        return null;
    }

    //getters
    public static ArrayList<Item> getItemsDB() {
        return ItemsDB;
    }

    public static ArrayList<Account> getAccountsDB() {
        return AccountsDB;
    }

    public static ArrayList<User> getUsersDB() {
        return UsersDB;
    }

    public static ArrayList<Bill> getBillsDB() {
        return BillsDB;
    }

    public  void display(ArrayList list){
        for (int i=0; i< list.size();i++){
            System.out.println(list.get(i));
        }
    }
}

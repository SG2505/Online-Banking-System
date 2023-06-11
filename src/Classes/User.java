package Classes;

import java.util.ArrayList;

public class User {
    String Name;
    String Password;
    String PhoneNumber;
    String EmailAddress;
    int NationalID;


    ArrayList<Account> Accounts = new ArrayList<>();

    public User(String name, String password, String phoneNumber, String emailAddress, int nationalID) {
        Name = name;
        Password = password;
        PhoneNumber = phoneNumber;
        EmailAddress = emailAddress;
        NationalID = nationalID;
        DummyDB.UsersDB.add(this); //3ashan tadd el user ely btcaryto 3ady
    }

    public void addAccount(Account a1){
        a1.setHasUser(true);
        Accounts.add(a1);
        DummyDB.AccountsDB.add(a1);

    }

    public int[] getAccountsIDs() {
        if (!Accounts.isEmpty()){
            int Arr [] = new int [Accounts.size()];
            for (int i =0 ; i< Accounts.size();i++){
                Arr[i]= Accounts.get(i).ID;
            }
            return Arr;
        }
        return null;
    }

    public String getName() {
        return Name;

    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public Account getAccountindex (int index){
        if (Accounts.size()>0){
            return (Accounts.get(index));
        }
        return null;

    }

    public Account getAccount (int id){
        for(int i = 0; i< Accounts.size(); i++){
            if((Accounts.get(i).getID()) == id) {
                return (Accounts.get(i));
            }

        }
        return null;

    }

    public int getNationalID() {
        return NationalID;
    }

    public void setNationalID(int nationalID) {
        NationalID = nationalID;
    }
    //    public  Account getSingleAccount(int id){
//        for(int i=0; i<Accounts.size(); i++){
//            if((Accounts.get(i).getID())== id) {
//                return (Accounts.get(i));
//            }
//
//        }
//        return null;
//    }



    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", Password='" + Password + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", EmailAddress='" + EmailAddress + '\'' +
                ", acc=" + Accounts +

                '}';
    }
}
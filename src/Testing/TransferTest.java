package Testing;

import Classes.*;
import org.junit.*;

import static org.junit.Assert.*;

public class TransferTest {
    static User U1,U2;
    static Account Acc1,Acc2,Acc3;
    @BeforeClass
    public static void setUp() throws Exception {
        U1  = new User("Mohamed", "123", "01115003772", "ahmed@gmail.com",6454153);
        Acc1  = new Account("Checking", 134134);
        U1.addAccount(Acc1);
        Acc2 = new Account("Savings", 1000);
        U2 = new User("Mohamed", "123", "01115003772", "ahmed@gmail.com",465465);
        U2.addAccount(Acc2);
        Acc3 = new Account("Checking", 9999);
        U1.addAccount(Acc3);
    }


    @Test
    public void transferMoney() { // Transfer money between 2 different acoounts of the same user
        double amountToBeTransferred = 7750;
        boolean FunctionWorked;
        double Exp_Bal1= Acc1.getBalance()-amountToBeTransferred;
        double Exp_Bal2= Acc3.getBalance()+amountToBeTransferred;
        FunctionWorked = Acc1.transferMoney(Acc3.getID(),amountToBeTransferred);
        assertEquals("TestCase TransferMoney1 Failed: Normal Scenario.",Exp_Bal1,Acc1.getBalance(),0.5);
        assertEquals("TestCase TransferMoney1 Failed: Normal Scenario.",Exp_Bal2,Acc3.getBalance(),0.5);
    }


    @Test
    public void transferMoney1() {
        double amountToBeTransferred = 7750;
        boolean FunctionWorked;
        double Exp_Bal1= Acc1.getBalance()-amountToBeTransferred;
        double Exp_Bal2= Acc2.getBalance()+amountToBeTransferred;
        FunctionWorked = Acc1.transferMoney(Acc2.getID(),amountToBeTransferred);
        assertEquals("TestCase TransferMoney1 Failed: Normal Scenario.",Exp_Bal1,Acc1.getBalance(),0.5);
        assertEquals("TestCase TransferMoney1 Failed: Normal Scenario.",Exp_Bal2,Acc2.getBalance(),0.5);
    }

    @Test
    public void transferMoney2() {  // transfer all the balance from an account
        double amountToBeTransferred = Acc1.getBalance();
        boolean FunctionWorked;
        double Exp_Bal1= Acc1.getBalance()-amountToBeTransferred;
        double Exp_Bal2= Acc2.getBalance()+amountToBeTransferred;
        FunctionWorked = Acc1.transferMoney(Acc2.getID(),amountToBeTransferred);
        assertEquals("TestCase TransferMoney2 Failed: Balance should be transferred normally.",Exp_Bal1,Acc1.getBalance(),0.5);
        assertEquals("TestCase TransferMoney2 Failed: Balance should be transferred normally.",Exp_Bal2,Acc2.getBalance(),0.5);
    }

    @Test
    public void transferMoney3() {  // Try to transfer 0 amount from an account to another account
        double amountToBeTransferred = 0;
        boolean FunctionWorked;
        double Exp_Bal1= Acc1.getBalance()-amountToBeTransferred;
        double Exp_Bal2= Acc2.getBalance()+amountToBeTransferred;
        FunctionWorked = Acc1.transferMoney(Acc2.getID(),amountToBeTransferred);
        assertFalse("Test Case transferMoney3 Failed: Cannot transfer a zero.", FunctionWorked);
    }

    @Test
    public void transferMoney4() {  // Try to transfer amount to the same account number
        double amountToBeTransferred = 650;
        boolean FunctionWorked;
        double Exp_Bal1= Acc1.getBalance()-amountToBeTransferred;
        FunctionWorked = Acc1.transferMoney(Acc1.getID(),amountToBeTransferred);
        assertFalse("Test Case transferMoney4 Failed: Cannot transfer a to the same account number.", FunctionWorked);
    }

    @Test
    public void transferMoney5() {  // Try to transfer negative amount from an account to another account
        double amountToBeTransferred = -3000;
        boolean FunctionWorked;
        double Exp_Bal1= Acc1.getBalance()-amountToBeTransferred;
        double Exp_Bal2= Acc2.getBalance()+amountToBeTransferred;
        FunctionWorked = Acc1.transferMoney(Acc2.getID(),amountToBeTransferred);
        assertFalse("Test Case transferMoney5 Failed: Cannot transfer a negative amount.", FunctionWorked);
    }

    @Test
    public void transferMoney6() {  // Try to transfer more than the available balance
        double amountToBeTransferred = Acc1.getBalance() + 1;
        boolean FunctionWorked;
        double Exp_Bal1= Acc1.getBalance()-amountToBeTransferred;
        double Exp_Bal2= Acc2.getBalance()+amountToBeTransferred;
        FunctionWorked = Acc1.transferMoney(Acc2.getID(),amountToBeTransferred);
        assertFalse("Test Case transferMoney6 Failed: Cannot transfer more than the available balance.", FunctionWorked);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        U1= null;
        Acc1= null;
        Acc2= null;
        Acc3= null;
        U2=null;
        System.out.println("All Test Cases Finished");
    }
}
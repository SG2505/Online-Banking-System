package Testing;

import Classes.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class AccountTest {


    static User U1,U2;
    static Account Acc1,Acc2,Acc3;
    static DummyDB d1;


    @BeforeClass
    public static void setUp() throws Exception {
        U1  = new User("Mohamed", "123", "01115003772", "mohamed@gmail.com",89654);
        Acc1  = new Account("Checking", 134134);
        U1.addAccount(Acc1);
        Acc2 = new Account("Saving", 1000);
        U2 = new User("Mohamed", "123", "01115003772", "mohamed@gmail.com",98787);
        U2.addAccount(Acc2);
        Acc3 = new Account("Saving", 9999);
        U1.addAccount(Acc3);
        DummyDB.fillBill();
        DummyDB.fillItem();
    }

    @org.junit.Test
    public void NormalScenario1() {
        double Exp_Bal= Acc1.getBalance()-10100;
        Acc1.withDraw(3000);
        Acc1.buyItem(221);
        Acc1.Deposit(3000);
        Acc1.Deposit(1000);
        Acc1.payBill("Water");
        Acc1.payBill("Phone");
        double amountToBeTransferred = 7750;
        double Exp_Bal2= Acc2.getBalance()+amountToBeTransferred;
        Acc1.transferMoney(Acc2.getID(),amountToBeTransferred);
        Acc1.withDraw(2000);
        Acc1.withDraw(400);
        assertEquals("TestCase Normal Scenario Failed.",Exp_Bal,Acc1.getBalance(),0.5);
        assertEquals("TestCase Normal Scenario Failed: Normal Scenario.",Exp_Bal2,Acc2.getBalance(),0.5);
    }

    @org.junit.Test
    public void NormalScenario2() {
        double Exp_Bal= Acc1.getBalance()-10430;
        Acc1.Deposit(1000);
        Acc1.withDraw(3000);
        Acc1.buyItem(221);
        Acc1.payBill("Gas");
        double amountToBeTransferred = 7750;
        Acc1.withDraw(400);
        double Exp_Bal2= Acc3.getBalance()+amountToBeTransferred;
        Acc1.transferMoney(Acc3.getID(),amountToBeTransferred);
        Acc1.withDraw(2000);
        Acc1.Deposit(3000);
        Acc1.payBill("Electricity");
        assertEquals("TestCase Normal Scenario Failed.",Exp_Bal,Acc1.getBalance(),0.5);
        assertEquals("TestCase Normal Scenario Failed: Normal Scenario.",Exp_Bal2,Acc3.getBalance(),0.5);
    }


    @AfterClass
    public static void tearDown() {
        U1 = null;
        U2 = null;
        Acc1= null;
        Acc2= null;
        Acc3= null;
        System.out.println("All Test Cases Finished");
    }


}
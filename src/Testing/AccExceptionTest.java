package Testing;

import Classes.Account;
import Classes.DummyDB;
import Classes.User;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class AccExceptionTest {



    static User U1,U2;
    static Account Acc1,Acc2,Acc3,Acc4;
    static DummyDB d1;


    @BeforeClass
    public static void setUp() throws Exception {
        U1  = new User("Mohamed", "123", "01115003772", "mohamed@gmail.com",77);
        Acc1  = new Account("Checking", 134134);
        U1.addAccount(Acc1);
        Acc2 = new Account("Saving", 1000);
        U2 = new User("Mohamed", "123", "01115003772", "mohamed@gmail.com",77);
        U2.addAccount(Acc2);
        Acc3 = new Account("Checking", 9999);
        U1.addAccount(Acc3);
        Acc4 = new Account("Checking", 30000);
        DummyDB.fillBill();
        DummyDB.fillItem();
    }

    @org.junit.Test
    public void ExceptionScenario1() {
        Acc2.withDraw(900);
        boolean ItemFunc = Acc2.buyItem(3424);
        boolean DepFunc = Acc2.Deposit(-3000);
        boolean BillFunc = Acc2.payBill("Water");
        double withdrawAmount = -321;
        double amountToBeTransferred = 100;
        boolean TranFunc = Acc2.transferMoney(Acc4.getID(),amountToBeTransferred);
        boolean WithdrawFunc = Acc2.withDraw(withdrawAmount);
        assertFalse("Test Case ExceptionScenario1 Failed: Cannot buy non existing item.", ItemFunc);
        assertFalse("Test Case ExceptionScenario1 Failed: Cannot Deposit negative amount.", DepFunc);
        assertFalse("Test Case ExceptionScenario1 Failed: Cannot Transfer to an Account with no user.", TranFunc);
        assertFalse("Test Case ExceptionScenario1 Failed: Cannot pay bill (more than balance).", BillFunc);
        assertFalse("Test Case ExceptionScenario1 Failed: Cannot withdraw negative amount.", WithdrawFunc);
    }

    @org.junit.Test
    public void ExceptionScenario2() {
        Acc1.withDraw(3000);
        boolean ItemFunc = Acc1.buyItem(3424);
        boolean DepFunc = Acc1.Deposit(-3000);
        boolean DepFunc2 = Acc1.Deposit(0);
        boolean BillFunc = Acc1.payBill("bill");
        double withdrawAmount = Acc1.getBalance() + 3000;
        double amountToBeTransferred = 7750;
        boolean TranFunc = Acc1.transferMoney(Acc1.getID(),amountToBeTransferred);
        boolean WithdrawFunc = Acc1.withDraw(withdrawAmount);
        assertFalse("Test Case ExceptionScenario2 Failed: Cannot buy non existing item.", ItemFunc);
        assertFalse("Test Case ExceptionScenario2 Failed: Cannot Deposit negative amount.", DepFunc);
        assertFalse("Test Case ExceptionScenario2 Failed: Cannot Transfer to the same account.", TranFunc);
        assertFalse("Test Case ExceptionScenario2 Failed: Cannot pay bill that don't exist.", BillFunc);
        assertFalse("Test Case ExceptionScenario2 Failed: Cannot withdraw more than the balance.", WithdrawFunc);
        assertFalse("Test Case ExceptionScenario3 Failed: Cannot Deposit zero amount.", DepFunc2);
    }



    @AfterAll
    static void afterAll() {
        U1 = null;
        U2 = null;
        Acc1= null;
        Acc2= null;
        Acc3= null;
        System.out.println("All Test Cases Finished");
    }


}

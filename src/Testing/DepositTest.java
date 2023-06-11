package Testing;

import Classes.*;

import static org.junit.Assert.*;
import org.junit.*;

public class DepositTest {

    static User U1;
    static Account Acc1;

    static double cuurentBalance = 134134;

    @BeforeClass
    public static void setUp() throws Exception {

        U1  = new User("Mohamed", "123", "01115003772", "mohamed@gmail.com",545654);
        Acc1  = new Account("Checking", 134134);
        U1.addAccount(Acc1);
    }

    @Test
    public void deposit1() {
        double depositAmount = 3000;
        double Exp_Bal= Acc1.getBalance()+depositAmount;
        Acc1.Deposit(depositAmount);
        assertEquals("Test Case Deposit1 Failed: Normal scenario failed (3000).",Exp_Bal,Acc1.getBalance(),0.5);
    }

    @Test
    public void deposit2() {
        double depositAmount = -3000;
        boolean FunctionWorked;
        double Exp_Bal= Acc1.getBalance() + depositAmount;
        FunctionWorked = Acc1.Deposit(depositAmount);
        assertFalse("Test Case Deposit2 Failed: Cannot deposit a negative number.", FunctionWorked);
    }

    @Test
    public void deposit3() {
        double depositAmount = 0;
        boolean FunctionWorked;
        double Exp_Bal= Acc1.getBalance() + depositAmount;
        FunctionWorked = Acc1.Deposit(depositAmount);
        assertFalse("Test Case Deposit3 Failed: Cannot deposit a zero.", FunctionWorked);
    }

    @Test
    public void deposit4() {
        double depositAmount = 700000000;
        boolean FunctionWorked;
        double Exp_Bal= Acc1.getBalance()+depositAmount;
        FunctionWorked = Acc1.Deposit(depositAmount);
        assertEquals("Test Case Deposit4 Failed: Cannot handle a very large number.",Exp_Bal,Acc1.getBalance(),0.5);
    }

    @Test
    public void deposit5() {
        double depositAmount = 15000.7542;
        boolean FunctionWorked;
        double Exp_Bal= Acc1.getBalance()+depositAmount;
        FunctionWorked = Acc1.Deposit(depositAmount);
        assertEquals("Test Case Deposit5 Failed: Cannot handle a float number.",Exp_Bal,Acc1.getBalance(),0.5);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        U1= null;
        Acc1= null;
        System.out.println("All Test Cases Finished");
    }
}
package Testing;

import Classes.*;

import static org.junit.Assert.*;
import org.junit.*;

public class WithdrawTest {
    static User U1;
    static Account Acc1;

    static double cuurentBalance = 134134;

    @BeforeClass
    public static void setUp() throws Exception {

        U1  = new User("Mohamed", "123", "01115003772", "mohamed@gmail.com",987686);
        Acc1  = new Account("Checking", 134134);
        U1.addAccount(Acc1);
    }

    @Test
    public void withdraw1() {
        double withdrawAmount = 3000;
        boolean FunctionWorked;
        double Exp_Bal= Acc1.getBalance()-withdrawAmount;
        FunctionWorked = Acc1.withDraw(withdrawAmount);
        assertEquals("Test Case Withdraw1 Failed: Normal Scenario (3000).",Exp_Bal,Acc1.getBalance(),0.5);
        cuurentBalance -= withdrawAmount;       // Update the variable in the class to make it go along with the variable in the Account class
    }

    @Test
    public void withdraw2() {
        double withdrawAmount = -3000;
        boolean FunctionWorked;
        double Exp_Bal= Acc1.getBalance()-withdrawAmount;
        FunctionWorked = Acc1.withDraw(withdrawAmount);
        assertFalse("Test Case withdraw2 Failed: Cannot withdraw a negative number.", FunctionWorked);
    }

    @Test
    public void withdraw3() {
        double withdrawAmount = 0;
        boolean FunctionWorked;
        FunctionWorked = Acc1.withDraw(withdrawAmount);
        assertFalse("Test Case withdraw3 Failed: Cannot withdraw a zero.", FunctionWorked);
    }

    @Test
    public void withdraw4() {       // Try withdraw all the balance
        double withdrawAmount = cuurentBalance;
        boolean FunctionWorked;
        double Exp_Bal= Acc1.getBalance()-withdrawAmount;
        FunctionWorked = Acc1.withDraw(withdrawAmount);
        assertEquals("Test Case Withdraw4 Failed: Balance should be withdrawn normally.",Exp_Bal,Acc1.getBalance(),0.5);
        cuurentBalance -= withdrawAmount;
    }

    @Test
    public void withdraw5() {       // Try withdraw more than the balance
        double withdrawAmount = cuurentBalance + 1;
        boolean FunctionWorked;
        double Exp_Bal= Acc1.getBalance()-withdrawAmount;
        FunctionWorked = Acc1.withDraw(withdrawAmount);
        assertFalse("Test Case withdraw5 Failed: Cannot withdraw more than the balance.", FunctionWorked);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        U1= null;
        Acc1= null;
        System.out.println("All Test Cases Finished");
    }
}
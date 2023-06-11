package Testing;

import Classes.*;

import static org.junit.Assert.*;
import org.junit.*;

public class BillTest {
    static User U1;
    static Account Acc1;
    static DummyDB d1;


    @BeforeClass
    public static void setUp() throws Exception {
        U1  = new User("Mohamed", "123", "01115003772", "mohamed@gmail.com",4864534);
        Acc1  = new Account("Checking", 134134);
        U1.addAccount(Acc1);
        d1.fillBill();
    }


    @Test
    public void payBill() {
        double Exp_Bal= Acc1.getBalance()-600;
        Acc1.payBill("Electricity");
        assertEquals(Exp_Bal,Acc1.getBalance(),0.5);
    }

    @Test
    public void payBill2() {
        double Exp_Bal= Acc1.getBalance()-200;
        Acc1.payBill("Water");
        assertEquals(Exp_Bal,Acc1.getBalance(),0.5);
    }

    @Test
    public void payBill3() {
        double Exp_Bal= Acc1.getBalance()-300;
        Acc1.payBill("Internet");
        assertEquals(Exp_Bal,Acc1.getBalance(),0.5);
    }

    @Test
    public void payBill4() {
        double Exp_Bal= Acc1.getBalance()-80;
        Acc1.payBill("Gas");
        assertEquals(Exp_Bal,Acc1.getBalance(),0.5);
    }

    @Test
    public void payBill5() {
        double Exp_Bal= Acc1.getBalance()-150;
        Acc1.payBill("Phone");
        assertEquals(Exp_Bal,Acc1.getBalance(),0.5);
    }

    @Test
    public void payBill6() {
        boolean FunctionItem;
        FunctionItem = Acc1.payBill("Rent");
        assertFalse("Test Case buyItem4 Failed: Cannot Purchase unavailable.", FunctionItem);

    }

    @AfterClass
    public static void tearDown() throws Exception {
        U1= null;
        Acc1= null;
        System.out.println("All Test Cases Finished");

    }

}

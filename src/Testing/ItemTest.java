package Testing;

import Classes.*;

import static org.junit.Assert.*;
import org.junit.*;

public class ItemTest {
    static User U1;
    static Account Acc1;
    static DummyDB d1;


    @BeforeClass
    public static void setUp() throws Exception {
        U1  = new User("Mohamed", "123", "01115003772", "mohamed@gmail.com",98746546);
        Acc1  = new Account("Checking", 134134);
        U1.addAccount(Acc1);
        DummyDB.fillItem();
    }


    @Test
    public void buyItem() {
        double Exp_Bal= Acc1.getBalance()-600;
        Acc1.buyItem(221); // Trousers, price 600
        assertEquals(Exp_Bal,Acc1.getBalance(),0.5);
    }

    @Test
    public void buyItem2() {
        double Exp_Bal= Acc1.getBalance()-200;
        Acc1.buyItem(220); // T-shit, price 200
        assertEquals(Exp_Bal,Acc1.getBalance(),0.5);
    }

    @Test
    public void buyItem3() {
        double Exp_Bal= Acc1.getBalance()-1000;
        Acc1.buyItem(222); // certificate, price 1000
        assertEquals(Exp_Bal,Acc1.getBalance(),0.5);
    }

    @Test
    public void buyItem4() {
        boolean FunctionItem;
        FunctionItem = Acc1.buyItem(223);
        assertFalse("Test Case buyItem4 Failed: Cannot Purchase unavailable.", FunctionItem);

    }

    @AfterClass
    public static void tearDown() throws Exception {
        U1= null;
        Acc1= null;
        System.out.println("All Test Cases Finished");

    }

}

package Testing;

import Classes.*;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyDBTest {

    static User U1,U2;
    static Account Acc1,Acc2,Acc3;
    static DummyDB DB ;

    @BeforeClass
    public static void setUp() throws Exception {
        DB = new DummyDB();
        U1  = new User("Mohamed", "202020202", "01115003772", "mohamed@gmail.com",89);
        Acc1  = new Account("Checking", 134134);
        U1.addAccount(Acc1);
    }


    @Test
    public void getSingleAccount1() {
        int ID = Acc1.getID();
       Account acc =  DummyDB.getSingleAccount(ID);
       assertEquals("Test Case get single account 1 Failed: Normal scenario.",ID, acc.getID());

    }

    @Test
    public void getSingleAccount2() {
        Account acc =  DummyDB.getSingleAccount(12254558);
        assertNull("Test Case get single account 1 Failed: Account not found.",acc);

    }

    @Test
    public void getBill1() {
        Bill b1 = DummyDB.getBill("Internet");
        assertEquals("Test Case get Bill 1 Failed: Normal scenario.",300,b1.getAmount());
    }

    @Test
    public void getBill2() {
        Bill b1 = DummyDB.getBill("Rent");
        assertNull("Test Case get Bill 1 Failed: Bill not found.",b1);
    }

    @Test
    public void getItem1() {
        Item item = DummyDB.getItem(221);
        assertEquals("Test Case get Bill 1 Failed: Normal scenario.",600,item.getPrice());
    }

    @Test
    public void getItem2() {
        Item item = DummyDB.getItem(226);
        assertNull("Test Case get item 1 Failed: item not found.",item);
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
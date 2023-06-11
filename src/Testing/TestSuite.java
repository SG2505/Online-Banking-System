package Testing;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import static org.junit.Assert.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TransferTest.class,WithdrawTest.class,DepositTest.class
})



public class TestSuite {
}

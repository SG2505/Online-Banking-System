package Testing;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import static org.junit.Assert.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ItemTest.class,BillTest.class,DummyDBTest.class
})


public class TestSuite2 {
}

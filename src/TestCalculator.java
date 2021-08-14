
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class TestCalculator {
    Calculator ca = new Calculator();

    @Test
    public void emptyString()
    {
        assertEquals(ca.Add(""),0);
    }
}

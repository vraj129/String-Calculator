
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class TestCalculator {
    Calculator ca = new Calculator();

    @Test
    public void emptyString()
    {
        assertEquals(ca.Add(""),0);
    }
    @Test
    public void numberStringitself()
    {
        assertEquals(ca.Add("1"),1);
    }
    @Test
    public void stringwithcommas()
    {
        assertEquals(ca.Add("1,2"),3);
    }
    @Test
    public void stringwithnewlin()
    {
        assertEquals(ca.Add("1\n2"),3);
    }
    @Test
    public void stringwithcommasandnewline()
    {
        assertEquals(ca.Add("1,2\n3"),6);
    }
}

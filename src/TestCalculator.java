
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
    @Test
    public void specifieddelimiters()
    {
        assertEquals(ca.Add("//;\n1;2;3"),6);
        assertEquals(ca.Add("//.\n2.4"),6);
    }

    @Test
    public void throwsnegativenumbersmessage()
    {
        try
        {
            ca.Add("-1,-2,-3,4");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals(e.getMessage(),"Negative numbers : -1,-2,-3");
        }
    }
    @Test
    public void numberabove1000ignored()
    {
        assertEquals(ca.Add("2,2,1001"),4);
        assertEquals(ca.Add("1001,2"),2);
        assertEquals(ca.Add("4,2000"),4);
    }
    @Test
    public void anylenghtdelimiter()
    {
        assertEquals(ca.Add("//[***]\n1***2***3"),6);
    }
}

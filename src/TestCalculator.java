
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class TestCalculator {
    Calculator ca = new Calculator();
    
    

    @Test
    public void emptyString()  // test case for empty string
    {
        assertEquals(ca.Add(""),0);
    }
    @Test
    public void numberStringitself() // test case for returning the number itself
    {
        assertEquals(ca.Add("1"),1);
    }
    @Test
    public void stringwithcommas() // test case for commas as delimiter in string
    {
        assertEquals(ca.Add("1,2"),3);
        assertEquals(ca.Add("1,2,3"),6);
    }
    @Test
    public void stringwithnewlin() // test case for new line as delimiter
    {
        assertEquals(ca.Add("1\n2"),3);
    }
    @Test
    public void stringwithcommasandnewline() // test case for comma and new line as delimiter
    {
        assertEquals(ca.Add("1,2\n3"),6);
    }
    @Test
    public void specifieddelimiters() // test case for specific delimiter
    {
        assertEquals(ca.Add("//;\n1;2;3"),6);
        assertEquals(ca.Add("//.\n2.4"),6);
    }

    @Test
    public void throwsnegativenumbersmessage()  // test case for negative numbers
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
    public void numberabove1000ignored()  // test case for ignoring number above 1000
    {
        assertEquals(ca.Add("2,2,1001"),4);
        assertEquals(ca.Add("1001,2"),2);
        assertEquals(ca.Add("4,2000"),4);
    }
    @Test
    public void anylenghtdelimiter() // test case for any length specified delimiter
    {
        assertEquals(ca.Add("//[***]\n1***2***3"),6);
    }
    @Test
    public void multipledelimiters() // test case for multiple delimiter 
    {
        assertEquals(ca.Add("//[*][%]\n1*2%3"),6);
        assertEquals(ca.Add("//[--][...]\n1--2...3"),6);
    }
}

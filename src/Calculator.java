import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Calculator {
    public static void main(String[] args)
    {
    }
    public static int Add(String s)
    {
        if(s.isEmpty())  //if the string is empty
        {
            return 0;
        }
        String delimiter;
        if(s.startsWith("//"))  //if the string starts with '//'
        {
            String[] sub = s.split("\n",2);
            String temp = sub[0].substring(2);
            if(temp.startsWith("["))
            {
                temp = temp.substring(1,temp.length()-1);
            }
            temp = Stream.of(temp.split("]\\[")).map(Pattern::quote).collect(Collectors.joining("|"));
            delimiter = temp;
            s = sub[1];
        }
        else
        {
            delimiter = ",|\n";   // Default delimiter if none above condition is matched
        }
        return getSum(s,delimiter);
    }
    public static IntStream getNumber(String s,String delimiter)   // to get the number from the string
    {
        return Arrays.stream(s.split(delimiter)).mapToInt(Integer::parseInt).filter(n -> n<=1000);
    }
    public static int getSum(String s,String delimiter)   // it returns the sum 
    {
        String negativenumber = getNumber(s,delimiter)
                .filter(n -> n < 0)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(","));
        if(!negativenumber.isEmpty())
        {
            throw new IllegalArgumentException("Negative numbers : " + negativenumber);
        }
        return getNumber(s,delimiter).sum();
    }
}

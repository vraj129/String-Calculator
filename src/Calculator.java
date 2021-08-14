import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calculator {
    public static void main(String[] args)
    {

    }
    public static int Add(String s)
    {
        if(s.isEmpty())
        {
            return 0;
        }
        String delimiter;
        if(s.startsWith("//"))
        {
            String[] sub = s.split("\n",2);
            String temp = sub[0].substring(2);
            if(temp.startsWith("["))
            {
                temp = temp.substring(1,temp.length()-1);
            }
            delimiter = Pattern.quote(temp);
            s = sub[1];
        }
        else
        {
            delimiter = ",|\n";
        }
        return getSum(s,delimiter);
    }

    public static IntStream getNumber(String s,String delimiter)
    {
        return Arrays.stream(s.split(delimiter)).mapToInt(Integer::parseInt).filter(n -> n<=1000);
    }
    public static int getSum(String s,String delimiter)
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

import java.util.Arrays;
import java.util.regex.Pattern;
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
            delimiter = Pattern.quote(sub[0].substring(2));
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
        return Arrays.stream(s.split(delimiter)).mapToInt(Integer::parseInt);
    }
    public static int getSum(String s,String delimiter)
    {
        return getNumber(s,delimiter).sum();
    }


}

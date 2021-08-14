import java.util.Arrays;

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
        else if(s.length() == 1)
        {
            return Integer.parseInt(s);
        }
        else
        {
            String delimiter = ",|\n";

            int number = Arrays.stream(s.split(delimiter)).mapToInt(Integer::parseInt).sum();
            return number;
        }
    }


}

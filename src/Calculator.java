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
            String[] demo = s.split(",");
            return Integer.parseInt(demo[0]) + Integer.parseInt(demo[1]);
        }
    }
}

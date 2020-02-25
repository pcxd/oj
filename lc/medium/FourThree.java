package medium;

public class FourThree
{
    public static String multiply(String num1, String num2)
    {
        if(num1 == "0" || num2 == "0")
            return "0";

        char[] ret = new char[num1.length() + num2.length()];


        int start = 0;
        for(; start < ret.length; start++)
            if(ret[start] != '0')
                break;

        return String.copyValueOf(ret, start, ret.length - start);
    }

    public static void main(String[] args)
    {
        String num1 = "123";
        String num2 = "456";

        String ret = multiply(num1, num2);
        System.out.println(ret);
    }
}

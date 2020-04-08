package contest.One79;

import java.util.Arrays;


public class FiveThreeFiveTwo
{
    public static String generateTheString(int n)
    {
        if(n < 1)
            return "";

        char[] buff = new char[n];
        Arrays.fill(buff, 'a');
        if(n % 2 == 0)
            buff[0] = 'b';

        return new String(buff);
    }
}

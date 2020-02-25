package medium;

import java.util.HashSet;
import java.util.Set;


public class OneSixSix
{
    public static String fractionToDecimal(int numerator, int denominator)
    {
        if(denominator == 0)
            return "";
        if(numerator % denominator == 0)
            return Integer.toString(numerator / denominator);

        StringBuilder sb = new StringBuilder();
        Set<Integer> remains = new HashSet<>();

        int round = numerator / denominator;
        int rem = numerator % denominator;
        sb.append(round).append(".");
        while(rem != 0)
        {
            int cnt = 0;
            while(rem < denominator)
            {
                rem *= 10;
                cnt++;
            }

            round = rem / denominator;
            rem = rem % denominator;
            if(remains.contains(rem))
                break;

            sb.append(round);
            remains.add(rem);
        }

        if(rem != 0)
        {
            int start = sb.indexOf(Integer.toString(round));
            sb.insert(start, "(").append(")");
        }

        return sb.toString();
    }

    public static void main(String[] args)
    {
        int numerator = 2;
        int denominator = 33;
        String ret = fractionToDecimal(numerator, denominator);
        System.out.println(ret);
    }
}

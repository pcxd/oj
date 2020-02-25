package contest.One77;

import java.util.Arrays;


public class FiveOneSevenOne
{
    public static int[] closestDivisors(int num)
    {
        if(num < 1)
            return new int[0];

        int[] a = findDivisors(num + 1);
        int[] b = findDivisors(num + 2);
        int diffA = Math.abs(a[0] - a[1]);
        int diffB = Math.abs(b[0] - b[1]);
        if(diffA < diffB)
            return a;

        return b;
    }

    private static int[] findDivisors(int num)
    {
        int[] ret = new int[2];
        int sqrtVal = (int) Math.sqrt(num);

        for(int i = sqrtVal; i >= 1; i--)
        {
            if(num % i == 0)
            {
                ret[0] = i;
                ret[1] = num / i;
                break;
            }
        }

        return ret;
    }


    public static void main(String[] args)
    {
        int num = 999;
        int[] ret = closestDivisors(num);
        System.out.println(Arrays.toString(ret));
    }
}

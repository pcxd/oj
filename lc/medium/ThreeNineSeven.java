package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class ThreeNineSeven
{
    private static Map<Integer, Integer> buff;

    public static int integerReplacement(int n)
    {
        buff = new HashMap<>();
        buff.put(0, 1);
        buff.put(1, 0);
        buff.put(2, 1);
        buff.put(Integer.MAX_VALUE, 32);

        return getResult(n);
    }

    private static int getResult(int n)
    {
        if(buff.containsKey(n))
            return buff.get(n);

        if(n % 2 == 0)
        {
            int half = getResult(n / 2);
            buff.put(n / 2, half);
            return half + 1;

        }

        int up = getResult(n + 1);
        int down = getResult(n - 1);
        buff.put(n + 1, up);
        buff.put(n - 1, down);
        return Math.min(up, down) + 1;
    }

    public static void main(String[] args)
    {
        int n = 8;
        int ret = integerReplacement(n);
        System.out.println(ret);
    }
}

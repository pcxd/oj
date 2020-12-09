package lc.contest.Two18;

public class Three
{
    private final static int MOD = (int) Math.pow(10, 9) + 7;

    public static int concatenatedBinary(int n)
    {
        if(n <= 0)
            return 0;

        long ret = 0;

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++)
            sb.append(Integer.toBinaryString(i));

        for(int i = sb.length() - 1; i >= 0; i--)
            ret = (ret + ((sb.charAt(i) - '0') * getModVal(n - 1 - i))) % MOD;

        return (int) ret;
    }

    private static int getModVal(int n)
    {
        if(n < 32)
            return n;

        long ret = 1;
        while(n > 32)
        {
            ret = (ret * (long) Math.pow(2, 32) % MOD) % MOD;
            n -= 32;
        }

        return (int) ret;
    }

    private static int convert(int i)
    {
        if(i <= 0)
            return 0;

        int ret = 0;
        int base = 0;
        while(i > 0)
        {
            int last = i % 2;
            ret = (ret + (int) (last * Math.pow(10, base) % MOD)) % MOD;

            base++;
            i = i >> 1;
        }

        return ret;
    }


    public static void main(String[] args)
    {
        int n = 12;
        int ret = concatenatedBinary(n);
        System.out.println(ret);
    }
}

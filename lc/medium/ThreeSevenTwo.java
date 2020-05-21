package lc.medium;

public class ThreeSevenTwo
{
    final static int MOD = 1337;

    public static int superPow(int a, int[] b)
    {
        if(a == 0)
            return 0;
        if(b == null || b.length == 0)
            return 1;

        int ret = 1;
        int powBase = a;
        for(int i = b.length - 1; i >= 0; i--)
        {
            int itemVal = getPow(powBase, b[i]);
            ret = (ret * itemVal) % MOD;
            powBase = getPow(powBase, 10);
        }

        return ret % MOD;
    }

    private static int getPow(int base, int cnt)
    {
        int ret = 1;
        base %= MOD;
        for(int i = 0; i < cnt; i++)
            ret = (ret * base) % MOD;

        return ret;
    }


    public static void main(String[] args)
    {
        int a = 4;
        int[] b = {1, 0};
        int ret = superPow(a, b);
        System.out.println(ret);
    }
}

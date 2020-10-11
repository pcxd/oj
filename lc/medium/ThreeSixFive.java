package lc.medium;

public class ThreeSixFive
{
    private static int GCD(int a, int b)
    {
        while(b != 0)
        {
            int t = b;
            b = a % b;
            a = t;
        }

        return a;
    }

    public static boolean canMeasureWater(int x, int y, int z)
    {
        if(x + y < z)
            return false;

        int t = GCD(x, y);

        return z % t == 0;
    }
}

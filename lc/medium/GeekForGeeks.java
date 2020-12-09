package lc.medium;

import java.util.Arrays;


public class GeekForGeeks
{
    public static int countNonDecreasing(int n)
    {
        if(n < 0)
            return 0;

        int H = 10;
        int W = n + 1;
        int[][] dp = new int[H][W];
        for(int i = 0; i < H; i++)
            dp[i][1] = 1;

        for(int j = 2; j < W; j++)
        {
            for(int i = 0; i < H; i++)
            {
                dp[i][j] = 0;
                for(int digit = 0; digit <= i; digit++)
                    dp[i][j] += dp[digit][j - 1];
            }
        }

        int ret = 0;
        for(int i = 0; i < H; i++)
            ret += dp[i][n];

        return ret;
    }

    public static void main(String[] args)
    {
        int n = 3;
        int ret = countNonDecreasing(n);
        System.out.println(ret);
    }
}

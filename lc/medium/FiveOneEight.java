package medium;

import java.util.Arrays;


public class FiveOneEight
{
    public static int change(int amount, int[] coins)
    {
        int H = amount + 1;
        int W = coins.length + 1;
        int[][] dp = new int[H][W];
        Arrays.fill(dp[0], 1);
        for(int i = 1; i < H; i++)
            Arrays.fill(dp[i], 0);

        for(int j = 1; j < W; j++)
        {
            for(int i = 1; i < H; i++)
            {
                int cnt = amount / coins[j - 1];
                for(int k = 0; k <= cnt; k++)
                {
                    if(i - k * coins[j - 1] >= 0)
                        dp[i][j] += dp[i - coins[j - 1] * k][j - 1];
                }
            }
        }

        return dp[H - 1][W - 1];
    }

    public static int change2(int amount, int[] coins)
    {
        int H = coins.length + 1;
        int W = amount + 1;
        int[][] dp = new int[H][W];
        for(int[] dpi : dp)
            Arrays.fill(dpi, 0);
        for(int i = 0; i < H; i++)
            dp[i][0] = 1;

        for(int i = 1; i < H; i++)
        {
            for(int j = 1; j < W; j++)
            {
                dp[i][j] += dp[i - 1][j];
                if(j - coins[i - 1] >= 0)
                    dp[i][j] += dp[i][j - coins[i - 1]];
            }
        }

        return dp[H - 1][W - 1];
    }

    public static void main(String[] args)
    {
        int amount = 5;
        int[] coins = {1, 2, 5};

        int ret = change2(amount, coins);
        System.out.println(ret);
    }
}

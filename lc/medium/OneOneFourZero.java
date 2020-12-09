package lc.medium;

import java.util.Arrays;


public class OneOneFourZero
{
    static int[] sums;
    static int[][] dp;

    public static int stoneGameII(int[] piles)
    {
        if(piles == null || piles.length < 0)
            return 0;

        int H = piles.length;
        int W = piles.length;
        sums = new int[piles.length];
        dp = new int[H][W];
        for(int[] dpi : dp)
            Arrays.fill(dpi, 0);
        sums[piles.length - 1] = piles[piles.length - 1];
        for(int i = piles.length - 2; i >= 0; i--)
            sums[i] = sums[i + 1] + piles[i];

        return stoneHelper(piles, 0, 1);
    }

    private static int stoneHelper(int[] piles, int idx, int M)
    {
        if(idx == piles.length)
            return 0;
        if(dp[idx][M] != -1)
            return dp[idx][M];
        if(idx + 2 * M >= piles.length)
            return sums[idx];

        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= 2 * M; i++)
        {
            min = Math.min(min, stoneHelper(piles, idx + i, Math.max(M, i)));
        }

        dp[idx][M] = sums[idx] - min;

        return dp[idx][M];
    }
}

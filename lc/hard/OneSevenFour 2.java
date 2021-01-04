package hard;

import java.util.Arrays;


public class OneSevenFour
{
    public static int calculateMinimumHP(int[][] dungeon)
    {
        if(dungeon == null || dungeon[0].length == 0)
            return 0;

        int H = dungeon.length;
        int W = dungeon[0].length;
        int[][] dp = new int[H + 1][W + 1];
        for(int[] dpi : dp)
            Arrays.fill(dpi, Integer.MAX_VALUE);
        dp[H - 1][W] = 1;
        dp[H][W - 1] = 1;

        for(int i = H - 1; i >= 0; i--)
        {
            for(int j = W - 1; j >= 0; j--)
            {
                int need = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = need <= 0 ? 1 : need;
            }
        }

        return dp[0][0];
    }


    public static void main(String[] args)
    {
        int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        int ret = calculateMinimumHP(dungeon);
        System.out.println(ret);
    }
}

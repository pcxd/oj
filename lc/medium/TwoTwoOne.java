package medium;

import java.util.Arrays;


public class TwoTwoOne
{
    public static int maximalSquare(char[][] matrix)
    {
        if(matrix == null || matrix.length == 0)
            return 0;

        int H = matrix.length;
        int W = matrix[0].length;
        int[][] dp = new int[H][W];
        for(int[] dpi : dp)
            Arrays.fill(dpi, 0);

        for(int i = 0; i < H; i++)
            dp[i][0] = matrix[i][0] - '0';
        for(int j = 0; j < W; j++)
            dp[0][j] = matrix[0][j] - '0';

        for(int i = 1; i < H; i++)
        {
            for(int j = 1; j < W; j++)
            {
                if(matrix[i][j] == '1')
                {
                    if(dp[i][j - 1] == dp[j][i - 1])
                        dp[i][j] = Math.max(dp[i][j - 1], 1);
                    else
                        dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + 1;
                }

            }
        }

        return dp[H - 1][W - 1];
    }
}

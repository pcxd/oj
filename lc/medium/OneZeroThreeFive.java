package medium;

import java.util.Arrays;


public class OneZeroThreeFive
{
    public static int maxUncrossedLines(int[] A, int[] B)
    {
        if(A.length == 0 || B.length == 0)
            return 0;

        int H = A.length + 1;
        int W = B.length + 1;
        int[][] dp = new int[H][W];
        for(int[] dpi : dp)
            Arrays.fill(dpi, 0);

        for(int i = 1; i < H; i++)
        {
            for(int j = 1; j < W; j++)
            {
                if(A[i - 1] == B[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[H - 1][W - 1];
    }


    public static void main(String[] args)
    {
        int[] A = {1, 3, 7, 1, 7, 5};
        int[] B = {1, 9, 2, 5, 1};
        int ret = maxUncrossedLines(A, B);
        System.out.println(ret);
    }
}

package medium;

import java.util.Arrays;


public class SixTwo
{
    public static int uniquePaths(int m, int n)
    {
        int[][] cnt = new int[m][n];
        for(int y = 0; y < n; y++)
            cnt[0][y] = 1;
        for(int x = 0; x < m; x++)
            cnt[x][0] = 1;

        for(int x = 1; x < m; x++)
            for(int y = 1; y < n; y++)
                cnt[x][y] = cnt[x][y - 1] + cnt[x - 1][y];

        return cnt[m - 1][n - 1];
    }

    public static int uniquePaths2(int m, int n)
    {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                dp[j] = dp[j]+dp[j-1];

        return dp[n-1];
    }


    public static void main(String[] args)
    {
        int m = 7, n = 3;
        int ret = uniquePaths2(m, n);
        System.out.println(ret);
    }
}

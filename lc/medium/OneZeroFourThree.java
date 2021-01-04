package medium;

import java.util.Arrays;


public class OneZeroFourThree
{
    public static int maxSumAfterPartitioning(int[] arr, int k)
    {
        if(arr == null || arr.length == 0)
            return 0;

        int n = arr.length;
        int[][] memo = new int[n + 1][k + 1];
        int[] dp = new int[n + 1];
        dp[1] = arr[0];
        for(int[] memoi : memo)
            Arrays.fill(memoi, Integer.MIN_VALUE);
        memo[1][1] = arr[0];

        for(int i = 2; i <= n; i++)
        {
            int max = arr[i - 1];
            for(int j = 1; j <= k && i - j >= 0; j++)
            {
                max = Math.max(max, arr[i - j]);
                memo[i][j] = Math.max(memo[i][j], dp[i - j] + max * j);
                dp[i] = Math.max(dp[i], memo[i][j]);
            }
        }

        return dp[n];
    }


    public static void main(String[] args)
    {
        int[] arr = {1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3};
        int k = 4;
        int ret = maxSumAfterPartitioning(arr, k);
        System.out.println(ret);
    }
}

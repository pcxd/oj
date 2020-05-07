package lc.medium;

import java.util.Arrays;


public class FourNineFour
{
    public static int findTargetSumWays(int[] nums, int S)
    {
        if(nums == null || nums.length == 0)
            return 0;

        int BASE = 1000;
        int[][] dp = new int[nums.length][2 * BASE + 1];
        for(int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], 0);
        dp[0][BASE + nums[0]] = 1;
        dp[0][BASE - nums[0]] = 1;

        for(int i = 1; i < dp.length; i++)
        {
            for(int j = 0; j < dp[i].length; j++)
            {
                if(dp[i - 1][j] == 0)
                    continue;

                dp[i][j + nums[i]] += dp[i - 1][j];
                dp[i][j - nums[i]] += dp[i - 1][j];
            }
        }

        return dp[nums.length - 1][BASE + S];
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        int ret = findTargetSumWays(nums, S);
        System.out.println(ret);
    }
}

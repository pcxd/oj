package medium;

import java.util.Arrays;


public class OneSixNineSix
{
    public static int maxResult(int[] nums, int k)
    {
        if(nums == null || nums.length == 0 || k < 0)
            return 0;

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        for(int i = 1; i < n; i++)
        {
            for(int j = i - 1; 0 <= j && i - j <= k; j--)
            {
                dp[i] = Math.max(dp[i], nums[i] + dp[j]);
                if(nums[j] > 0)
                    break;
            }
        }

        return dp[n - 1];
    }


    public static void main(String[] args)
    {
        int[] nums = {1, -5, -20, 4, -1, 3, -6, -3};
        int k = 2;
        int ret = maxResult(nums, k);
        System.out.println(ret);
    }
}

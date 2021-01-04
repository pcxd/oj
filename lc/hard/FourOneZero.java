package hard;

public class FourOneZero
{
    public static int splitArray(int[] nums, int m)
    {
        if(nums == null || nums.length == 0)
            return 0;

        int n = nums.length;
        int[][] dp = new int[n][m + 1];
        dp[0][1] = nums[0];
        for(int i = 1; i < n; i++)
            dp[i][1] = dp[i - 1][1] + nums[i];

        for(int k = 2; k <= m; k++)
        {
            for(int i = k - 1; i < n; i++)
            {
                int cur = Integer.MAX_VALUE;
                for(int mid = k - 2; mid < i; mid++)
                    cur = Math.min(cur, Math.max(dp[mid][k - 1], dp[i][1] - dp[mid][1]));
                dp[i][k] = cur;
            }
        }

        return dp[n - 1][m];
    }


    public static void main(String[] args)
    {
        int[] nums = {1, 4, 4};  // 18
        int m = 3;
        int ret = splitArray(nums, m);
        System.out.println(ret);
    }
}

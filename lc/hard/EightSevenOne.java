package hard;

import java.util.Arrays;


public class EightSevenOne
{
    public static int minRefuelStops(int target, int startFuel, int[][] stations)
    {
        int[][] nums = new int[stations.length + 2][stations.length + 2];
        nums[0] = new int[]{0, startFuel};
        System.arraycopy(stations, 0, nums, 1, stations.length);
        nums[stations.length + 1] = new int[]{target, 0};

        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int[] dpi : dp)
            Arrays.fill(dpi, -1);

        dp[0][0] = startFuel;
        for(int j = 1; j < n; j++)
        {
            dp[0][j] = dp[0][j - 1] - (nums[j][0] - nums[j - 1][0]);
            if(dp[0][j] < 0)
                break;
        }
        if(dp[0][n - 1] >= 0)
            return 0;

        for(int j = 1; j < n; j++)
        {
            int cost = nums[j][0] - nums[j - 1][0];
            for(int i = 1; i < n; i++)
            {
                if(dp[i][j - 1] >= 0 && dp[i][j - 1] - cost >= 0)
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] - cost);
                if(dp[i - 1][j - 1] >= 0 && dp[i - 1][j - 1] - cost >= 0)
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] - cost + nums[j][1]);
            }
        }
        for(int i = 0; i < n; i++)
            if(dp[i][n - 1] >= 0)
                return i;

        return -1;
    }


    public static void main(String[] args)
    {
        int target = 100;
        int startFuel = 10;
        int[][] stations = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
        int ret = minRefuelStops(target, startFuel, stations);
        System.out.println(ret);
    }
}

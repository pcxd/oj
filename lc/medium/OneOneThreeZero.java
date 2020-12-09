package lc.medium;

public class OneOneThreeZero
{
    private static int[][] dp;
    private static int[][] max;

    public static int mctFromLeafValues(int[] arr)
    {
        if(arr == null || arr.length == 0)
            return 0;

        int n = arr.length;
        dp = new int[n][n];
        max = new int[n][n];

        for(int i = 0; i < n; i++)
        {
            int curMax = Integer.MIN_VALUE;
            for(int j = i; j < n; j++)
            {
                curMax = Math.max(curMax, arr[j]);
                max[i][j] = curMax;
            }
        }

        int ret = helper(arr, 0, n - 1);

        return ret;
    }

    private static int helper(int[] arr, int L, int R)
    {
        if(R - L < 1)
            return 0;
        if(R - L == 1)
            return arr[L] * arr[R];
        if(dp[L][R] != 0)
            return dp[L][R];

        int ret = Integer.MAX_VALUE;
        for(int M = L; M < R; M++)
        {
            int left = helper(arr, L, M);
            int right = helper(arr, M + 1, R);
            int val = left + right + max[L][M] * max[M + 1][R];
            ret = Math.min(ret, val);
        }
        dp[L][R] = ret;

        return ret;
    }


    public static void main(String[] args)
    {
        int[] arr = new int[]{6, 2, 4};
        int ret = mctFromLeafValues(arr);
        System.out.println(ret);
    }
}

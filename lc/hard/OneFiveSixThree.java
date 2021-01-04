package hard;

import java.util.Arrays;


public class OneFiveSixThree
{
    static int[][] memo;
    static int[] sum;

    public static int stoneGameV(int[] stoneValue)
    {
        if(stoneValue == null || stoneValue.length <= 1)
            return 0;

        int N = stoneValue.length;
        memo = new int[N][N];
        sum = new int[N];
        sum[0] = stoneValue[0];
        for(int i = 1; i < N; i++)
            sum[i] = sum[i - 1] + stoneValue[i];

        for(int[] memoi : memo)
            Arrays.fill(memoi, -1);
        for(int i = 0; i < N; i++)
            memo[i][i] = 0;

        return helper(stoneValue, 0, N - 1);
    }

    private static int helper(int[] stoneValue, int L, int R)
    {
        if(L > R)
            return 0;
        if(memo[L][R] != -1)
            return memo[L][R];

        int max = Integer.MIN_VALUE;
        for(int m = L; m < R; m++)
        {
            int sumLeft = sum[m] - sum[L] + stoneValue[L];
            int sumRight = sum[R] - sum[m];

            int curMax = 0;
            int maxR = helper(stoneValue, m + 1, R) + sumRight;
            int maxL = helper(stoneValue, L, m) + sumLeft;
            if(sumLeft > sumRight)
                curMax = maxR;
            else if(sumLeft < sumRight)
                curMax = maxL;
            else
                curMax = Math.max(maxL, maxR);

            max = Math.max(max, curMax);
        }

        memo[L][R] = max;
        return max;
    }

    public static void main(String[] args)
    {
        int[] stoneValue = {7, 7, 7, 7, 7, 7, 7};
        int ret = stoneGameV(stoneValue);
        System.out.println(ret);
    }
}

package hard;

import java.util.Arrays;


public class OneZeroZeroZero
{
    static final int INITVAL = -1;
    static int[][] memo;
    static int[] sum;

    public static int mergeStones(int[] stones, int K)
    {
        if(stones == null || (stones.length - 1) % (K - 1) != 0)
            return -1;

        int n = stones.length;
        sum = new int[n];
        memo = new int[n][n];
        sum[0] = stones[0];
        for(int i = 1; i < n; i++)
            sum[i] = sum[i - 1] + stones[i];
        for(int[] memoi : memo)
            Arrays.fill(memoi, INITVAL);

        int ret = helper(stones, 0, n - 1, K);
        return ret;
    }

    private static int helper(int[] stones, int L, int R, int K)
    {
        if(L > R)
            return 0;
        if(R - L + 1 < K)
            return 0;
        if(R - L + 1 == K)
            memo[L][R] = sum[R] - sum[L] + stones[L];
        if(memo[L][R] != INITVAL)
            return memo[L][R];

        if(L == 0 && R == 5)
            System.out.println(L);
        int min = Integer.MAX_VALUE;
        for(int M = L; M < R; M += K - 1)
        {
            int left = helper(stones, L, M, K);
            int right = helper(stones, M + 1, R, K);
            if(left + right > 0)
                min = Math.min(min, left + right);
        }
        memo[L][R] = min;
        if((R - L) % (K - 1) == 0)
            memo[L][R] = memo[L][R] + sum[R] - sum[L] + stones[L];


        return memo[L][R];
    }


    public static void main(String[] args)
    {
        /*
        We start with [3, 5, 1, 2, 6].
        We merge [5, 1, 2] for a cost of 8, and we are left with [3, 8, 6].
        We merge [3, 8, 6] for a cost of 17, and we are left with [17].
        The total cost was 25, and this is the minimum possible.
         */
        int[] stones = {7, 7, 8, 6, 5, 6, 6};
        int K = 3;
        int ret = mergeStones(stones, K);
        System.out.println(ret);
    }
}

package lc.hard;

import java.util.Arrays;


public class OneFiveOneZero
{
    static int[] memo;

    public static boolean winnerSquareGame(int n)
    {
        if(n <= 0 || n % Math.sqrt(n) == 0)
            return true;

        int[] stones = new int[n];
        memo = new int[n];
        Arrays.fill(stones, 1);
        Arrays.fill(memo, 0);

        int aliceVal = helper(stones, 0);

        return aliceVal == 1;
    }

    private static int helper(int[] stones, int idx)
    {
        if(idx == stones.length)
            return -1;
        if(memo[idx] != 0)
            return memo[idx];

        int nextMin = Integer.MAX_VALUE;
        for(int i = 1; idx + i * i <= stones.length; i++)
        {
            nextMin = Math.min(nextMin, helper(stones, idx + i * i));
        }
        memo[idx] = nextMin == -1 ? 1 : -1;

        return memo[idx];
    }

    public static void main(String[] args)
    {
        int n = 5;
        boolean ret = winnerSquareGame(n);
        System.out.println(ret);
    }
}

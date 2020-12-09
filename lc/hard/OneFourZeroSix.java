package lc.hard;

import java.util.Arrays;


public class OneFourZeroSix
{
    final static int STEP = 3;
    static int[] sums;
    static int[] memo;

    public static String stoneGameIII(int[] stoneValue)
    {
        if(stoneValue == null || stoneValue.length == 0)
            return "Tie";

        sums = new int[stoneValue.length];
        sums[stoneValue.length - 1] = stoneValue[stoneValue.length - 1];
        for(int i = stoneValue.length - 2; i >= 0; i--)
            sums[i] = sums[i + 1] + stoneValue[i];
        memo = new int[stoneValue.length];
        Arrays.fill(memo, Integer.MIN_VALUE);

        int aliceVal = stoneHelper(stoneValue, 0);
        int bobVal = sums[0] - aliceVal;

        if(aliceVal == bobVal)
            return "Tie";

        return aliceVal > bobVal ? "Alice" : "Bob";
    }

    private static int stoneHelper(int[] sv, int idx)
    {
        if(idx == sv.length)
            return 0;
        if(memo[idx] != Integer.MIN_VALUE)
            return memo[idx];
        if(idx + STEP >= sv.length)
            return sums[idx];

        int next = Integer.MAX_VALUE;
        for(int i = 1; i <= STEP; i++)
        {
            next = Math.min(next, stoneHelper(sv, idx + i));
        }

        memo[idx] = sums[idx] - next;

        return memo[idx];
    }


    public static void main(String[] args)
    {
        int[] stoneValues = {-1, -2, -3};
        String ret = stoneGameIII(stoneValues);
        System.out.println(ret);
    }
}

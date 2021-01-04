package hard;

import java.util.Arrays;


public class OneSixFourNine
{
    private static final int MOD = (int) Math.pow(10, 9) + 7;
    private static final int MAXN = (int) Math.pow(10, 5) + 1;
    private static int[] BIT = new int[MAXN];

    public static int createSortedArray(int[] instructions)
    {
        if(instructions == null || instructions.length <= 1)
            return 0;

        Arrays.fill(BIT, 0);

        int ret = 0;
        for(int i = 0; i < instructions.length; i++)
        {
            int prev = sum(instructions[i] - 1);
            int post = i - sum(instructions[i]);

            ret += Math.min(prev, post);
            ret = ret % MOD;
            update(instructions[i], 1);
        }

        return ret;
    }

    private static void update(int idx, int val)
    {
        while(idx < BIT.length)
        {
            BIT[idx] += val;
            idx += idx & -idx;
        }
    }

    private static int sum(int idx)
    {
        int ret = 0;
        while(idx > 0)
        {
            ret += BIT[idx];
            idx -= idx & -idx;
        }

        return ret % MOD;
    }


    public static void main(String[] args)
    {
        //        int[] instructions = {1, 3, 3, 3, 2, 4, 2, 1, 2};
        int[] instructions = {4, 14, 10, 2, 5, 3, 8, 19, 7, 20, 12, 1, 9, 15, 13, 11, 18, 6, 16, 17};
        int ret = createSortedArray(instructions);
        System.out.println(ret);
    }
}

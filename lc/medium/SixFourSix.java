package medium;

import java.util.Arrays;
import java.util.Comparator;


public class SixFourSix
{
    public static int findLongestChain(int[][] pairs)
    {
        if(pairs == null || pairs.length == 0)
            return 0;

        Arrays.sort(pairs, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] a, int[] b)
            {
                if(a[0] == b[0])
                    return a[1] - b[1];
                return a[0] - b[0];
            }
        });

        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        for(int i = 1; i < dp.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(pairs[i][0] > pairs[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        return dp[pairs.length - 1];
    }


    public static void main(String[] args)
    {
        int[][] pairs = {{1, 2}, {2, 3}, {3, 4}};
        int ret = findLongestChain(pairs);
        System.out.println(ret);
    }
}

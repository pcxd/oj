package hard;

import java.util.Arrays;


public class ThreeFiveFour
{
    public static int maxEnvelopes(int[][] envelopes)
    {
        if(envelopes == null || envelopes.length == 0)
            return 0;

        Arrays.sort(envelopes, (a, b)->
        {
            if(a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });

        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);

        for(int i = 1; i < dp.length; i++)
            for(int j = 0; j < i; j++)
            {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1] && dp[j] + 1 > dp[i])
                {
                    dp[i] = dp[j] + 1;
                }
            }

        int ret = 0;
        for(int i = 0; i < dp.length; i++)
            ret = Math.max(ret, dp[i]);

        return ret;
    }


    public static void main(String[] args)
    {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int ret = maxEnvelopes(envelopes);
        System.out.println(ret);
    }

}

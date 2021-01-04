package hard;

import java.util.Arrays;


public class FourFour
{
    public static boolean isMatch(String s, String p)
    {
        if(p == null || s == null)
            return false;

        int H = p.length() + 1;
        int W = s.length() + 1;
        boolean[][] dp = new boolean[H][W];
        for(boolean[] dpi : dp)
            Arrays.fill(dpi, false);
        dp[0][0] = true;
        for(int i = 1; i < H; i++)
            if(p.charAt(i - 1) == '*')
                dp[i][0] = true;
            else
                break;


        for(int i = 1; i < H; i++)
        {
            for(int j = 1; j < W; j++)
            {
                if(p.charAt(i - 1) == '*')
                    dp[i][j] = dp[i - 1][j - 1] || dp[i - 1][j] || dp[i][j - 1];
                else if(p.charAt(i - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = dp[i - 1][j - 1] && p.charAt(i - 1) == s.charAt(j - 1);
            }
        }

        return dp[H - 1][W - 1];
    }


    public static void main(String[] args)
    {
        String s = "aa";
        String p = "*";
        boolean ret = isMatch(s, p);
        System.out.println(ret);
    }
}

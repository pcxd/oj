package hard;

import java.util.Arrays;


public class SevenTwo
{
    public static int minDistance(String word1, String word2)
    {
        if(word1.isEmpty() || word2.isEmpty())
            return word1.length() + word2.length();

        int H = word1.length() + 1;
        int W = word2.length() + 1;
        int[][] dp = new int[H][W];
        for(int[] dpi : dp)
            Arrays.fill(dpi, 0);
        for(int j = 0; j < W; j++)
            dp[0][j] = j;
        for(int i = 0; i < H; i++)
            dp[i][0] = i;

        for(int i = 1; i < H; i++)
        {
            for(int j = 1; j < W; j++)
            {
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
            }
        }

        return dp[H - 1][W - 1];
    }


    public static void main(String[] args)
    {
        String word1 = "intention";
        String word2 = "execution";
        int ret = minDistance(word1, word2);
        System.out.println(ret);
    }
}

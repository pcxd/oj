package medium;

public class OneOneFourThree
{
    public static int longestCommonSubsequence(String text1, String text2)
    {
        if(text1.isEmpty() || text2.isEmpty())
            return 0;

        int H = text1.length() + 1;
        int W = text2.length() + 1;
        int[][] dp = new int[H][W];
        for(int i = 0; i < H; i++)
            dp[i][0] = 0;
        for(int j = 0; j < W; j++)
            dp[0][j] = 0;

        for(int i = 1; i < dp.length; i++)
        {
            for(int j = 1; j < W; j++)
            {
                if(text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[H - 1][W - 1];
    }

    public static void main(String[] args)
    {
        String text1 = "abc";
        String text2 = "def";
        int ret = longestCommonSubsequence(text1, text2);
        System.out.println(ret);
    }
}

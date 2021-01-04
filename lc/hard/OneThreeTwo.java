package hard;

import java.util.Arrays;


public class OneThreeTwo
{
    static int[][] memo;
    static boolean[][] needCut;

    public static int minCut(String s)
    {
        if(s == null || s.length() < 2)
            return 0;

        memo = new int[s.length()][s.length()];
        for(int[] memoi : memo)
            Arrays.fill(memoi, -1);

        initNeedCut(s);

        char[] arr = s.toCharArray();

        return helper(arr, 0, s.length() - 1);
    }

    private static void initNeedCut(String s)
    {
        needCut = new boolean[s.length()][s.length()];
        for(boolean[] needCuti : needCut)
            Arrays.fill(needCuti, true);

        for(int i = 0; i < s.length(); i++)
        {
            // odd
            needCut[i][i] = false;
            for(int j = 1; j < s.length(); j++)
            {
                if(i - j < 0 || i + j >= s.length())
                    break;
                if(s.charAt(i - j) == s.charAt(i + j))
                    needCut[i - j][i + j] = false;
                else
                    break;
            }

            // even
            int l = i;
            int r = i + 1;
            while(l >= 0 && r < s.length())
            {
                if(s.charAt(l) != s.charAt(r))
                    break;

                needCut[l][r] = false;
                l--;
                r++;
            }
        }
    }

    private static int helper(char[] arr, int L, int R)
    {
        if(!needCut[L][R])
            memo[L][R] = 0;
        if(memo[L][R] != -1)
            return memo[L][R];

        int curCut = Integer.MAX_VALUE;
        for(int M = L; M < R; M++)
        {
            int minCutL = helper(arr, L, M);
            int minCutR = helper(arr, M + 1, R);

            curCut = Math.min(curCut, minCutL + minCutR + 1);
        }
        memo[L][R] = curCut;

        return curCut;
    }

    public static int minCut2(String s)
    {
        if(s == null || s.isEmpty())
            return 0;

        int n = s.length();
        int[] dp = new int[n];
        boolean[][] isPal = new boolean[n][n];
        for(int i = 0; i < n; i++)
        {
            int min = i;
            for(int j = 0; j <= i; j++)
            {
                if(s.charAt(i) == s.charAt(j) && (j + 1 > i - 1 || isPal[j + 1][i - 1]))
                {
                    isPal[j][i] = true;
                    int cur = j == 0 ? 0 : dp[j - 1] + 1;
                    min = Math.min(min, cur);
                }
            }
            dp[i] = min;
        }

        return dp[n - 1];
    }


    public static void main(String[] args)
    {
        String s = "abbab";
        int ret = minCut2(s);
        System.out.println(ret);
    }
}

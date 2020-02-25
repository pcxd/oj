package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class OneThreeNine
{
    public static boolean wordBreak(String s, List<String> wordDict)
    {
        if(s.isEmpty() || wordDict.isEmpty())
            return false;

        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;

        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        Set<String> words = new HashSet<>();

        for(String word : wordDict)
        {
            words.add(word);
            minLen = Math.min(word.length(), minLen);
            maxLen = Math.max(word.length(), maxLen);
            if(s.indexOf(word) == 0)
                dp[word.length()] = true;
        }

        for(int i = 1; i < dp.length; i++)
            if(dp[i])
            {
                for(int j = minLen; j <= maxLen && i + j <= s.length(); j++)
                {
                    String nextWord = s.substring(i, i + j);
                    if(!dp[i + j] && words.contains(nextWord))
                        dp[i + j] = true;
                }
            }

        return dp[s.length()];
    }


    public static void main(String[] args)
    {
        String s = "catsandog";
        String[] wordArr = {"cats", "dog", "sand", "and", "cat"};
        List<String> wordDict = new ArrayList<>(wordArr.length);
        for(String word : wordArr)
            wordDict.add(word);

        boolean ret = wordBreak(s, wordDict);
        System.out.println(ret);
    }
}

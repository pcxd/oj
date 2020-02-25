package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class OneFourZero
{
    public static List<String> wordBreak(String s, List<String> wordDict)
    {
        if(s.isEmpty() || wordDict.isEmpty())
            return Collections.emptyList();

        List<List<String>> dp = new ArrayList<>();
        for(int i = 0; i < s.length()+1; i++)
            dp.add(new ArrayList<>());

        int minLen = Integer.MAX_VALUE, maxLen = Integer.MIN_VALUE;
        Set<String> words = new HashSet<>();
        for(String word : wordDict)
        {
            words.add(word);
            minLen = Math.min(minLen, word.length());
            maxLen = Math.max(maxLen, word.length());
            if(s.indexOf(word) == 0)
                dp.get(word.length()).add(word);
        }

        for(int i = 1; i < dp.size(); i++)
        {
            if(dp.get(i).isEmpty())
                continue;

            for(int len = minLen; len <= maxLen && i + len <= s.length(); len++)
            {
                String str = s.substring(i, i + len);
                if(words.contains(str))
                    dp.get(i+len).add(str);
            }
        }

        if(dp.get(s.length()).isEmpty())
            return Collections.emptyList();

        List<String> ret = new ArrayList<>();
        dfs(dp, s.length(), new ArrayList<>(), ret);

        return ret;
    }

    private static void dfs(List<List<String>> dp, int pos, List<String> path, List<String> ret)
    {
        if(pos == 0)
        {
            ret.add(String.join(" ", path));
            return;
        }

        for(String word : dp.get(pos))
        {
            path.add(0, word);
            dfs(dp, pos - word.length(), path, ret);
            path.remove(0);
        }
    }


    public static void main(String[] args)
    {
        String s = "catsanddog";
        String[] wordArr = {"cat", "cats", "and", "sand", "dog"};
        List<String> wordDict = new ArrayList<>(wordArr.length);
        for(String word : wordArr)
            wordDict.add(word);

        List<String> ret = wordBreak(s, wordDict);
        System.out.println(ret.toString());
    }
}

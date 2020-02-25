package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ThreeZero
{
    public static List<Integer> findSubstring(String s, String[] words)
    {
        List<Integer> ret = new ArrayList<Integer>();
        if(s.isEmpty() || words.length == 0)
            return ret;

        int wordLen = words[0].length();
        Map<String, Integer> buff = new HashMap<>();
        for(String word : words)
            buff.put(word, buff.getOrDefault(word, 0) + 1);

        for(int i = 0; i < wordLen && i <= s.length() - wordLen * words.length; i++)
        {
            List<String> subWords = new ArrayList<String>();
            int l = i;
            while(l <= s.length() - wordLen)
            {
                subWords.add(s.substring(l, l + wordLen));
                l += wordLen;
            }

            List<Integer> validIdx = findValidStart(buff, words.length, subWords);
            for(Integer idx : validIdx)
                ret.add(i + idx * wordLen);
        }

        return ret;
    }


    private static List<Integer> findValidStart(Map<String, Integer> wordCount, int targetLen,
            List<String> items)
    {
        List<Integer> ret = new ArrayList<>();

        int left = 0, right = 0, cur = 0;
        Map<String, Integer> curStatus = new HashMap<>(wordCount);
        while(cur < items.size() && left <= items.size() - targetLen)
        {
            String curWord = items.get(cur);
            if(!curStatus.containsKey(curWord))
            {
                curStatus = new HashMap<>(wordCount);
                left = cur + 1;
                right = cur + 1;
            }
            else if(curStatus.get(curWord) == 0)
            {
                for(int i = left; i <= right; i++)
                {
                    if(items.get(i).equals(curWord))
                    {
                        left = i + 1;
                        right = cur;
                        break;
                    }
                    curStatus.put(items.get(i), curStatus.get(items.get(i)) + 1);
                }
            }
            else
            {
                curStatus.put(curWord, curStatus.get(curWord) - 1);
                right = cur;

                if(right - left + 1 == targetLen)
                {
                    ret.add(left);
                    curStatus.put(items.get(left), curStatus.get(items.get(left)) + 1);
                    left++;
                }
            }

            cur++;
        }

        return ret;
    }

    public static void main(String[] args)
    {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        List<Integer> ret = findSubstring(s, words);
        System.out.println(ret);
    }
}

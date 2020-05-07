package lc.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;


public class FourTwoFour
{
    public static int characterReplacement(String s, int k)
    {
        if(s.length() < k)
            return s.length();

        Map<Character, List<Pair<Integer, Integer>>> buff = new HashMap<>();
        int left = 0;
        while(left < s.length())
        {
            int right = left;
            while(right < s.length() && s.charAt(right) == s.charAt(left))
                right++;

            if(!buff.containsKey(s.charAt(left)))
                buff.put(s.charAt(left), new ArrayList<>());
            buff.get(s.charAt(left)).add(new Pair<>(left, right - 1));

            left = right;
        }

        int ret = 0;
        for(Map.Entry<Character, List<Pair<Integer, Integer>>> entry : buff.entrySet())
        {
            List<Pair<Integer, Integer>> intervals = entry.getValue();
            if(intervals.size() == 1)
            {
                ret = Math.max(ret, intervals.get(0).getValue() - intervals.get(0).getKey() + 1);
                continue;
            }

            int start = 0, cur = 0, rem = k;
            while(cur < intervals.size())
            {
                if(cur == intervals.size() - 1)
                {
                    ret = Math.max(ret, intervals.get(cur).getValue() - intervals.get(start)
                            .getKey() + 1 + rem);
                    break;
                }

                int next = cur + 1;
                int need = intervals.get(next).getKey() - intervals.get(cur).getValue() - 1;

                if(need > rem)
                {
                    int t = intervals.get(cur).getValue() - intervals.get(start).getKey() + 1;
                    ret = Math.max(ret, t + rem);

                    rem += intervals.get(start + 1).getKey() - intervals.get(start).getValue() - 1;
                    start++;
                    continue;
                }

                rem -= need;
                cur++;
            }
        }

        return Math.min(ret, s.length());
    }

    public static void main(String[] args)
    {
        String s = "ABAB";
        int k = 2;
        int ret = characterReplacement(s, k);
        System.out.println(ret);
    }
}

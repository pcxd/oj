package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class SevenSixThree
{
    public static List<Integer> partitionLabels(String S)
    {
        if(S == null || S.isEmpty())
            return Collections.emptyList();

        Map<Character, Integer> minPos = new HashMap<>();
        Map<Character, Integer> maxPos = new HashMap<>();
        for(int i = 0; i < S.length(); i++)
        {
            if(!minPos.containsKey(S.charAt(i)))
                minPos.put(S.charAt(i), i);
            if(!maxPos.containsKey(S.charAt(i)))
                maxPos.put(S.charAt(i), i);

            if(i > maxPos.get(S.charAt(i)))
                maxPos.put(S.charAt(i), i);
        }

        List<Integer> labels = new ArrayList<>();
        int curStart = -1;
        int curEnd = -1;
        while(++curStart < S.length())
        {
            Set<Character> buff = new HashSet<>();
            buff.add(S.charAt(curStart));
            curEnd = maxPos.get(S.charAt(curStart));

            int pos = curStart;
            while(pos < S.length() && pos <= curEnd)
            {
                if(!buff.contains(S.charAt(pos)))
                {
                    buff.add(S.charAt(pos));
                    curEnd = Math.max(curEnd, maxPos.get(S.charAt(pos)));
                }

                pos++;
            }

            labels.add(curEnd - curStart + 1);
            curStart = curEnd;
        }

        return labels;
    }

    public static void main(String[] args)
    {
        String S = "ababcbacadefegdehijhklij";
        List<Integer> ret = partitionLabels(S);
        System.out.println(ret);
    }
}

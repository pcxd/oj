package lc.medium;

import java.util.Arrays;
import java.util.Comparator;


public class FiveTwoTwo
{
    public static int findLUSlength(String[] strs)
    {
        if(strs == null || strs.length == 0)
            return 0;

        Arrays.sort(strs, new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                return o2.length() - o1.length();
            }
        });

        for(int i = 0; i < strs.length; i++)
        {
            String curStr = strs[i];
            boolean equalFlag = false;
            for(int j = 0; j < strs.length; j++)
            {
                if(i == j)
                    continue;
                if(strs[j].equals(curStr))
                {
                    equalFlag = true;
                    break;
                }
            }

            if(!equalFlag)
            {
                boolean subSeqFlag = false;
                for(int j = 0; j < strs.length; j++)
                {
                    if(i == j)
                        continue;

                    if(strs[j].length() > curStr.length())
                    {
                        if(isSubSequence(curStr, strs[j]))
                        {
                            subSeqFlag = true;
                            break;
                        }
                    }
                }

                if(!subSeqFlag)
                    return curStr.length();
            }
        }

        return -1;
    }

    private static boolean isSubSequence(String s, String l)
    {
        if(s.length() > l.length())
            return false;

        int sc = 0, lc = 0;
        while(sc < s.length() && lc < l.length())
        {
            if(s.charAt(sc) == l.charAt(lc))
                sc++;
            lc++;
        }

        return sc == s.length();
    }
}

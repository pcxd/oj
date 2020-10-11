package lc.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class FivwTwoFour
{
    public static String findLongestWord(String s, List<String> d)
    {
        if(d == null || d.isEmpty())
            return "";

        Collections.sort(d, new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                if(o1.length() == o2.length())
                    return o1.compareTo(o2);
                return o2.length() - o1.length();
            }
        });

        for(String l : d)
        {
            if(isSubSeq(l, s))
                return l;
        }

        return "";
    }

    private static boolean isSubSeq(String s, String l)
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


    public static void main(String[] args)
    {
        String s = "abpcplea";
        List<String> d = new ArrayList<>(
                Arrays.asList(new String[]{"ale", "apple", "monkey", "plea"}));
        String ret = findLongestWord(s, d);
        System.out.println(ret);
    }
}

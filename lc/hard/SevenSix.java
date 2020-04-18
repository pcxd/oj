package lc.hard;

import java.util.HashMap;
import java.util.Map;


public class SevenSix
{
    public static String minWindow(String s, String t)
    {
        if(s == null || s.isEmpty() || t.isEmpty() || s.length() < t.length())
            return "";

        Map<Character, Integer> tc = new HashMap<>();
        for(Character c : t.toCharArray())
            tc.put(c, tc.getOrDefault(c, 0) + 1);

        String ret = "";
        int retLen = Integer.MAX_VALUE;

        int start = 0;
        int validLength = 0;
        Map<Character, Integer> cc = new HashMap<>();
        for(int end = 0; end < s.length(); end++)
        {
            if(!tc.containsKey(s.charAt(end)))
            {
                if(cc.isEmpty())
                {
                    start = end + 1;
                    validLength = 0;
                }
            }
            else
            {

                cc.put(s.charAt(end), cc.getOrDefault(s.charAt(end), 0) + 1);
                if(cc.get(s.charAt(end)) < tc.get(s.charAt(end)))
                {
                    validLength++;
                    if(validLength == t.length())
                    {
                        if(end - start + 1 < retLen)
                        {
                            ret = end + 1 == s.length() ? s.substring(start) : s
                                    .substring(start, end + 1);
                            retLen = ret.length();
                        }
                        cc.put(s.charAt(start), cc.get(s.charAt(start)) - 1);
                        start++;
                        validLength--;
                    }

                }
                while(start < s.length() && (!tc.containsKey(s.charAt(start)) || cc
                        .get(s.charAt(start)) > tc.get(s.charAt(start))))
                {
                    if(cc.containsKey(s.charAt(start)))
                        cc.put(s.charAt(start), cc.get(s.charAt(start)) - 1);
                    start++;
                }
            }
        }

        return ret;
    }


    public static void main(String[] args)
    {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String ret = minWindow(s, t);
        System.out.println(ret);
    }
}

package hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class SevenSix
{
    public String minWindow(String s, String t)
    {
        if(s == null || s.isEmpty() || t.isEmpty() || s.length() < t.length())
            return "";

        Set<Character> charSet = new HashSet<>();
        for(Character c : t.toCharArray())
            charSet.add(c);

        String ret = "";
        int left = 0;
        for(; left < s.length(); left++)
            if(charSet.contains(s.charAt(left)))
                break;

        int right = left;
        while(left < s.length())
        {

        }

        return ret;
    }
}

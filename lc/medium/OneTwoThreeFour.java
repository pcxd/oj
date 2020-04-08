package medium;

import java.util.HashMap;
import java.util.Map;


public class OneTwoThreeFour
{
    public static int balancedString(String s)
    {
        if(s == null || s.length() % 4 != 0)
            return -1;

        Map<Character, Integer> count = new HashMap<>();
        for(int i = 0; i < s.length(); i++)
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);

        Map<Character, Integer> need = new HashMap<>();
        for(Map.Entry<Character, Integer> entry : count.entrySet())
        {
            if(entry.getValue() > s.length() / 4)
                need.put(entry.getKey(), entry.getValue() - s.length() / 4);
        }

        Map<Character, Integer> cur = new HashMap<>();

        int ret = s.length();
        int start = 0, end = 0;
        while(end <= s.length())
        {
            boolean valid = true;
            for(Map.Entry<Character, Integer> entry : need.entrySet())
                if(cur.getOrDefault(entry.getKey(), 0) < entry.getValue())
                {
                    valid = false;
                    break;
                }

            if(valid)
            {
                ret = Math.min(ret, end - start);
                if(ret == 0)
                    return ret;

                cur.put(s.charAt(start), cur.getOrDefault(s.charAt(start), 0) - 1);
                start++;
            }
            else
            {
                if(end == s.length())
                    break;
                cur.put(s.charAt(end), cur.getOrDefault(s.charAt(end), 0) + 1);
                end++;
            }
        }

        return ret;
    }


    public static void main(String[] args)
    {
        String s = "WQWRQQQW";
        int ret = balancedString(s);
        System.out.println(ret);
    }
}

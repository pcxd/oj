package lc.medium;

import java.util.Arrays;


public class OneThreeFiveEight
{
    public static int numberOfSubstrings(String s)
    {
        if(s == null || s.length() < 3)
            return 0;

        int[] count = new int[3];
        Arrays.fill(count, 0);

        int ret = 0;
        int start = 0;
        for(int end = 0; end < s.length(); end++)
        {
            count[s.charAt(end) - 'a']++;
            while(count[0] > 0 && count[1] > 0 && count[2] > 0)
            {
                count[s.charAt(start) - 'a']--;
                start++;
            }

            ret += start;
        }

        return ret;
    }


    public static void main(String[] args)
    {
        String s = "abcabc";
        int ret = numberOfSubstrings(s);
        System.out.println(ret);
    }
}

package lc.medium;

import java.util.Arrays;


public class SixFourSeven
{
    public static int countSubstrings(String s)
    {
        if(s == null || s.isEmpty())
            return 0;

        char[] buff = new char[s.length() * 2 - 1];
        Arrays.fill(buff, '#');
        for(int i = 0; i < s.length(); i++)
            buff[2 * i] = s.charAt(i);
        String st = String.copyValueOf(buff);

        int ret = 0;
        for(int i = 0; i < st.length(); i++)
        {
            ret += getPalindromicNum(s, i, i);
            ret += getPalindromicNum(s, i, i + 1);
        }

        return ret;
    }

    private static int getPalindromicNum(String s, int left, int right)
    {
        if(left < 0 || right >= s.length())
            return 0;

        int num = 0;
        while(left >= 0 && right < s.length())
        {
            if(s.charAt(left) != s.charAt(right))
                break;

            num++;
            left--;
            right++;
        }

        return num;
    }


    public static void main(String[] args)
    {
        String s = "aaa";
        int ret = countSubstrings(s);
        System.out.println(ret);
    }
}

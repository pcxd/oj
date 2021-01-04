package hard;

public class SevenTwoSeven
{
    public static int minSubString(String s, String t)
    {
        if(s == null || t == null || s.isEmpty() || t.isEmpty())
            return 0;

        int ret = Integer.MAX_VALUE;
        int sp = 0;
        while(sp < s.length())
        {
            if(s.charAt(sp) != t.charAt(0))
            {
                sp++;
                continue;
            }

            int start = sp;
            int end = sp;
            int tp = 0;
            while(end < s.length() && tp < t.length())
            {
                if(s.charAt(end) == t.charAt(tp))
                    tp++;
                end++;
            }
            if(tp == t.length())
            {
                String subStr = s.substring(start, end);
                int subRet = minSubsequence(subStr, t);
                ret = Math.min(ret, subRet);
                System.out.println(s.substring(end - ret, end));
            }

            sp = end;
        }

        return ret;
    }


    private static int minSubsequence(String s, String t)
    {
        int start = s.length() - 1;
        int tp = t.length() - 1;

        while(start >= 0 && tp >= 0)
        {
            if(s.charAt(start) == t.charAt(tp))
                tp--;
            start--;
        }

        return tp == -1 ? s.length() - start - 1 : -1;
    }


    public static void main(String[] args)
    {
        String s = "abcdebdde";
        String t = "bde";
        int ret = minSubString(s, t);
        System.out.println(ret);
    }
}

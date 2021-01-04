package hard;

public class TwoOneFour
{
    public static String shortestPalindrome(String s)
    {
        if(s == null || s.length() <= 1)
            return s;

        int right = -1;
        for(int i = s.length() - 1; i >= 0; i--)
        {
            int start = 0;
            int end = i;
            boolean flag = true;
            while(start < end)
            {
                if(s.charAt(start) == s.charAt(end))
                {
                    start++;
                    end--;
                }
                else
                {
                    flag = false;
                    break;
                }
            }

            if(flag)
            {
                right = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder(s);
        for(int i = right + 1; i < s.length(); i++)
            sb.insert(0, s.charAt(i));

        return sb.toString();
    }


    public static void main(String[] args)
    {
        String s = "abcde";
        String ret = shortestPalindrome(s);
        System.out.println(ret);
    }
}

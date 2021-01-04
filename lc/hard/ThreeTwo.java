package hard;

import java.util.Stack;


public class ThreeTwo
{
    public static int longestValidParentheses(String s)
    {
        if(s == null || s.isEmpty())
            return 0;

        boolean[] used = new boolean[s.length()];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++)
        {
            if(!stack.isEmpty() && (s.charAt(i) == ')' && s.charAt(stack.peek()) == '('))
            {
                used[stack.peek()] = true;
                used[i] = true;

                stack.pop();
            }
            else
                stack.push(i);
        }

        int pos = 0;
        int ret = 0;
        while(pos < used.length)
        {
            if(used[pos])
            {
                int cur = 0;
                while(pos < used.length && used[pos])
                {
                    cur++;
                    pos++;
                }
                ret = Math.max(ret, cur);
            }

            pos++;
        }

        return ret;
    }


    public static void main(String[] args)
    {
        String s = ")(";
        int ret = longestValidParentheses(s);
        System.out.println(ret);
    }
}

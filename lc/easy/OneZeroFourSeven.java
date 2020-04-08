package easy;

import java.util.Stack;


public class OneZeroFourSeven
{
    public static String removeDuplicates(String S)
    {
        if(S == null || S.isEmpty())
            return S;

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < S.length(); i++)
        {
            if(!stack.isEmpty() && stack.peek() == S.charAt(i))
                stack.pop();
            else
                stack.push(S.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.insert(0, stack.pop());

        return sb.toString();
    }


    public static void main(String[] args)
    {
        String S = "abbaca";
        String ret = removeDuplicates(S);
        System.out.println(ret);
    }
}

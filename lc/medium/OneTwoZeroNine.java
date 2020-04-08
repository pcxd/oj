package medium;

import java.util.Arrays;
import java.util.Stack;

import javafx.util.Pair;


public class OneTwoZeroNine
{
    public static String removeDuplicates(String s, int k)
    {
        if(s == null || s.length() < k)
            return s;

        Stack<Pair<Character, Integer>> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++)
        {
            if(stack.isEmpty() || stack.peek().getKey() != s.charAt(i))
                stack.push(new Pair<>(s.charAt(i), 1));
            else
            {
                Pair<Character, Integer> p = stack.pop();
                if(p.getValue() + 1 != k)
                    stack.push(new Pair<>(p.getKey(), p.getValue() + 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
        {
            Pair<Character, Integer> p = stack.pop();
            char[] t = new char[p.getValue()];
            Arrays.fill(t, p.getKey());
            sb.insert(0, new String(t));
        }

        return sb.toString();
    }

    public static void main(String[] args)
    {
        String s = "pbbcggttciiippooaais";
        int k = 2;
        String ret = removeDuplicates(s, k);
        System.out.println(ret);
    }
}

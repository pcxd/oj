package medium;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;
import java.util.TreeSet;


public class ThreeOneSix
{
    public static String removeDuplicateLetters(String s)
    {
        if(s == null || s.isEmpty())
            return "";

        TreeMap<Character, TreeSet<Integer>> charCount = new TreeMap<>();
        for(int i = 0; i < s.length(); i++)
        {
            char sc = s.charAt(i);
            if(!charCount.containsKey(sc))
                charCount.put(sc, new TreeSet<>());
            charCount.get(sc).add(i);
        }

        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++)
        {
            if(stack.contains(s.charAt(i)))
                continue;

            while(!stack.isEmpty())
            {
                char prevChar = stack.peek();
                if(s.charAt(i) == prevChar)
                    stack.pop();
                else if(s.charAt(i) < prevChar)
                {
                    if(charCount.get(prevChar).ceiling(i) != null)
                        stack.pop();
                    else
                        break;
                }
                else
                    break;
            }

            stack.push(s.charAt(i));
        }

        System.out.println(stack.toString());
        StringBuilder ret = new StringBuilder();
        while(!stack.isEmpty())
            ret.append(stack.pollLast());

        return ret.toString();
    }


    public static void main(String[] args)
    {
        String s = "cbacdcbc"; //cbacdcbc
        String ret = removeDuplicateLetters(s);
        System.out.println(ret);
    }
}

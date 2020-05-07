package lc.contest.One85;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class FiveThreeEightEight
{
    public static String reformat(String s)
    {
        if(s == null || s.isEmpty())
            return "";

        List<Character> cs = new LinkedList<>();
        List<Character> is = new LinkedList<>();

        for(char c : s.toCharArray())
        {
            if(Character.isDigit(c))
                is.add(c);
            else if(Character.isLetter(c))
                cs.add(c);
        }

        if(Math.abs(cs.size()-is.size()) > 1)
            return "";

        List<Character> first = cs.size() > is.size() ? cs : is;
        List<Character> second = cs.size() > is.size() ? is : cs;

        StringBuilder sb = new StringBuilder();
        while(!first.isEmpty() || !second.isEmpty())
        {
            if(!first.isEmpty())
                sb.append(first.remove(0));
            if(!second.isEmpty())
                sb.append(second.remove(0));
        }


        return sb.toString();
    }

    public static void main(String[] args)
    {
        String s = "covid2019";
        String ret = reformat(s);
        System.out.println(ret);
    }
}

package lc.medium;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class OneTwoThreeNine
{
    private static int RET = 0;

    public static int maxLength(List<String> arr)
    {
        if(arr.isEmpty())
            return 0;

        RET = 0;
        List<String> rst = new ArrayList<>();
        Set<Character> cur = new HashSet<>();

        dfs(arr, 0, cur, rst);

        return RET;
    }

    private static void dfs(List<String> arr, int pos, Set<Character> cur, List<String> rst)
    {
        if(pos == arr.size())
        {
            int lengthSum = 0;
            for(String r : rst)
                lengthSum += r.length();

            RET = Math.max(RET, lengthSum);
            return;
        }

        boolean addFlag = true;
        Set<Character> selfSet = new HashSet<>();
        for(Character c : arr.get(pos).toCharArray())
        {
            if(selfSet.contains(c) || cur.contains(c))
            {
                addFlag = false;
                break;
            }

            selfSet.add(c);
        }

        if(addFlag)
        {
            for(Character c : arr.get(pos).toCharArray())
                cur.add(c);
            rst.add(arr.get(pos));

            dfs(arr, pos + 1, cur, rst);

            for(Character c : arr.get(pos).toCharArray())
                cur.remove(c);
            rst.remove(rst.size()-1);
        }

        dfs(arr, pos + 1, cur, rst);
    }

    public static void main(String[] args)
    {
        List<String> arr = new ArrayList<>();
        arr.add("un");
        arr.add("iq");
        arr.add("ue");

        int ret = maxLength(arr);
        System.out.println(ret);
    }
}

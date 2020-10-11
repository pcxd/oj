package lc.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ThreeEightSix
{
    public static List<Integer> lexicalOrder(int n)
    {
        if(n < 1)
            return Collections.emptyList();

        List<Integer> ret = new ArrayList<>();
        for(int i = 1; i < 10; i++)
            dfs(i, n, ret);

        return ret;
    }

    private static void dfs(int cur, int n, List<Integer> ret)
    {
        if(cur > n)
            return;

        ret.add(cur);
        for(int i = 0; i < 10; i++)
        {
            int next = cur * 10 + i;
            if(next > n)
                break;

            dfs(next, n, ret);
        }
    }


    public static void main(String[] args)
    {
        int n = 13;
        List<Integer> ret = lexicalOrder(n);
        System.out.println(ret);
    }
}

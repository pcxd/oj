package medium;

import java.util.ArrayList;
import java.util.List;


public class TwoTwo
{
    public static List<String> generateParenthesis(int n)
    {
        if(n <= 0)
            return null;

        List<String> ret = new ArrayList<>();
        dfs(n, n, new StringBuilder(), ret);

        return ret;
    }

    private static void dfs(int lr, int rr, StringBuilder path, List<String> ret)
    {
        if(lr == 0 && rr == 0)
        {
            ret.add(path.toString());
            return;
        }
        if(lr > 0)
        {
            path.append('(');
            dfs(lr - 1, rr, path, ret);

            path.deleteCharAt(path.length() - 1);
        }

        if(rr > 0 && rr > lr)
        {
            path.append(')');
            dfs(lr, rr - 1, path, ret);

            path.deleteCharAt(path.length() - 1);
        }
    }


    public static void main(String[] args)
    {
        int n = 3;
        List<String> ret = generateParenthesis(n);
        System.out.println(ret);
    }
}

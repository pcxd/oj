package medium;

import java.util.ArrayList;
import java.util.List;


public class ThreeZeroSix
{
    public static boolean isAdditiveNumber(String num)
    {
        if(num.length() < 3)
            return false;

        return dfs(num, 0, new ArrayList<>());
    }

    private static boolean dfs(String num, int pos, List<Long> path)
    {
        if(pos == num.length() && path.size() > 2)
            return true;

        for(int i = pos + 1; i <= num.length(); i++)
        {
            if(i != (pos + 1) && num.charAt(pos) == '0')
                return false;
            long val = Long.parseLong(num.substring(pos, i));
            if(path.size() >= 2)
            {
                long a = path.get(path.size() - 2);
                long b = path.get(path.size() - 1);
                if(a + b != val)
                    continue;
            }

            path.add(val);
            if(dfs(num, i, path))
                return true;
            path.remove(path.size() - 1);
        }

        return false;
    }


    public static void main(String[] args)
    {
        String num = "0000";
        boolean ret = isAdditiveNumber(num);
        System.out.println(ret);
    }
}

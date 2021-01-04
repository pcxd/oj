package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class OneThreeFourFive
{
    public static int minJumps(int[] arr)
    {
        if(arr == null || arr.length == 0)
            return 0;

        int n = arr.length;
        Map<Integer, List<Integer>> buff = new HashMap<>();
        for(int i = 0; i < n; i++)
        {
            if(!buff.containsKey(arr[i]))
                buff.put(arr[i], new ArrayList<>());
            buff.get(arr[i]).add(i);
        }

        int[] memo = new int[n];
        boolean[] vis = new boolean[n];
        Set<Integer> curLevel = new HashSet<>();
        vis[0] = true;
        memo[0] = 0;
        curLevel.add(0);

        while(!curLevel.isEmpty())
        {
            if(curLevel.contains(n - 1))
                break;

            Set<Integer> nextLevel = new HashSet<>();
            for(Integer pos : curLevel)
            {
                if(buff.containsKey(arr[pos]))
                {
                    for(Integer nextPos : buff.get(arr[pos]))
                    {
                        if(!vis[nextPos])
                        {
                            memo[nextPos] = memo[pos] + 1;
                            vis[nextPos] = true;
                            nextLevel.add(nextPos);
                        }
                    }
                    buff.remove(arr[pos]);
                }

                if(pos + 1 < n && !vis[pos + 1])
                {
                    memo[pos + 1] = memo[pos] + 1;
                    vis[pos + 1] = true;
                    nextLevel.add(pos + 1);
                }
                if(pos - 1 >= 0 && !vis[pos - 1])
                {
                    memo[pos - 1] = memo[pos] + 1;
                    vis[pos - 1] = true;
                    nextLevel.add(pos - 1);
                }
            }

            curLevel = nextLevel;
        }

        return memo[n - 1];
    }


    public static void main(String[] args)
    {
        int[] arr = {7};
        int ret = minJumps(arr);
        System.out.println(ret);
    }
}

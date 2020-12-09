package lc.contest.Two18;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Two
{
    public static int maxOperations(int[] nums, int k)
    {
        if(nums == null || nums.length == 0)
            return 0;

        Map<Integer, Integer> numCount = new HashMap<>();
        for(int num : nums)
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);

        int ret = 0;
        Set<Integer> visited = new HashSet<>();
        for(Map.Entry<Integer, Integer> entry : numCount.entrySet())
        {
            if(visited.contains(entry.getKey()))
                continue;

            int a = entry.getKey();
            int b = k - a;
            if(a == b)
                ret += entry.getValue() / 2;
            else if(numCount.containsKey(b))
            {
                ret += Math.min(entry.getValue(), numCount.get(b));
                visited.add(b);
            }
            visited.add(a);
        }

        return ret;
    }


    public static void main(String[] args)
    {
        int[] nums = new int[]{3, 1, 3, 4, 3};
        int k = 6;
        int ret = maxOperations(nums, k);
        System.out.println(ret);
    }
}

package lc.contest.Two18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Four
{
    private static List<List<Integer>> subsets;
    private static int size;

    public static int minimumIncompatibility(int[] nums, int k)
    {
        if(nums == null || nums.length == 0 || nums.length % k != 0)
            return -1;

        int maxCnt = 0;
        Map<Integer, Integer> numCnt = new HashMap<>();
        for(int num : nums)
        {
            numCnt.put(num, numCnt.getOrDefault(num, 0) + 1);
            maxCnt = Math.max(maxCnt, numCnt.get(num));
        }
        if(maxCnt > k)
            return -1;

        size = nums.length / k;
        subsets = new ArrayList<>();
        for(int i = 0; i < k; i++)
            subsets.add(new ArrayList<>());

        helper(numCnt, 0, k);

        int ret = 0;
        for(List<Integer> subset : subsets)
        {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(Integer val : subset)
            {
                min = Math.min(min, val);
                max = Math.max(max, val);
            }

            ret += max - min;
        }

        return ret;
    }

    private static void helper(Map<Integer, Integer> numCnt, int cur, int k)
    {
        if(cur >= k || numCnt.isEmpty())
            return;

        Set<Integer> remove = new HashSet<>();
        for(Map.Entry<Integer, Integer> entry : numCnt.entrySet())
        {
            if(entry.getValue() == k - cur)
            {
                for(int i = 0; cur + i < k; i++)
                    subsets.get(cur + i).add(entry.getKey());
                remove.add(entry.getKey());
            }
            if(entry.getValue() == 0)
                remove.add(entry.getKey());
        }
        for(Integer r : remove)
            numCnt.remove(r);

        int curSize = subsets.get(cur).size();
        if(curSize < size)
        {
            List<Integer> keys = new ArrayList<>(numCnt.keySet());
            keys.sort((a, b)->b - a);

            for(int i = 0; i < size - curSize; i++)
                subsets.get(cur).add(keys.get(i));
            for(int i = 0; i < size - curSize; i++)
                numCnt.put(keys.get(i), numCnt.get(keys.get(i)) - 1);
        }

        while(cur < subsets.size() && subsets.get(cur).size() == size)
            cur++;
        helper(numCnt, cur, k);
    }


    public static void main(String[] args)
    {
        int[] nums = {1, 2, 1, 4};
        int k = 2;
        int ret = minimumIncompatibility(nums, k);
        System.out.println(ret);
    }
}

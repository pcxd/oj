package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ThreeFourSeven
{
    public static List<Integer> topKFrequent(int[] nums, int k)
    {
        if(nums == null || nums.length < k)
            return null;

        Map<Integer, Integer> buff = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
            buff.put(nums[i], buff.getOrDefault(nums[i], 0) + 1);

        List<Pair> pairs = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : buff.entrySet())
            pairs.add(new Pair(entry.getKey(), entry.getValue()));

        pairs.sort((Pair p1, Pair p2)->p2.cnt - p1.cnt);
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < k; i++)
            ret.add(pairs.get(i).val);

        return ret;
    }


    public static void main(String[] args)
    {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        List<Integer> ret = topKFrequent(nums, k);
        System.out.println(ret);
    }
}


class Pair
{
    int val;
    int cnt;

    Pair(int val, int cnt)
    {
        this.val = val;
        this.cnt = cnt;
    }
}

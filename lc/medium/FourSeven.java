package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FourSeven
{
    private static int N = 0;

    public static List<List<Integer>> permuteUnique(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return null;

        Arrays.sort(nums);
        Map<Integer, Integer> buff = new HashMap<>();
        for(int num : nums)
        {
            Integer val = buff.getOrDefault(num, 0);
            buff.put(num, val + 1);
        }

        N = nums.length;
        boolean[] vis = new boolean[nums.length];
        List<List<Integer>> ret = new ArrayList<>();

        //dfs(buff, new ArrayList<Integer>(), ret);
        dfs2(nums, vis, new ArrayList<>(), ret);

        return ret;
    }

    private static void dfs(Map<Integer, Integer> buff, List<Integer> path, List<List<Integer>> ret)
    {
        if(path.size() == N)
        {
            ret.add(new ArrayList<>(path));
            return;
        }

        for(Map.Entry<Integer, Integer> entry : buff.entrySet())
        {
            int key = entry.getKey();
            int val = entry.getValue();
            if(val != 0)
            {
                path.add(key);
                buff.put(entry.getKey(), val - 1);

                dfs(buff, path, ret);

                path.remove(path.size() - 1);
                buff.put(key, val);
            }
        }
    }


    private static void dfs2(int[] nums, boolean[] vis, List<Integer> path, List<List<Integer>> ret)
    {
        if(path.size() == nums.length)
        {
            ret.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++)
        {
            if(vis[i])
                continue;

            path.add(nums[i]);
            vis[i] = true;

            dfs2(nums, vis, path, ret);

            path.remove(path.size() - 1);
            vis[i] = false;

            while(i + 1 < nums.length && nums[i] == nums[i + 1])
                i++;
        }
    }


    public static void main(String[] args)
    {
        int[] nums = {1, 1, 2};
        List<List<Integer>> ret = permuteUnique(nums);
        System.out.println(ret);
    }
}

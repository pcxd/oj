package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class FourSix
{
    public static List<List<Integer>> permute(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return null;

        boolean[] vis = new boolean[nums.length];
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        dfs(nums, vis, new ArrayList<Integer>(), ret);

        return ret;
    }

    private static void dfs(int[] nums, boolean[] vis, List<Integer> path, List<List<Integer>> ret)
    {
        if(path.size() == vis.length)
        {
            ret.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < vis.length; i++)
        {
            if(!vis[i])
            {
                path.add(nums[i]);
                vis[i] = true;

                dfs(nums, vis, path, ret);

                path.remove(path.size() - 1);
                vis[i] = false;
            }
        }
    }


    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ret = permute(nums);
        System.out.println(ret);
    }
}

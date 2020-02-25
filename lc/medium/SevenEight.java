package medium;

import java.util.ArrayList;
import java.util.List;


public class SevenEight
{
    public static List<List<Integer>> subsets(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return null;

        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        dfs(nums, 0, new ArrayList<>(), ret);

        return ret;
    }

    private static void dfs(int[] nums, int pos, List<Integer> path, List<List<Integer>> ret)
    {
        if(pos == nums.length)
        {
            ret.add(new ArrayList<>(path));
            return;
        }

        path.add(nums[pos]);
        dfs(nums, pos + 1, path, ret);

        path.remove(path.size() - 1);
        dfs(nums, pos + 1, path, ret);
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3};

        List<List<Integer>> ret = subsets(nums);
        System.out.println(ret);
    }
}

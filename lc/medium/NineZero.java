package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class NineZero
{
    public static List<List<Integer>> subsetsWithDup(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return null;

        Arrays.sort(nums);
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
        int nextPos = pos + 1;
        while(nextPos < nums.length && nums[nextPos] == nums[pos])
            nextPos++;

        dfs(nums, nextPos, path, ret);
    }


    public static void main(String[] args)
    {
        int[] nums = {1, 2, 2};
        List<List<Integer>> ret = subsetsWithDup(nums);
        System.out.println(ret);
    }
}

package medium;

import java.util.ArrayList;
import java.util.List;


public class SevenSeven
{
    public static List<List<Integer>> combine(int n, int k)
    {
        if(n == 0 || k > n)
            return null;

        List<List<Integer>> ret = new ArrayList<>();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = i+1;

        dfs(nums, k, 0, new boolean[n], new ArrayList<>(), ret);

        return ret;
    }

    private static void dfs(int[] nums, int k, int pos, boolean[] vis, List<Integer> path,
            List<List<Integer>> ret)
    {
        if(path.size() == k)
        {
            ret.add(new ArrayList<>(path));
            return;
        }
        if(pos >= nums.length)
            return;

        path.add(nums[pos]);
        vis[pos] = true;
        dfs(nums, k, pos+1, vis, path, ret);

        path.remove(path.size()-1);
        vis[pos] = false;
        dfs(nums, k, pos+1, vis, path, ret);
    }


    public static void main(String[] args)
    {
        int n = 4;
        int k = 2;
        List<List<Integer>> ret = combine(n, k);
        System.out.println(ret);
    }
}

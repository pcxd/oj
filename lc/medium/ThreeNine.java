package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeNine
{
    public static List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0)
            return ret;

        Arrays.sort(candidates);
        System.out.println(Arrays.toString(candidates));
        //bt(candidates, 0, 0, target, new ArrayList<>(), ret);
        dfs(candidates, target, 0, new ArrayList<>(), ret);

        return ret;
    }

    private static void bt(int[] candidates, int idx, int sum, int target, List<Integer> ans,
            List<List<Integer>> ret)
    {
        if(idx == candidates.length || sum > target)
            return;
        if(sum == target)
        {
            ret.add(new ArrayList<>(ans));
            return;
        }

        ans.add(candidates[idx]);
        bt(candidates, idx, sum + candidates[idx], target, ans, ret);

        ans.remove(ans.size() - 1);
        bt(candidates, idx + 1, sum, target, ans, ret);
    }

    private static void dfs(int[] cands, int remain, int curIdx, List<Integer> path,
            List<List<Integer>> ret)
    {
        if(remain < 0)
            return;
        if(remain == 0)
        {
            ret.add(new ArrayList<>(path));
            return;
        }

        for(int i = curIdx; i < cands.length; i++)
        {
            path.add(cands[i]);
            dfs(cands, remain - cands[i], i, path, ret);

            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args)
    {
        int[] candidates = {2, 3, 5};
        int target = 8;

        List<List<Integer>> ret = combinationSum(candidates, target);

        System.out.println(ret);
    }
}

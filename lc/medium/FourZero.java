package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FourZero
{
    public static List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        if(candidates == null || candidates.length == 0)
            return null;

        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(candidates, target, 0, new ArrayList<>(), ret);

        return ret;
    }

    private static void dfs(int[] cands, int remain, int pos, List<Integer> path,
            List<List<Integer>> ret)
    {
        if(remain == 0)
        {
            ret.add(new ArrayList<>(path));
            return;
        }

        while(pos < cands.length)
        {
            if(remain < cands[pos])
                return;
            path.add(cands[pos]);
            dfs(cands, remain - cands[pos], pos + 1, path, ret);

            while(pos + 1 < cands.length && cands[pos] == cands[pos + 1])
                pos++;
            pos++;

            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args)
    {
        int[] cands = {2, 5, 1, 2, 1, 2};
        int target = 5;

        List<List<Integer>> ret = combinationSum2(cands, target);
        System.out.println(ret);
    }

}

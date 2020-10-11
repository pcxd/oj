package lc.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class FiveTwoThree
{
    public static boolean checkSubarraySum(int[] nums, int k)
    {
        if(nums == null || nums.length < 2)
            return false;

        List<Set<Integer>> sums = new ArrayList<>();
        for(int i = 0; i < nums.length; i++)
            sums.add(new HashSet<>());

        for(int i = 0; i < nums.length; i++)
        {
            int curVal = (k == 0 ? nums[i] : (nums[i] % k));
            sums.get(i).add(curVal);
            if(i == 0)
                continue;

            for(Integer prevSum : sums.get(i - 1))
            {
                int curSum = (nums[i] + prevSum);
                curSum = k == 0 ? curSum : curSum % k;
                sums.get(i).add(curSum);

                if(curSum == 0)
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3};
        int k = 0;
        boolean ret = checkSubarraySum(nums, k);
        System.out.println(ret);
    }
}

package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class FourOneSix
{
    public static boolean canPartition(int[] nums)
    {
        if(nums.length == 1)
            return false;

        int sum = 0;
        for(int n : nums)
            sum += n;
        if(sum % 2 != 0)
            return false;

        List<Set<Integer>> endSums = new ArrayList<>();
        for(int i = 0; i < nums.length; i++)
            endSums.add(new HashSet<>());
        endSums.get(0).add(0);
        endSums.get(0).add(nums[0]);

        for(int i = 1; i < nums.length; i++)
        {
            for(Integer prevSum : endSums.get(i - 1))
            {
                int curSum = prevSum + nums[i];
                endSums.get(i).add(prevSum);
                endSums.get(i).add(curSum);
                if(curSum == sum / 2)
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 5};
        boolean ret = canPartition(nums);
        System.out.println(ret);
    }
}

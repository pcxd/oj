package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FourFourEight
{
    public static List<Integer> findDisappearedNumbers(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return Collections.emptyList();

        for(int i = 0; i < nums.length; i++)
        {
            while(nums[i] != i + 1)
            {
                if(nums[i] == nums[nums[i] - 1])
                    break;
                int t = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[t - 1] = t;
            }
        }

        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < nums.length; i++)
            if(nums[i] != i + 1)
                ret.add(i + 1);

        return ret;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> ret = findDisappearedNumbers(nums);
        System.out.println(ret.toString());
    }
}

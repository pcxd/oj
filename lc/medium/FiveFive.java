package medium;

import java.util.Arrays;


public class FiveFive
{
    public static boolean canJump(int[] nums)
    {
        if(nums == null || nums.length == 0 || nums[0] == 0)
            return false;

        int maxIdx = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(i > maxIdx)
                return false;

            maxIdx = Math.max(maxIdx, i + nums[i]);
            if(maxIdx >= nums.length - 1)
                return true;
        }

        return false;
    }

    public static void main(String[] args)
    {
        int[] nums = {3, 0, 8, 2, 0, 0, 1};
        boolean ret = canJump(nums);
        System.out.println(ret);
    }
}

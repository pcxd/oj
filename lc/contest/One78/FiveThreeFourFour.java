package contest.One78;

import java.util.Arrays;


public class FiveThreeFourFour
{
    public static int[] smallerNumbersThanCurrent(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return new int[0];

        int[] ret = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
        {
            int target = nums[i];
            int cnt = 0;
            for(int j = 0; j < nums.length; j++)
                if(nums[j] < target)
                    cnt++;

            ret[i] = cnt;
        }

        return ret;
    }


    public static void main(String[] args)
    {
        int[] nums = {7,7,7,7};
        int[] ret = smallerNumbersThanCurrent(nums);
        System.out.println(Arrays.toString(ret));
    }
}

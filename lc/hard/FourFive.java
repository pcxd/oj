package hard;

import java.util.Arrays;


public class FourFive
{
    public static int jump(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return 0;

        int step = 0;
        int curEnd = 0, curFast = 0;
        for(int i = 0; i < nums.length - 1; i++)
        {
            curFast = Math.max(curFast, i + nums[i]);
            if(i == curEnd)
            {
                step++;
                curEnd = curFast;

                if(curEnd >= nums.length - 1)
                    break;
            }
        }

        return step;
    }


    public static void main(String[] args)
    {
        int[] nums = {2, 3, 1, 1, 4};
        int ret = jump(nums);
        System.out.println(ret);
    }
}

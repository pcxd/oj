package lc.medium;

import java.util.Arrays;


public class FiveSixZero
{
    public static int subarraySum(int[] nums, int k)
    {
        if(nums == null || nums.length == 0)
            return 0;

        int sum = 0;
        int[] buff = new int[nums.length + 1];
        Arrays.fill(buff, 0);
        for(int i = 1; i < buff.length; i++)
        {
            sum += nums[i - 1];
            buff[i] = sum;
        }

        int ret = 0;
        for(int i = 1; i < buff.length; i++)
        {
            for(int j = 0; j < i; j++)
                if(buff[i] - buff[j] == k)
                    ret++;
        }

        return ret;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 1, 1};
        int k = 2;
        int ret = subarraySum(nums, k);
        System.out.println(ret);
    }
}

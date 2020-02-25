package easy;

public class FiveThree
{
    public static int maxSubArray(int[] nums)
    {
        if(nums==null || nums.length == 0)
            return 0;

        int maxVal = nums[0];
        int curSum = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            if(curSum < 0)
                curSum = nums[i];
            else
                curSum += nums[i];

            maxVal = Math.max(maxVal, curSum);
        }

        return maxVal;
    }

    public static void main(String[] args)
    {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int ret = maxSubArray(nums);
        System.out.println(ret);
    }
}

package medium;

public class FourSevenSeven
{
    public static int totalHammingDistance(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return 0;

        int ret = 0;
        for(int i = 0; i < 32; i++)
        {
            int cnt = 0;
            for(int j = 0; j < nums.length; j++)
                cnt += (nums[j] >> i) & 1;

            ret += cnt * (nums.length - cnt);
        }

        return ret;
    }

    public static void main(String[] args)
    {
        int[] nums = {4, 14, 2};
        int ret = totalHammingDistance(nums);
        System.out.println(ret);
    }
}

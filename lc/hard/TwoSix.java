package hard;

public class TwoSix
{
    public static int removeDuplicates(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return 0;

        int finalEnd = 0, cur = 0;
        while(cur < nums.length)
        {
            while(cur < nums.length)
                if(cur + 1 < nums.length && nums[cur] == nums[cur + 1])
                    cur++;
                else
                    break;

            nums[finalEnd++] = nums[cur++];
        }

        return finalEnd;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 1, 1};

        int ret = removeDuplicates(nums);
        System.out.println(ret);
    }
}

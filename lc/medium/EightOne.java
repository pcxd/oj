package medium;

public class EightOne
{
    public static boolean search(int[] nums, int target)
    {
        if(nums == null || nums.length == 0)
            return false;

        int left = 0, right = nums.length - 1;
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return true;

            if(nums[mid] >= nums[left])
            {
                if(nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            else
            {
                if(nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }

        return false;
    }


    public static void main(String[] args)
    {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 3;
        boolean ret = search(nums, target);
        System.out.println(ret);
    }
}

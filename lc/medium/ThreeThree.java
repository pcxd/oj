package medium;

public class ThreeThree
{
    public static int search(int[] nums, int target)
    {
        if(nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;

            if(nums[left] < nums[right])
            {
                if(nums[mid] < target)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            else
            {
                if(nums[mid] >= nums[left])
                {
                    if(nums[mid] < target)
                        left = mid + 1;
                    else
                    {
                        if(nums[left] <= target)
                            right = mid - 1;
                        else
                            left = mid + 1;
                    }
                }
                else
                {
                    if(nums[mid] > target)
                        right = mid - 1;
                    else
                    {
                        if(nums[right] < target)
                            right = mid - 1;
                        else
                            left = mid + 1;
                    }
                }
            }
        }

        return -1;
    }


    public static void main(String[] args)
    {
        int[] nums = {3, 5, 1};
        int target = 3;
        int ret = search(nums, target);
        System.out.println(ret);
    }
}

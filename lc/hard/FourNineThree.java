package hard;

public class FourNineThree
{
    public static int reversePairs(int[] nums)
    {
        if(nums == null || nums.length <= 1)
            return 0;

        int ret = reverseHelper(nums, 0, nums.length - 1);

        return ret;
    }

    private static int reverseHelper(int[] nums, int left, int right)
    {
        if(left >= right)
            return 0;

        int mid = left + (right - left) / 2;
        int ret = reverseHelper(nums, left, mid) + reverseHelper(nums, mid + 1, right);

        int rightBound = mid + 1;
        for(int i = left; i <= mid; i++)
        {
            while(rightBound <= right && 2 * (long) nums[rightBound] < (long) nums[i])
                rightBound++;

            ret += rightBound - (mid + 1);
        }

        int leftIdx = left;
        int rightIdx = mid + 1;
        int[] cache = new int[right - left + 1];
        int cacheIdx = 0;
        while(cacheIdx < cache.length)
        {
            int leftVal = leftIdx <= mid ? nums[leftIdx] : Integer.MAX_VALUE;
            int rightVal = rightIdx <= right ? nums[rightIdx] : Integer.MAX_VALUE;
            cache[cacheIdx++] = leftVal <= rightVal ? nums[leftIdx++] : nums[rightIdx++];
        }

        System.arraycopy(cache, 0, nums, left, cache.length);

        return ret;
    }


    public static void main(String[] args)
    {
        int[] nums = {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
        int ret = reversePairs(nums);
        System.out.println(ret);
    }
}

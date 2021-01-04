package hard;

import java.util.Arrays;


public class ThreeTwoSeven
{
    public static int countRangeSum(int[] nums, int lower, int upper)
    {
        if(nums == null || nums.length == 0)
            return 0;

        long[] sums = new long[nums.length + 1];
        for(int i = 1; i < sums.length; i++)
            sums[i] = sums[i - 1] + nums[i - 1];

        int ret = mergeSortHelper(sums, 0, sums.length - 1, lower, upper);
        return ret;
    }

    private static int mergeSortHelper(long[] arr, int left, int right, int lower, int upper)
    {
        if(left >= right)
            return 0;

        int mid = left + (right - left) / 2;
        int ret = mergeSortHelper(arr, left, mid, lower, upper) + mergeSortHelper(arr, mid + 1,
                right, lower, upper);

        int lowerBound = mid + 1;
        int upperBound = mid + 1;
        for(int i = left; i <= mid; i++)
        {
            while(lowerBound <= right && arr[lowerBound] - arr[i] < lower)
                lowerBound++;
            while(upperBound <= right && arr[upperBound] - arr[i] <= upper)
                upperBound++;

            ret += (upperBound - lowerBound);
        }

        long[] cache = new long[right - left + 1];
        int cacheIdx = 0;
        int leftIdx = left;
        int rightIdx = mid + 1;
        while(cacheIdx < cache.length)
        {
            long numLeft = leftIdx <= mid ? arr[leftIdx] : Long.MAX_VALUE;
            long numRight = rightIdx <= right ? arr[rightIdx] : Long.MAX_VALUE;

            cache[cacheIdx++] = numLeft <= numRight ? arr[leftIdx++] : arr[rightIdx++];
        }

        System.arraycopy(cache, 0, arr, left, right - left + 1);

        return ret;
    }


    public static void main(String[] args)
    {
        int[] nums = {-2, 5, -1};
        int lower = -2;
        int upper = 2;
        int ret = countRangeSum(nums, lower, upper);
        System.out.println(ret);
    }
}

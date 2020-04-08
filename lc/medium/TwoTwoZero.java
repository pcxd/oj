package medium;

import java.util.HashMap;
import java.util.Map;


public class TwoTwoZero
{
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t)
    {
        if(nums == null || nums.length == 0 || k <= 0 || t < 0)
            return false;

        Map<Integer, Integer> buckets = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
            int bucketID = getBucketID(nums[i], k);
            if(buckets.containsKey(bucketID))
                return true;
            else if(buckets.containsKey(bucketID - 1) && Math
                    .abs(buckets.get(bucketID - 1) - nums[i]) <= t)
                return true;
            else if(buckets.containsKey(bucketID + 1) && Math
                    .abs(buckets.get(bucketID + 1) - nums[i]) <= t)
                return true;

            buckets.put(bucketID, nums[i]);
            if(i >= k)
                buckets.remove(getBucketID(nums[i - k], k));
        }

        return false;
    }

    private static int getBucketID(int num, int k)
    {
        if(num < 0)
            return num / k - 1;

        return num / k;
    }


    public static void main(String[] args)
    {
        int[] nums = {1, 0, 1, 1};
        int k = 1;
        int t = 2;
        boolean ret = containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(ret);
    }
}

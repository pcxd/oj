package hard;

import java.util.ArrayDeque;
import java.util.Deque;


public class OneFourTwoFive
{
    public static int constrainedSubsetSum(int[] nums, int k)
    {
        if(nums == null || nums.length == 0)
            return 0;

        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < n; i++)
        {
            while(!q.isEmpty() && i - q.peekFirst() > k)
                q.pollFirst();

            int prevMaxSum = q.isEmpty() ? Integer.MIN_VALUE : dp[q.peekFirst()];
            dp[i] = prevMaxSum > 0 ? prevMaxSum + nums[i] : nums[i];

            while(!q.isEmpty() && dp[i] > dp[q.peekLast()])
                q.pollLast();
            q.offerLast(i);
        }

        int ret = Integer.MIN_VALUE;
        for(int i : dp)
            ret = Math.max(ret, i);

        return ret;
    }


    public static void main(String[] args)
    {
        int[] nums = new int[]{10, 2, -10, 5, 20};
        int k = 2;
        int ret = constrainedSubsetSum(nums, k);
        System.out.println(ret);
    }
}

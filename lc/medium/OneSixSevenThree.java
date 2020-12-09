package lc.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


public class OneSixSevenThree
{
    public static int[] mostCompetitive(int[] nums, int k)
    {
        if(nums == null || nums.length == 0)
            return new int[0];

        int[] ret = new int[k];
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++)
        {
            while(!q.isEmpty() && q.peekLast() > nums[i])
                q.pollLast();
            q.offerLast(nums[i]);

            if(i >= nums.length - k)
                ret[i - (nums.length - k)] = q.pollFirst();
        }

        return ret;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{3, 5, 2, 6};
        int k = 2;
        int[] ret = mostCompetitive(nums, k);
        System.out.println(Arrays.toString(ret));
    }
}

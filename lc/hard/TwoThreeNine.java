package hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


public class TwoThreeNine
{
    public static int[] maxSlidingWindow(int[] nums, int k)
    {
        if(nums == null || nums.length == 0)
            return new int[0];

        LinkedList<Integer> dq = new LinkedList<>();
        int[] ret = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length; i++)
        {
            while(!dq.isEmpty() && nums[i] > nums[dq.getLast()])
                dq.removeLast();

            dq.addLast(i);

            if(i >= k - 1)
            {
                if(dq.getFirst() < i - k + 1)
                    dq.removeFirst();
                ret[i - k + 1] = nums[dq.getFirst()];
            }
        }

        return ret;
    }


    public static void main(String[] args)
    {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] ret = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ret));
    }
}

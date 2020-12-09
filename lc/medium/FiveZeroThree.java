package lc.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


public class FiveZeroThree
{
    public static int[] nextGreaterElements(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return new int[0];

        int n = nums.length;
        int[] circleNums = new int[n * 2];
        for(int i = 0; i < circleNums.length; i++)
            circleNums[i] = nums[i % n];

        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = circleNums.length - 1; i >= 0; i--)
        {
            while(!stack.isEmpty() && circleNums[i] >= stack.peek())
                stack.pop();

            int val = stack.isEmpty() ? -1 : stack.peek();
            if(ret[i % n] == -1)
                ret[i % n] = val;

            stack.push(circleNums[i]);
        }

        return ret;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{1, 2, 1};
        int[] ret = nextGreaterElements(nums);
        System.out.println(Arrays.toString(ret));
    }
}

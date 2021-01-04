package medium;

import java.util.ArrayDeque;
import java.util.Deque;


public class FourFiveSix
{
    public static boolean find132pattern(int[] nums)
    {
        if(nums == null || nums.length < 3)
            return false;

        int n = nums.length;
        int[] preMin = new int[n];
        preMin[0] = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++)
            preMin[i] = Math.min(preMin[i - 1], nums[i - 1]);

        Deque<Integer> stack = new ArrayDeque<>();
        int third = Integer.MIN_VALUE;
        for(int i = n - 1; i > 0; i--)
        {
            while(!stack.isEmpty() && stack.peek() < nums[i])
                third = stack.pop();
            stack.push(nums[i]);

            if(preMin[i] < third)
                return true;
        }

        return false;
    }


    public static void main(String[] args)
    {
        int[] nums = {1, 3, 2, 4, 5, 6, 7, 8, 9, 10};
        boolean ret = find132pattern(nums);
        System.out.println(ret);
    }
}

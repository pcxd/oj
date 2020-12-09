package lc.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;


public class FourFiveSix
{
    public static boolean find132pattern(int[] nums)
    {
        if(nums == null || nums.length < 3)
            return false;

        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(nums[0]);
        for(int i = 1; i < nums.length; i++)
        {
            for(int j = stack.size() - 1; j >= 1; j -= 2)
            {
                int a = stack.get(j);
                int b = stack.get(j - 1);
                if(nums[i] > a && nums[i] < b)
                    return true;
            }

            if(stack.size() % 2 == 1 && nums[i] < stack.peek())
                stack.pop();
            if(stack.size() % 2 == 0 && nums[i] > stack.peek())
                stack.pop();

            stack.push(nums[i]);
        }

        return false;
    }


    public static void main(String[] args)
    {
        int[] nums = {-2, 1, 2, -2, 1, 2};
        boolean ret = find132pattern(nums);
        System.out.println(ret);
    }

}

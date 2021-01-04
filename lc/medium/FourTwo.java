package medium;

import java.util.ArrayDeque;
import java.util.Deque;


public class FourTwo
{
    public static int trap(int[] height)
    {
        if(height == null || height.length < 2)
            return 0;

        int ans = 0;

        int i = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        while(i < height.length)
        {
            if(stack.isEmpty() || height[i] <= height[stack.peek()])
            {
                stack.push(i);
                i++;
            }
            else
            {
                int bottomIdx = stack.pop();
                if(stack.isEmpty())
                    continue;
                int leftIdx = stack.peek();
                int rightIdx = i;
                ans += (Math.min(height[leftIdx],
                        height[rightIdx]) - height[bottomIdx]) * (rightIdx - leftIdx - 1);
            }
        }

        return ans;
    }

    public static void main(String[] args)
    {
        int[] height = {4, 2, 0, 3, 2, 5};
        int ans = trap(height);
        System.out.println(ans);
    }
}

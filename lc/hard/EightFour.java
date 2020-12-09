package lc.hard;

import java.util.ArrayDeque;
import java.util.Deque;


public class EightFour
{
    public static int largestRectangleArea(int[] heights)
    {
        if(heights == null || heights.length == 0)
            return 0;

        int[] right = new int[heights.length];
        Deque<Integer> rightStack = new ArrayDeque<>();
        for(int i = 0; i < heights.length; i++)
        {
            if(rightStack.isEmpty())
            {
                rightStack.push(i);
                continue;
            }

            if(heights[i] < heights[rightStack.peek()])
            {
                while(!rightStack.isEmpty() && heights[rightStack.peek()] > heights[i])
                    right[rightStack.pop()] = i - 1;
            }
            rightStack.push(i);
        }
        while(!rightStack.isEmpty())
            right[rightStack.pop()] = heights.length - 1;

        int[] left = new int[heights.length];
        Deque<Integer> leftStack = new ArrayDeque<>();
        for(int i = heights.length - 1; i >= 0; i--)
        {
            if(leftStack.isEmpty())
            {
                leftStack.push(i);
                continue;
            }

            if(heights[i] < heights[leftStack.peek()])
            {
                while(!leftStack.isEmpty() && heights[leftStack.peek()] > heights[i])
                    left[leftStack.pop()] = i + 1;
            }
            leftStack.push(i);
        }
        while(!leftStack.isEmpty())
            left[leftStack.pop()] = 0;


        int ret = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++)
            ret = Math.max(ret, heights[i] * (right[i] - left[i] + 1));

        return ret;
    }

    public static void main(String[] args)
    {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int ret = largestRectangleArea(heights);
        System.out.println(ret);
    }
}

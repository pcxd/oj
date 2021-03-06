package hard;

import java.util.ArrayDeque;
import java.util.Deque;


public class EightFour
{
    public static int largestRectangleArea(int[] heights)
    {
        if(heights == null || heights.length == 0)
            return 0;

        int n = heights.length;
        int[] hs = new int[n + 1];
        for(int i = 0; i < n; i++)
            hs[i] = heights[i];
        hs[n] = 0;

        int ret = 0;
        Deque<Integer> stack = new ArrayDeque<>();  // mono ascend stack
        for(int i = 0; i < n; i++)
        {
            while(!stack.isEmpty() && hs[i] <= hs[stack.peekLast()])
            {
                int end = i;
                int height = hs[stack.pollLast()];
                int start = stack.isEmpty() ? -1 : stack.peekLast();
                int len = end - start - 1;
                ret = Math.max(ret, height * len);
            }

            stack.offerLast(i);
        }

        return ret;
    }


    public static void main(String[] args)
    {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int ret = largestRectangleArea(heights);
        System.out.println(ret);
    }
}

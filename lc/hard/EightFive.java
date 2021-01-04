package hard;

import java.util.ArrayDeque;
import java.util.Deque;


public class EightFive
{
    public static int maximalRectangle(char[][] matrix)
    {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int H = matrix.length;
        int W = matrix[0].length;
        int[] buff = new int[W];

        int ret = 0;
        for(int h = 0; h < H; h++)
        {
            for(int w = 0; w < W; w++)
            {
                if(matrix[h][w] == '1')
                    buff[w] += matrix[h][w] - '0';
                else
                    buff[w] = 0;
            }

            int buffRet = largestRectangleArea(buff);
            ret = Math.max(ret, buffRet);
        }

        return ret;
    }


    private static int largestRectangleArea(int[] heights)
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
        for(int i = 0; i <= n; i++)
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
        char[][] matrix = {{'0', '1'}, {'1', '0'}};
        int ret = maximalRectangle(matrix);
        System.out.println(ret);
    }
}

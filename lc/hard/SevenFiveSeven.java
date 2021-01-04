package hard;

import java.util.Arrays;


public class SevenFiveSeven
{
    public static int intersectionSizeTwo(int[][] intervals)
    {
        if(intervals == null || intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (a, b)->a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]);

        int left = intervals[0][1] - 1;
        int right = intervals[0][1];
        int ret = 2;
        for(int i = 1; i < intervals.length; i++)
        {
            int[] cur = intervals[i];
            if(left < cur[0] && cur[0] <= right)
            {
                ret += 1;
                left = right;
                right = cur[1];
            }
            else if(cur[0] > right)
            {
                ret += 2;
                left = cur[1] - 1;
                right = cur[1];
            }
        }

        return ret;
    }


    public static void main(String[] args)
    {
        int[][] intervals = {{1, 3}, {4, 9}, {0, 10}, {6, 7}, {1, 2}, {0, 6}, {7, 9}, {0, 1}, {2, 5}, {6, 8}};
        int ret = intersectionSizeTwo(intervals);
        System.out.println(ret);
    }
}

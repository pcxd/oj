package hard;

import java.util.ArrayList;
import java.util.List;


public class OneThreeTwoSix
{
    public static int minTaps(int n, int[] ranges)
    {
        if(ranges == null || ranges.length == 0)
            return -1;

        List<int[]> areas = new ArrayList<>();
        for(int i = 0; i < ranges.length; i++)
        {
            if(ranges[i] == 0)
                continue;
            int[] area = new int[2];
            area[0] = i - ranges[i];
            area[1] = i + ranges[i];
            areas.add(area);
        }
        areas.sort((a, b)->
        {
            if(a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        int ret = 0;
        int pos = 0;
        int tapIdx = 0;
        while(pos < n)
        {
            int end = Integer.MIN_VALUE;
            while(tapIdx < areas.size() && areas.get(tapIdx)[0] <= pos)
            {
                end = Math.max(end, areas.get(tapIdx)[1]);
                tapIdx++;
            }
            if(end == Integer.MIN_VALUE)
                return -1;

            ret++;
            pos = end;
        }

        return ret;
    }

    public static void main(String[] args)
    {
        int n = 7;
        int[] ranges = {1, 2, 1, 0, 2, 1, 0, 1};
        int ret = minTaps(n, ranges);
        System.out.println(ret);
    }

}

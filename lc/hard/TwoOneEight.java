package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;


public class TwoOneEight
{
    public static List<List<Integer>> getSkyline(int[][] buildings)
    {
        if(buildings == null || buildings.length == 0)
            return Collections.emptyList();

        List<int[]> points = new ArrayList<>();
        for(int[] building : buildings)
        {
            points.add(new int[]{building[0], -building[2]});
            points.add(new int[]{building[1], building[2]});
        }
        points.sort((a, b)->
        {
            if(a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        List<List<Integer>> ret = new ArrayList<>();
        PriorityQueue<Integer> heights = new PriorityQueue<>((a, b)->(b - a));
        heights.offer(0);
        int prevHeight = 0;
        for(int[] point : points)
        {
            if(point[1] < 0)
                heights.offer(Math.abs(point[1]));
            else
                heights.remove(point[1]);

            int curHeight = heights.peek();
            if(curHeight != prevHeight)
            {
                List<Integer> t = new ArrayList<>();
                t.add(point[0]);
                t.add(curHeight);
                ret.add(new ArrayList<>(t));
                prevHeight = curHeight;
            }
        }

        return ret;
    }
}

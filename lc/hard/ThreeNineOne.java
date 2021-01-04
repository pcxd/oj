package hard;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class ThreeNineOne
{
    public static boolean isRectangleCover(int[][] rectangles)
    {
        if(rectangles == null || rectangles.length == 0)
            return false;

        List<Integer> xPos = new ArrayList<>();
        List<Integer> yPos = new ArrayList<>();
        for(int[] r : rectangles)
        {
            xPos.add(r[0]);
            xPos.add(r[2]);
            yPos.add(r[1]);
            yPos.add(r[3]);
        }
        List<Integer> xUniquePos = unique(xPos);
        List<Integer> yUniquePos = unique(yPos);

        Map<Integer, Integer> xPosToIdx = new HashMap<>();
        Map<Integer, Integer> yPosToIdx = new HashMap<>();
        for(int i = 0; i < xUniquePos.size(); i++)
            xPosToIdx.put(xUniquePos.get(i), i);
        for(int i = 0; i < yUniquePos.size(); i++)
            yPosToIdx.put(yUniquePos.get(i), i);

        int H = yUniquePos.size();
        int W = xUniquePos.size();
        int[][] area = new int[H][W];
        for(int[] r : rectangles)
        {
            int x1 = xPosToIdx.get(r[0]);
            int y1 = yPosToIdx.get(r[1]);
            int x2 = xPosToIdx.get(r[2]);
            int y2 = yPosToIdx.get(r[3]);

            for(int y = y1; y < y2; y++)
                for(int x = x1; x < x2; x++)
                    area[y][x]++;
        }

        for(int h = 0; h < H - 1; h++)
            for(int w = 0; w < W - 1; w++)
                if(area[h][w] != 1)
                    return false;

        return true;
    }


    private static List<Integer> unique(List<Integer> pos)
    {
        Set<Integer> posSet = new TreeSet<>(pos);
        return new ArrayList<>(posSet);
    }


    public static void main(String[] args)
    {
        int[][] rectangles = {{1, 1, 3, 3}, {3, 1, 4, 2}, {1, 3, 2, 4}, {2, 2, 4, 4}};
        boolean ret = isRectangleCover(rectangles);
        System.out.println(ret);
    }
}

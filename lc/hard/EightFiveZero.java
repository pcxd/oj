package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class EightFiveZero
{
    static final int MOD = (int) Math.pow(10, 9) + 7;

    public static int rectangleArea(int[][] rectangles)
    {
        if(rectangles == null || rectangles.length == 0)
            return 0;

        List<Integer> xPos = new ArrayList<>();
        List<Integer> yPos = new ArrayList<>();
        for(int[] r : rectangles)
        {
            xPos.add(r[0]);
            xPos.add(r[2]);
            yPos.add(r[1]);
            yPos.add(r[3]);
        }

        List<Integer> xUniquePos = getUniquePos(xPos);
        List<Integer> yUniquePos = getUniquePos(yPos);
        Map<Integer, Integer> xPosToIdx = new HashMap<>();
        Map<Integer, Integer> xIdxToPos = new HashMap<>();
        Map<Integer, Integer> yPosToIdx = new HashMap<>();
        Map<Integer, Integer> yIdxToPos = new HashMap<>();
        for(int i = 0; i < xUniquePos.size(); i++)
        {
            xPosToIdx.put(xUniquePos.get(i), i);
            xIdxToPos.put(i, xUniquePos.get(i));
        }
        for(int i = 0; i < yUniquePos.size(); i++)
        {
            yPosToIdx.put(yUniquePos.get(i), i);
            yIdxToPos.put(i, yUniquePos.get(i));
        }

        int H = yUniquePos.size();
        int W = xUniquePos.size();
        boolean[][] area = new boolean[H][W];
        for(int[] r : rectangles)
        {
            int x1 = xPosToIdx.get(r[0]);
            int x2 = xPosToIdx.get(r[2]);
            int y1 = yPosToIdx.get(r[1]);
            int y2 = yPosToIdx.get(r[3]);

            for(int x = x1; x < x2; x++)
            {
                for(int y = y1; y < y2; y++)
                    area[y][x] = true;
            }
        }

        int ret = 0;
        for(int y = 0; y < H - 1; y++)
        {
            long py1 = yIdxToPos.get(y);
            long py2 = yIdxToPos.get(y + 1);
            for(int x = 0; x < W - 1; x++)
            {
                if(area[y][x])
                {
                    long px1 = xIdxToPos.get(x);
                    long px2 = xIdxToPos.get(x + 1);

                    ret = (int) ((ret + (py2 - py1) % MOD * (px2 - px1) % MOD) % MOD);
                }
            }
        }

        return ret;
    }


    private static List<Integer> getUniquePos(List<Integer> pos)
    {
        Set<Integer> posSet = new HashSet<>(pos);
        List<Integer> uniquePos = new ArrayList<>(posSet);
        uniquePos.sort((a, b)->a - b);

        return uniquePos;
    }

    public static void main(String[] args)
    {
        int[][] rectangles = new int[][]{{0, 0, 3, 3}, {2, 0, 5, 3}, {1, 1, 4, 4}};
        int ret = rectangleArea(rectangles);
        System.out.println(ret);
    }
}

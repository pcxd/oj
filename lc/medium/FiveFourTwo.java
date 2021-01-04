package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javafx.util.Pair;


public class FiveFourTwo
{
    static int[][] next = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int[][] updateMatrix(int[][] matrix)
    {
        if(matrix == null || matrix.length == 0)
            return new int[0][0];

        int H = matrix.length;
        int W = matrix[0].length;
        boolean[][] vis = new boolean[H][W];
        int[][] ret = new int[H][W];
        for(int i = 0; i < H; i++)
        {
            Arrays.fill(vis[i], false);
            Arrays.fill(ret[i], 0);
        }

        int levelNum = 0;
        Set<Pair<Integer, Integer>> level = new HashSet<>();
        for(int i = 0; i < H; i++)
            for(int j = 0; j < W; j++)
                if(matrix[i][j] == 0)
                {
                    level.add(new Pair<Integer, Integer>(i, j));
                    vis[i][j] = true;
                }

        while(!level.isEmpty())
        {
            levelNum++;
            Set<Pair<Integer, Integer>> nextLevel = new HashSet<>();
            for(Pair<Integer, Integer> node : level)
            {
                for(int i = 0; i < next.length; i++)
                {
                    int nh = node.getKey() + next[i][0];
                    int nw = node.getValue() + next[i][1];
                    if(0 <= nh && nh < H && 0 <= nw && nw < W && !vis[nh][nw])
                    {
                        vis[nh][nw] = true;
                        ret[nh][nw] = levelNum;
                        nextLevel.add(new Pair<>(nh, nw));
                    }
                }
            }

            level = nextLevel;
        }

        return ret;
    }
}

package contest.One78;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class FiveThreeFourSeven
{
    static int[][] next = {{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int minCost(int[][] grid)
    {
        if(grid == null || grid.length == 0)
            return 0;

        int H = grid.length;
        int W = grid[0].length;

        int[][] cost = new int[H][W];
        boolean[][] vis = new boolean[H][W];
        for(int i = 0; i < cost.length; i++)
        {
            Arrays.fill(cost[i], -1);
            Arrays.fill(vis[i], false);
        }

        cost[0][0] = 0;
        Set<Pair> layer = new HashSet<>();
        layer.add(new Pair(0, 0));
        int h = 0, w = 0;
        while(0 <= h && h < H && 0 <= w && w < W && !vis[h][w])
        {
            vis[h][w] = true;
            layer.add(new Pair(h, w));

            int nh = h + next[grid[h][w]][0];
            int nw = w + next[grid[h][w]][1];
            cost[nh][nw] = cost[h][w];

            h = nh;
            w = nw;
        }

        while(cost[H - 1][W - 1] == -1)
        {
            Set<Pair> nextLayer = new HashSet<>();
            for(Pair p : layer)
            {
                dfs(grid, p, cost, vis, nextLayer);
            }
            layer = nextLayer;
        }

        return cost[H - 1][W - 1];
    }

    private static void dfs(int[][] grid, Pair cur, int[][] cost, boolean[][] vis,
            Set<Pair> nextLayer)
    {
        int H = grid.length;
        int W = grid[0].length;

        for(int i = 1; i < next.length; i++)
        {
            int nh = cur.h + next[i][0];
            int nw = cur.w + next[i][1];
            if(0 <= nh && nh < H && 0 <= nw && nw < W && !vis[nh][nw])
            {
                nextLayer.add(new Pair(nh, nw));
                cost[nh][nw] = cost[cur.h][cur.w] + 1;
            }
        }
    }
}


class Pair
{
    public int h;
    public int w;

    public Pair(int h, int w)
    {
        this.h = h;
        this.w = w;
    }
}

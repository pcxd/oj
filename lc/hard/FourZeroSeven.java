package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class FourZeroSeven
{
    public static int trapRainWater2(int[][] heightMap)
    {
        if(heightMap == null)
            return 0;

        int H = heightMap.length;
        int W = heightMap[0].length;
        int[][] ans = new int[H][W];

        for(int i = 0; i < H; i++)
            ans[i] = trap(heightMap[i]);

        for(int j = 0; j < W; j++)
        {
            int[] height = new int[H];
            for(int i = 0; i < H; i++)
                height[i] = heightMap[i][j];

            int[] buff = trap(height);
            for(int i = 0; i < H; i++)
                ans[i][j] = Math.min(ans[i][j], buff[i]);
        }

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[2] - b[2]);
        boolean[][] vis = new boolean[H][W];
        for(int i = 0; i < H; i++)
            for(int j = 0; j < W; j++)
            {
                if(ans[i][j] != 0)
                    pq.offer(new int[]{i, j, heightMap[i][j] + ans[i][j]});
            }

        int ret = 0;
        while(!pq.isEmpty())
        {
            int[] cell = pq.poll();
            if(vis[cell[0]][cell[1]])
                continue;

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{cell[0], cell[1]});
            vis[cell[0]][cell[1]] = true;
            while(!queue.isEmpty())
            {
                int[] cur = queue.poll();
                if(ans[cur[0]][cur[1]] != 0)
                    ret += Math.max(0, cell[2] - heightMap[cur[0]][cur[1]]);
                for(int i = 0; i < dirs.length; i++)
                {
                    int nextH = cur[0] + dirs[i][0];
                    int nextW = cur[1] + dirs[i][1];
                    if(nextH <= 0 || nextH >= H - 1 || nextW <= 0 || nextW >= W - 1 || vis[nextH][nextW])
                        continue;
                    if(heightMap[nextH][nextW] > cell[2])
                    {
                        vis[nextH][nextW] = true;
                        continue;
                    }

                    vis[nextH][nextW] = true;
                    queue.offer(new int[]{nextH, nextW});
                }
            }
        }

        return ret;
    }

    private static int[] trap(int[] height)
    {
        if(height == null)
            return new int[0];

        int n = height.length;
        int[] ret = new int[n];
        Arrays.fill(ret, 0);
        int left = 0, right = n - 1;
        while(left < right)
        {
            if(height[left] <= height[right])
            {
                int next = left + 1;
                while(next < right && height[next] <= height[left])
                {
                    ret[next] = height[left] - height[next];
                    next++;
                }

                left = next;
            }
            else
            {
                int next = right - 1;
                while(next > left && height[next] < height[right])
                {
                    ret[next] = height[right] - height[next];
                    next--;
                }

                right = next;
            }
        }

        return ret;
    }


    public static void main(String[] args)
    {
        //        int[] height = {4, 2, 0, 3, 2, 5};
        //        int[] ret = trap(height);
        //        System.out.println(Arrays.toString(ret));
        //        System.out.println(Arrays.stream(ret).sum());
        int[][] heightMap = {{14, 17, 18, 16, 14, 16}, {17, 3, 10, 2, 3, 8}, {11, 10, 4, 7, 1, 7}, {13, 7, 2, 9, 8, 10}, {13, 1, 3, 4, 8, 6}, {20, 3, 3, 9, 10, 8}};
        int ret = trapRainWater(heightMap);
        System.out.println(ret);
    }


    public static int trapRainWater(int[][] heightMap)
    {
        if(heightMap == null || heightMap.length == 0)
            return 0;

        int H = heightMap.length;
        int W = heightMap[0].length;
        boolean[][] vis = new boolean[H][W];
        for(boolean[] visi : vis)
            Arrays.fill(visi, false);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[2]));
        for(int i = 0; i < H; i++)
        {
            pq.add(new int[]{i, 0, heightMap[i][0]});
            pq.add(new int[]{i, W - 1, heightMap[i][W - 1]});
            vis[i][0] = true;
            vis[i][W - 1] = true;
        }
        for(int j = 0; j < W; j++)
        {
            pq.add(new int[]{0, j, heightMap[0][j]});
            pq.add(new int[]{H - 1, j, heightMap[H - 1][j]});
            vis[0][j] = true;
            vis[H - 1][j] = true;
        }

        int ret = 0;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!pq.isEmpty())
        {
            int[] pos = pq.poll();
            for(int i = 0; i < dirs.length; i++)
            {
                int nextH = pos[0] + dirs[i][0];
                int nextW = pos[1] + dirs[i][1];
                if(nextH < 0 || nextH >= H || nextW < 0 || nextW >= W || vis[nextH][nextW])
                    continue;

                ret += Math.max(0, pos[2] - heightMap[nextH][nextW]);
                pq.offer(new int[]{nextH, nextW, Math.max(heightMap[nextH][nextW], pos[2])});
                vis[nextH][nextW] = true;
            }
        }

        return ret;
    }
}

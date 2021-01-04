package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class OneSixNineSeven
{
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries)
    {
        if(queries == null || queries.length == 0)
            return new boolean[0];

        Map<String, Integer> buff = new HashMap<>();
        for(int i = 0; i < queries.length; i++)
            buff.put(Arrays.toString(queries[i]), i);
        Arrays.sort(queries, Comparator.comparingInt(a->a[2]));
        Arrays.sort(edgeList, Comparator.comparingInt(a->a[2]));

        boolean[] ret = new boolean[queries.length];
        int curEdgeIdx = 0;
        DSU dsu = new DSU(n);
        for(int i = 0; i < queries.length; i++)
        {
            while(curEdgeIdx < edgeList.length && edgeList[curEdgeIdx][2] < queries[i][2])
            {
                int c = edgeList[curEdgeIdx][0];
                int p = edgeList[curEdgeIdx][1];
                dsu.union(c, p);
                curEdgeIdx++;
            }

            int pa = dsu.find(queries[i][0]);
            int pb = dsu.find(queries[i][1]);
            int origIdx = buff.get(Arrays.toString(queries[i]));
            ret[origIdx] = pa == pb;
        }

        return ret;
    }

    class DSU
    {
        private int[] parents;
        private int[] ranks;

        public DSU(int n)
        {
            parents = new int[n];
            ranks = new int[n];
            for(int i = 0; i < n; i++)
            {
                parents[i] = i;
                ranks[i] = 0;
            }
        }

        public int find(int x)
        {
            if(parents[x] != x)
                parents[x] = find(parents[x]);

            return parents[x];
        }

        public void union(int x, int y)
        {
            int px = find(x);
            int py = find(y);
            int rx = ranks[px];
            int ry = ranks[py];

            if(rx < ry)
                parents[px] = py;
            else if(rx > ry)
                parents[py] = px;
            else
            {
                parents[px] = py;
                ranks[py]++;
            }
        }
    }


    public static void main(String[] args)
    {
        OneSixNineSeven osns = new OneSixNineSeven();
        int n = 5;
        int[][] edgeList = {{0, 1, 10}, {1, 2, 5}, {2, 3, 9}, {3, 4, 13}};
        int[][] queries = {{0, 4, 14}, {1, 4, 13}};

        boolean[] ret = osns.distanceLimitedPathsExist(n, edgeList, queries);
        System.out.println(Arrays.toString(ret));

    }
}



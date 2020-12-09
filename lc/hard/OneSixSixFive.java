package lc.hard;

import java.util.Arrays;
import java.util.Comparator;


public class OneSixSixFive
{
    public static int minimumEffort(int[][] tasks)
    {
        if(tasks == null || tasks.length == 0)
            return 0;

        Arrays.sort(tasks, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] a, int[] b)
            {
                if(a[1] - a[0] != b[1] - b[0])
                    return (b[1] - b[0]) - (a[1] - a[0]);
                else
                    return b[1] - a[1];
            }
        });

        int n = tasks.length;
        int ans = tasks[n - 1][1];
        for(int i = n - 2; i >= 0; i--)
            ans = Math.max(ans + tasks[i][0], tasks[i][1]);

        return ans;
    }


    public static void main(String[] args)
    {
        int[][] tasks = new int[][]{{1, 1}, {1, 3}};
        int ans = minimumEffort(tasks);
        System.out.println(ans);
    }
}

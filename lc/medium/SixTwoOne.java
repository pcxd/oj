package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


public class SixTwoOne
{
    public static int leastInterval(char[] tasks, int n)
    {
        if(tasks == null || tasks.length == 0 || n < 0)
            return 0;

        Map<Character, Integer> taskCount = new HashMap<>();
        for(char t : tasks)
            taskCount.put(t, taskCount.getOrDefault(t, 0) + 1);

        List<Integer> counts = new ArrayList<>(taskCount.values());
        counts.sort((a, b)->b - a);
        int lastPart = 0;
        for(; lastPart < counts.size(); lastPart++)
            if(counts.get(lastPart).equals(counts.get(0)))
                break;

        int ret = Math.max((counts.get(0) - 1) * (n + 1) + lastPart, tasks.length);

        return ret;
    }


    public static void main(String[] args)
    {
        char[] tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 0;
        int ret = leastInterval(tasks, n);
        System.out.println(ret);
    }
}


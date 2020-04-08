package contest.One80;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import javafx.util.Pair;


public class FiveThreeFiveNine
{
    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k)
    {
        if(speed == null || speed.length != n || efficiency == null || efficiency.length != n || k < 0 || k > n)
            return 0;

        List<Pair<Integer, Integer>> es = new ArrayList<>();
        for(int i = 0; i < n; i++)
            es.add(new Pair<>(efficiency[i], speed[i]));
        es.sort((o1, o2)->o2.getKey() - o1.getKey());

        long ret = Long.MIN_VALUE;
        long totalSpeed = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < es.size(); i++)
        {
            if(pq.size() == k)
                totalSpeed -= pq.poll();

            pq.add(es.get(i).getValue());
            totalSpeed += es.get(i).getValue();

            ret = Math.max(ret, totalSpeed * es.get(i).getKey());
        }


        return (int) (ret % (1000000007));
    }


    public static void main(String[] args)
    {
        int n = 6;
        int[] speed = {2, 10, 3, 1, 5, 8};
        int[] efficiency = {5, 4, 3, 9, 7, 2};
        int k = 2;
        int ret = maxPerformance(n, speed, efficiency, k);
        System.out.println(ret);
    }
}

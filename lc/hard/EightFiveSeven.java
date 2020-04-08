package hard;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import javafx.util.Pair;


public class EightFiveSeven
{
    public static double mincostToHireWorkers(int[] quality, int[] wage, int K)
    {
        if(quality.length == 0 || wage.length == 0 || quality.length != wage.length || quality.length < K)
            return 0;

        final int N = quality.length;
        double[] rate = new double[N];
        for(int i = 0; i < rate.length; i++)
            rate[i] = (double) wage[i] / (double) quality[i];
        List<Pair<Double, Integer>> workers = new ArrayList<>();
        for(int i = 0; i < rate.length; i++)
            workers.add(new Pair<>(rate[i], quality[i]));
        workers.sort((o1, o2)->Double.compare(o1.getKey(), o2.getKey()));

        double qualitySum = 0, ret = Double.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->o2 - o1);
        for(int i = 0; i < workers.size(); i++)
        {
            if(pq.size() == K)
                qualitySum -= pq.poll();

            pq.add(workers.get(i).getValue());
            qualitySum += workers.get(i).getValue();

            if(pq.size() == K)
                ret = Math.min(ret, qualitySum * workers.get(i).getKey());
        }

        return ret;
    }


    public static void main(String[] args)
    {
        int[] quality = {3, 1, 10, 10, 1};
        int[] wage = {4, 8, 2, 2, 7};
        int K = 3;
        double ret = mincostToHireWorkers(quality, wage, K);
        System.out.println(ret);
    }
}

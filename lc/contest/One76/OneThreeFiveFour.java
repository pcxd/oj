package contest.One76;

import java.util.Arrays;
import java.util.PriorityQueue;


public class OneThreeFiveFour
{
    public static boolean isPossible(int[] target)
    {
        if(target == null || target.length == 0)
            return false;

        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->o2 - o1);
        for(int i = 0; i < target.length; i++)
        {
            pq.add(target[i]);
            sum += target[i];
        }

        while(sum > target.length)
        {
            int max = pq.poll();
            int rem = sum - max;

            int prev = max - rem;
            if(prev < 1)
                return false;

            prev = prev % max;
            pq.add(prev);

            sum = rem + prev;
        }

        return sum == target.length;
    }


    public static void main(String[] args)
    {
        int[] target = {1, 100000000};
        boolean ret = isPossible(target);
        System.out.println(ret);
    }
}

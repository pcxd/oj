package hard;

import java.util.PriorityQueue;


public class EightSevenEight
{
    public static int nthMagicalNumber(int N, int A, int B)
    {
        if(N <= 0)
            return -1;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(A);
        pq.add(B);
        int ret = -1;
        while(N-- > 0)
        {
            ret = pq.poll();
            if(!pq.contains(ret * A))
                pq.add(ret * A);
            if(!pq.contains(ret * B))
                pq.add(ret * B);
        }

        return ret;
    }


    public static void main(String[] args)
    {
        int N = 5;
        int A = 2;
        int B = 4;

        int ret = nthMagicalNumber(N, A, B);
        System.out.println(ret);
    }
}

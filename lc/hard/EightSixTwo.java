package hard;

import java.util.ArrayDeque;
import java.util.Deque;


public class EightSixTwo
{
    public static int shortestSubarray(int[] A, int K)
    {
        if(A == null || A.length == 0)
            return 0;

        int n = A.length;
        int[] sums = new int[n];
        sums[0] = A[0];
        for(int i = 1; i < n; i++)
            sums[i] = sums[i - 1] > 0 ? sums[i - 1] + A[i] : A[i];

        int ret = Integer.MAX_VALUE;

        int pos = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        while(pos < n)
        {
            if(sums[pos] < 0)
            {
                dq.clear();
                pos++;
                continue;
            }

            while(!dq.isEmpty() && A[pos] - sums[pos] > A[dq.peekLast()] - sums[dq.peekLast()])
                dq.pollLast();
            dq.offerLast(pos);

            while(!dq.isEmpty() && sums[pos] - sums[dq.peekFirst()] + A[dq.peekFirst()] >= K)
            {
                ret = Math.min(ret, pos - dq.peekFirst() + 1);
                dq.pollFirst();
            }

            pos++;
        }

        return ret == Integer.MAX_VALUE ? -1 : ret;
    }


    public static void main(String[] args)
    {
        int[] A = {2, -1, 2};
        int K = 3;
        int ret = shortestSubarray(A, K);
        System.out.println(ret);
    }
}

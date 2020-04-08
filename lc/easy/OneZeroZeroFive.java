package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class OneZeroZeroFive
{
    public static int largestSumAfterKNegations(int[] A, int K)
    {
        if(A == null || A.length == 0 || K < 0)
            return 0;

        List<Integer> negs = new ArrayList<>();
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < A.length; i++)
        {
            min = Math.min(min, Math.abs(A[i]));

            if(A[i] < 0)
                negs.add(A[i]);
            else
                sum += A[i];
        }

        Collections.sort(negs);

        for(int i = 0; i < negs.size(); i++)
        {
            if(i < K)
                sum += Math.abs(negs.get(i));
            else
                sum += negs.get(i);
        }

        if(K > negs.size())
        {
            int rem = K - negs.size();
            if(rem % 2 == 1)
                sum -= 2 * min;
        }

        return sum;
    }


    public static void main(String[] args)
    {
        int[] A = {4, 2, 3};
        int K = 1;
        int ret = largestSumAfterKNegations(A, K);
        System.out.println(ret);
    }
}

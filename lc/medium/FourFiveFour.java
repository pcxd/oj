package medium;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;


public class FourFiveFour
{
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D)
    {
        Map<Integer, Integer> numCountA = new HashMap<>();
        Map<Integer, Integer> numCountB = new HashMap<>();
        for(int i = 0; i < A.length; i++)
            for(int j = 0; j < B.length; j++)
            {
                int sum = A[i] + B[j];
                numCountA.put(sum, numCountA.getOrDefault(sum, 0) + 1);
            }
        for(int i = 0; i < C.length; i++)
            for(int j = 0; j < D.length; j++)
            {
                int sum = C[i] + D[j];
                numCountB.put(sum, numCountB.getOrDefault(sum, 0) + 1);
            }

        int ret = 0;
        for(Map.Entry<Integer, Integer> item : numCountA.entrySet())
        {
            int val = item.getKey();
            if(numCountB.containsKey(-val))
                ret += item.getValue() * numCountB.get(-val);
        }

        return ret;
    }


    public static void main(String[] args)
    {
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};

        int ret = fourSumCount(A, B, C, D);
        System.out.println(ret);
    }
}

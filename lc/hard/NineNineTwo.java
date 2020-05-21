package lc.hard;

import java.util.HashMap;
import java.util.Map;


public class NineNineTwo
{
    public static int subarraysWithKDistinct(int[] A, int K)
    {
        if(A == null || A.length < K)
            return 0;

        int ret = atMostKDistinct(A, K) - atMostKDistinct(A, K - 1);

        return ret;
    }

    private static int atMostKDistinct(int[] A, int K)
    {
        int l = 0, ret = 0;

        Map<Integer, Integer> count = new HashMap<>();
        for(int r = 0; r < A.length; r++)
        {
            count.put(A[r], count.getOrDefault(A[r], 0) + 1);
            if(count.size() > K)
            {
                while(count.size() > K)
                {
                    count.put(A[l], count.get(A[l]) - 1);
                    if(count.get(A[l]) == 0)
                        count.remove(A[l]);
                    l++;
                }
            }

            ret += r - l + 1;
        }

        return ret;
    }


    public static void main(String[] args)
    {
        int[] A = {1, 2, 1, 3, 4};
        int K = 3;
        int ret = subarraysWithKDistinct(A, K);
        System.out.println(ret);
    }
}

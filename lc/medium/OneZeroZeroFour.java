package lc.medium;

public class OneZeroZeroFour
{
    public static int longestOnes(int[] A, int K)
    {
        if(A == null || A.length == 0)
            return 0;

        int ret = Math.min(A.length, K);
        int start = 0;
        while(start < A.length)
        {
            if(A[start] == 0)
            {
                start++;
                continue;
            }

            int cnt = 0;
            int end = start;
            for(; end < A.length; end++)
            {
                if(A[end] == 1)
                    continue;

                cnt++;
                if(cnt > K)
                {
                    cnt--;
                    break;
                }
            }

            int len = end - start + Math.min(K - cnt, start);
            ret = Math.max(ret, len);

            start++;
            while(start < A.length && A[start] == 1)
                start++;
        }

        return ret;
    }


    public static void main(String[] args)
    {
        int[] A = {1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1};
        int K = 9;
        int ret = longestOnes(A, K);
        System.out.println(ret);
    }
}

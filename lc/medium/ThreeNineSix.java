package lc.medium;

public class ThreeNineSix
{
    public static int maxRotateFunction(int[] A)
    {
        if(A == null || A.length == 0)
            return 0;

        int F0 = 0;
        int sum = 0;
        for(int i = 0; i < A.length; i++)
        {
            F0 += i * A[i];
            sum += A[i];
        }

        int N = A.length;
        int fCur = F0;
        int ret = fCur;
        for(int i = 1; i < A.length; i++)
        {
            int fNext = fCur - (N - 1) * A[N - i] + sum - A[N - i];
            ret = Math.max(ret, fNext);
            fCur = fNext;
        }

        return ret;
    }

    public static void main(String[] args)
    {
        int[] A = {4, 3, 2, 6};
        int ret = maxRotateFunction(A);
        System.out.println(ret);
    }
}

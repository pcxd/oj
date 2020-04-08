package hard;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;


public class OneOneEightSeven
{
    public static int makeArrayIncreasing(int[] arr1, int[] arr2)
    {
        if(arr1 == null || arr1.length == 0)
            return 0;

        TreeSet<Integer> buff = new TreeSet<>();
        for(int i : arr2)
            buff.add(i);

        int N = arr1.length;
        int[][] dp = new int[N + 1][N];
        for(int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], -1);
        dp[0][0] = arr1[0];
        dp[1][0] = buff.first() < arr1[0] ? buff.first() : -1;

        for(int j = 1; j < arr1.length; j++)
        {
            for(int i = 0; i <= j + 1; i++)
            {
                if(i == 0)
                {
                    dp[i][j] = dp[i][j - 1] != -1 && arr1[j] > arr1[j - 1] ? arr1[j] : -1;
                }
                else
                {
                    int va = Integer.MAX_VALUE;
                    int vb = Integer.MAX_VALUE;
                    if(dp[i][j - 1] != -1 && dp[i][j - 1] < arr1[j])
                        va = arr1[j];
                    if(dp[i - 1][j - 1] != -1)
                    {
                        Integer candVal = buff.ceiling(dp[i - 1][j - 1] + 1);
                        if(candVal != null)
                            vb = candVal;
                    }

                    int min = Math.min(va, vb);
                    dp[i][j] = min == Integer.MAX_VALUE ? -1 : min;
                }
            }
        }

        int ret = -1;
        for(int i = 0; i < dp.length; i++)
            if(dp[i][N - 1] != -1)
            {
                ret = i;
                break;
            }

        return ret;
    }


    public static void main(String[] args)
    {
        int[] arr1 = {1, 5, 3, 6, 7};
        int[] arr2 = {1, 3, 4};
        int ret = makeArrayIncreasing(arr1, arr2);
        System.out.println(ret);
    }
}

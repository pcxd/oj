package hard;

import java.util.Arrays;


public class OneThreeFive
{
    public static int candy(int[] ratings)
    {
        if(ratings == null || ratings.length == 0)
            return 0;

        int N = ratings.length;
        int[] left = new int[N];
        int[] right = new int[N];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for(int i = 1; i < N; i++)
            if(ratings[i] > ratings[i - 1])
                left[i] = left[i - 1] + 1;
        for(int i = N - 2; i >= 0; i--)
            if(ratings[i] > ratings[i + 1])
                right[i] = right[i + 1] + 1;

        int ans = 0;
        for(int i = 0; i < N; i++)
            ans += Math.max(left[i], right[i]);

        return ans;
    }

    public static void main(String[] args)
    {
        int[] ratings = {1, 2, 2};
        int ret = candy(ratings);
        System.out.println(ret);
    }
}

package gfg;

import java.util.Arrays;


public class SparseTable
{
    static int memo[][];

    private static void preprocess(int[] input)
    {
        int n = input.length;
        int H = input.length;
        int W = (int) (Math.log(n) / Math.log(2)) + 1;
        memo = new int[H][W];

        for(int i = 0; i < H; i++)
            memo[i][0] = input[i];

        for(int j = 1; (1 << j) <= n; j++)
        {
            for(int i = 0; (i + (1 << j) - 1) < n; i++)
            {
                if(memo[i][j - 1] < memo[i + (1 << (j - 1))][j - 1])
                    memo[i][j] = memo[i][j - 1];
                else
                    memo[i][j] = memo[i + (1 << (j - 1))][j - 1];
            }
        }
    }

    public static int query(int l, int r)
    {
        int interval = r - l + 1;
        int j = (int) (Math.log(interval) / Math.log(2));

        return Math.min(memo[l][j], memo[r - (1 << j) + 1][j]);
    }


    public static void main(String[] args)
    {
        int[] input = {7, 2, 3, 0, 5, 10, 3, 12, 18};
        preprocess(input);

        System.out.println(query(0, 4));
        System.out.println(query(4, 7));
        System.out.println(query(7, 8));
    }
}

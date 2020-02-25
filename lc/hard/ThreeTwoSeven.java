package hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class ThreeTwoSeven
{
    public static int countRangeSum(int[] nums, int lower, int upper)
    {
        int[] st = init(nums);

        int count = 0;
        for(int i = 0; i < (st.length + 1) / 2 + nums.length - 1; i++)
            if(lower <= st[i] && st[i] <= upper)
                count++;
        return count;
    }

    private static int[] init(int[] nums)
    {
        int n = 1;
        while(n < nums.length)
            n *= 2;

        int[] st = new int[2 * n - 1];
        Arrays.fill(st, 0);

        for(int i = 0; i < nums.length; i++)
        {
            int idx = n - 1 + i;
            st[idx] = nums[i];

            int pos = idx;
            while(pos != 0)
            {
                int p = (pos - 1) / 2;
                st[p] += nums[i];
                pos = p;
            }
        }

        return st;
    }

    private static int query(int[] st, int lower, int upper, int k, int l, int r)
    {
        if(lower > r || upper < l)
            return 0;
        if(lower <= l && upper >= r)
            return st[k];

        int left = query(st, lower, upper, 2 * k + 1, l, (l + r) / 2);
        int right = query(st, lower, upper, 2 * k + 2, (l + r) / 2 + 1, r);

        return left + right;
    }


    public static void main(String[] args)
    {
        int[] nums = {-2, 5, -1};
        int lower = -2;
        int upper = 2;
        int sum = countRangeSum(nums, lower, upper);
        System.out.println(sum);
    }
}

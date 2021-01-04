package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class ThreeOneFive
{
    static final int BASE = 10000 + 1;
    static int[] BIT = new int[2 * BASE];

    public static List<Integer> countSmaller(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return Collections.emptyList();

        Arrays.fill(BIT, 0);

        LinkedList<Integer> ret = new LinkedList<>();
        for(int i = nums.length - 1; i >= 0; i--)
        {
            ret.addFirst(sum(BASE + nums[i] - 1));
            update(BASE + nums[i], 1);
        }

        return ret;
    }

    private static int sum(int idx)
    {
        int ret = 0;
        while(idx > 0)
        {
            ret += BIT[idx];
            idx -= (idx & -idx);
        }

        return ret;
    }

    private static void update(int idx, int val)
    {
        while(idx < BIT.length)
        {
            BIT[idx] += val;
            idx += (idx & -idx);
        }
    }


    public static void main(String[] args)
    {
        int[] nums = {-1, -1};
        List<Integer> ret = countSmaller(nums);
        System.out.println(ret.toString());
    }
}


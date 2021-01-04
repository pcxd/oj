package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class OneThreeFourZero
{
    public static int maxJumps(int[] arr, int d)
    {
        if(arr == null || arr.length == 0)
            return 0;

        int n = arr.length;
        TreeMap<Integer, List<Integer>> buff = new TreeMap<>();
        for(int i = 0; i < n; i++)
        {
            if(!buff.containsKey(arr[i]))
                buff.put(arr[i], new ArrayList<>());
            buff.get(arr[i]).add(i);
        }

        int[] memo = new int[n];
        Arrays.fill(memo, Integer.MIN_VALUE);

        for(Map.Entry<Integer, List<Integer>> entry : buff.entrySet())
        {
            for(Integer pos : entry.getValue())
            {
                memo[pos] = 1;
                // left
                for(int i = 1; i <= d; i++)
                {
                    int nextPos = pos - i;
                    if(0 <= nextPos && memo[nextPos] != Integer.MIN_VALUE && arr[pos] > arr[nextPos])
                        memo[pos] = Math.max(memo[pos], memo[nextPos] + 1);
                    else
                        break;
                }
                // right
                for(int i = 1; i <= d; i++)
                {
                    int nextPos = pos + i;
                    if(nextPos < n && memo[nextPos] != Integer.MIN_VALUE && arr[pos] > arr[nextPos])
                        memo[pos] = Math.max(memo[pos], memo[nextPos] + 1);
                    else
                        break;
                }
            }
        }

        int ret = 0;
        for(int memoi : memo)
            ret = Math.max(ret, memoi);

        return ret;
    }


    public static void main(String[] args)
    {
        int[] arr = new int[]{66};
        int d = 1;
        int ret = maxJumps(arr, d);
        System.out.println(ret);
    }
}

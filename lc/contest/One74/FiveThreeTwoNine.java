package contest.One74;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class FiveThreeTwoNine
{
    public static int minSetSize(int[] arr)
    {
        if(arr == null || arr.length == 0)
            return 0;

        Map<Integer, Integer> intCount = new HashMap<>();
        for(int val : arr)
        {
            int curCount = intCount.getOrDefault(val, 0);
            intCount.put(val, curCount+1);
        }

        Object[] buff= intCount.values().toArray();
        int[] counts = new int[buff.length];
        for(int i = 0; i < buff.length; i++)
            counts[i] = (int)buff[i];
        Arrays.sort(counts);

        int ret = 0;
        int sum = 0;
        for(int i = counts.length-1; i >= 0; i--)
        {
            ret++;
            sum+= counts[i];
            if(sum >= arr.length/2)
                break;
        }

        return ret;
    }

    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int ret = minSetSize(arr);
        System.out.println(ret);
    }
}

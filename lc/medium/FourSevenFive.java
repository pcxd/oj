package medium;

import java.util.Arrays;


public class FourSevenFive
{
    public static int findRadius(int[] houses, int[] heaters)
    {
        if(houses == null || houses.length == 0)
            return 0;
        if(heaters == null || heaters.length == 0)
            return -1;

        int ret = 0;
        Arrays.sort(heaters);
        for(int h : houses)
        {
            int idx = Arrays.binarySearch(heaters, h);

            if(idx < 0)
            {
                int min = Integer.MAX_VALUE;
                idx = -(idx + 1);
                if(idx - 1 >= 0)
                    min = Math.min(min, Math.abs(h - heaters[idx - 1]));
                if(idx < heaters.length)
                    min = Math.min(min, Math.abs(h - heaters[idx]));

                ret = Math.max(ret, min);
            }

        }

        return ret;
    }


    public static void main(String[] args)
    {
        int[] hourse = {1, 2, 3, 4};
        int[] heaters = {1, 4};
        int ret = findRadius(hourse, heaters);
        System.out.println(ret);
    }
}

package lc.medium;

import java.util.Arrays;


public class FourZeroSix
{
    public static int[][] reconstructQueue(int[][] people)
    {
        if(people == null || people.length == 0)
            return new int[0][0];

        Arrays.sort(people, (a, b)->
        {
            if(a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });


        int[][] ret = new int[people.length][2];
        for(int i = 0; i < ret.length; i++)
            Arrays.fill(ret[i], -1);
        for(int i = 0; i < people.length; i++)
        {
            int cnt = 0;
            int idx = 0;
            for(; idx < ret.length; idx++)
            {
                if(ret[idx][0] == -1 || ret[idx][0] >= people[i][0])
                    cnt++;

                if(cnt > people[i][1])
                    break;
            }

            ret[idx] = people[i];
        }

        return ret;
    }


    public static void main(String[] args)
    {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] ret = reconstructQueue(people);
        for(int[] item : ret)
            System.out.println(Arrays.toString(item));
    }
}

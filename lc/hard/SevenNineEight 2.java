package hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import javafx.util.Pair;


public class SevenNineEight
{
    public static int bestRotation(int[] A)
    {
        if(A == null || A.length == 0)
            return 0;

        List<Pair<Integer, Integer>> bounds = new ArrayList<>();
        for(int i = 0; i < A.length; i++)
        {
            if(A[i] <= i)
            {
                bounds.add(new Pair<>(0, 1));
                bounds.add(new Pair<>(i - A[i] + 1, -1));
                bounds.add(new Pair<>(i + 1, 1));
                bounds.add(new Pair<>(A.length + 1, -1));
            }
            else
            {
                bounds.add(new Pair<>(i + 1, 1));
                bounds.add(new Pair<>(i + 1 + (A.length - A[i]), -1));
            }
        }
        bounds.sort((a, b)->a.getKey() - b.getKey());

        int ret = 0;
        int curPoint = 0;
        int maxPoint = Integer.MIN_VALUE;

        int pos = 0;
        while(pos < bounds.size())
        {
            int nextPos = pos;
            while(nextPos < bounds.size() && bounds.get(pos).getKey()
                    .equals(bounds.get(nextPos).getKey()))
            {
                curPoint += bounds.get(nextPos).getValue();
                nextPos++;
            }

            if(curPoint > maxPoint)
            {
                maxPoint = curPoint;
                ret = bounds.get(pos).getKey();
            }
            pos = nextPos;
        }

        return ret;
    }


    public static void main(String[] args)
    {
        int[] nums = {1, 3, 0, 2, 4};
        int ret = bestRotation(nums);
        System.out.println(ret);
    }
}

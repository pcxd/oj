package lc.hard;

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

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b)->a.getKey() - b.getKey());

        for(int i = 0; i < A.length; i++)
        {
            if(A[i] <= i)
            {
                pq.add(new Pair<>(0, 1));
                pq.add(new Pair<>(i - A[i] + 1, -1));
                pq.add(new Pair<>(i + 1, 1));
                pq.add(new Pair<>(A.length + 1, -1));
                System.out.println(i + " : " + 0 + "," + (i - A[i] + 1));
                System.out.println(i + " : " + (i + 1) + "," + (A.length + 1));
            }
            else
            {
                pq.add(new Pair<>(i + 1, 1));
                pq.add(new Pair<>(i + 1 + (A.length - A[i]), -1));
                System.out.println(i + " : " + (i + 1) + "," + (i + 1 + A.length - A[i]));
            }
        }

        System.out.println(pq.toString());

        int ret = 0;
        int curPoint = 0;
        int maxPoint = Integer.MIN_VALUE;
        for(int i = 0; i <= A.length + 1; i++)
        {
            while(!pq.isEmpty() && pq.peek().getKey() <= i)
            {
                Pair<Integer, Integer> bp = pq.poll();
                curPoint += bp.getValue();
            }
            System.out.println(i + "-" + curPoint);

            if(curPoint > maxPoint)
            {
                maxPoint = curPoint;
                ret = i;
            }
        }

        return ret;
    }

    public static void main(String[] args)
    {
        int[] A = {2, 3, 1, 4, 0};
        int ret = bestRotation(A);
        System.out.println(ret);
    }

    public static int bestRotation2(int[] A)
    {
        if(A == null || A.length == 0)
            return 0;

        int ret = 0;
        int maxPoint = Integer.MIN_VALUE;
        for(int k = 0; k < A.length; k++)
        {
            int point = 0;
            for(int i = 0; i < A.length; i++)
            {
                int rotateIdx = (i + A.length - k) % A.length;
                point += A[i] <= rotateIdx ? 1 : 0;
            }

            if(point > maxPoint)
            {
                maxPoint = point;
                ret = k;
            }
        }

        return ret;
    }
}

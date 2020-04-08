package hard;

import java.util.Map;
import java.util.TreeMap;


public class SevenThreeTwo
{
    public static void main(String[] args)
    {
        MyCalendarThree mct = new MyCalendarThree();
        System.out.println(mct.book(10, 20));
        System.out.println(mct.book(50, 60));
        System.out.println(mct.book(10, 40));
        System.out.println(mct.book(5, 15));
        System.out.println(mct.book(5, 10));
        System.out.println(mct.book(25, 55));
    }

}


class MyCalendarThree
{
    private Map<Integer, Integer> times;

    public MyCalendarThree()
    {
        this.times = new TreeMap<>();
    }

    public int book(int start, int end)
    {
        this.times.put(start, this.times.getOrDefault(start, 0) + 1);
        this.times.put(end, this.times.getOrDefault(end, 0) - 1);

        int cur = 0;
        int max = 0;
        for(Integer val : this.times.values())
        {
            cur += val;
            max = Math.max(max, cur);
        }

        return max;
    }
}


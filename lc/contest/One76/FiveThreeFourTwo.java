package contest.One76;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class FiveThreeFourTwo
{
    public static int maxEvents(int[][] input)
    {
        if(input == null)
            return 0;

        Event[] events = new Event[input.length];
        for(int i = 0; i < input.length; i++)
            events[i] = new Event(input[i][0], input[i][1]);

        Map<Integer, List<Event>> buff = new HashMap<>();
        Arrays.sort(events, new Comparator<Event>()
        {
            @Override
            public int compare(Event o1, Event o2)
            {
                if(o1.end == o2.end)
                    return o1.start - o2.start;

                return o1.end - o2.end;
            }
        });

        int cnt = 0;
        int day = 0;
        int i = 0;
        while(i < events.length)
        {
            if(events[i].start > day)
                day++;
            else if(events[i].end < day)
                i++;
            else
            {
                cnt++;
                i++;
                day++;
            }
        }

        return cnt;
    }


    public static void main(String[] args)
    {
        int[][] input = {{1, 2}, {1, 2}, {3, 3}, {1, 5}, {1, 5}};//{{1, 4}, {4, 4}, {2, 2}, {3, 4}, {1, 1}};
        int ret = maxEvents(input);
        System.out.println(ret);
    }
}


class Event
{
    public int start;
    public int end;

    public Event(int start, int end)
    {
        this.start = start;
        this.end = end;
    }
}

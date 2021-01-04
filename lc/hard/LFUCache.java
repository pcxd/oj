package hard;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;


public class LFUCache
{
    private int minFreq;
    private int capacity;
    private Map<Integer, Integer> data;
    private Map<Integer, Integer> cnt;
    private Map<Integer, LinkedHashSet<Integer>> freq;

    public LFUCache(int capacity)
    {
        this.capacity = capacity;
        this.minFreq = 0;
        data = new HashMap<>();
        cnt = new HashMap<>();
        freq = new HashMap<>();
    }

    public int get(int key)
    {
        if(!data.containsKey(key))
            return -1;

        int curCnt = cnt.get(key);
        int nextCnt = curCnt + 1;
        if(!freq.containsKey(nextCnt))
            freq.put(nextCnt, new LinkedHashSet<>());

        freq.get(curCnt).remove(key);
        freq.get(nextCnt).add(key);
        cnt.put(key, nextCnt);

        if(freq.get(minFreq).isEmpty())
        {
            minFreq++;
            freq.remove(minFreq);
        }

        return data.get(key);
    }

    public void put(int key, int value)
    {
        if(this.capacity <= 0)
            return;
        if(data.containsKey(key))
        {
            get(key);
            data.put(key, value);
        }
        else
        {
            if(data.size() == this.capacity)
            {
                int tbr = freq.get(minFreq).iterator().next();
                data.remove(tbr);
                cnt.remove(tbr);
                freq.get(minFreq).remove(tbr);
            }

            minFreq = 1;
            if(!freq.containsKey(minFreq))
                freq.put(minFreq, new LinkedHashSet<>());
            data.put(key, value);
            freq.get(minFreq).add(key);
            cnt.put(key, 1);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
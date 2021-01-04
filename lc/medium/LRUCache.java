package medium;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;


public class LRUCache
{
    /*
    private int capacity;
    private Map<Integer, DoubleLinkedNode> data;
    private DoubleLinkedList dll;

    public LRUCache(int capacity)
    {
        this.capacity = capacity;
        data = new HashMap<>();
        dll = new DoubleLinkedList();
    }

    public int get(int key)
    {
        if(!data.containsKey(key))
            return -1;

        DoubleLinkedNode curNode = data.get(key);
        dll.remove(curNode);
        dll.addFirst(curNode);

        return curNode.val;
    }

    public void put(int key, int value)
    {
        if(data.containsKey(key))
        {
            DoubleLinkedNode node = data.get(key);
            node.val = value;

            this.dll.remove(node);
            this.dll.addFirst(node);
        }
        else
        {
            if(data.size() == capacity)
            {
                DoubleLinkedNode tail = this.dll.removeTail();
                data.remove(tail.key);
            }
            DoubleLinkedNode node = new DoubleLinkedNode(key, value);
            data.put(key, node);
            this.dll.addFirst(node);
        }
    }*/


    private int capacity;
    Map<Integer, Integer> data;
    LinkedHashSet<Integer> lhs;

    public LRUCache(int capacity)
    {
        this.capacity = capacity;
        data = new HashMap<>();
        lhs = new LinkedHashSet<>();
    }

    public int get(int key)
    {
        if(!data.containsKey(key))
            return -1;

        lhs.remove(key);
        lhs.add(key);

        return data.get(key);
    }

    public void put(int key, int value)
    {
        if(data.containsKey(key))
        {
            data.put(key, value);
            lhs.remove(key);
            lhs.add(key);
        }
        else
        {
            if(data.size() == this.capacity)
            {
                Integer toBeRemoved = lhs.iterator().next();
                data.remove(toBeRemoved);
                lhs.remove(toBeRemoved);
            }

            data.put(key, value);
            lhs.add(key);
        }
    }


    public static void main(String[] args)
    {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }
}


class DoubleLinkedNode
{
    int key;
    int val;
    DoubleLinkedNode prev;
    DoubleLinkedNode next;

    public DoubleLinkedNode(int key, int val)
    {
        this.key = key;
        this.val = val;
        prev = null;
        next = null;
    }
}


class DoubleLinkedList
{
    private DoubleLinkedNode head;
    private DoubleLinkedNode tail;

    public DoubleLinkedList()
    {
        head = new DoubleLinkedNode(Integer.MIN_VALUE, Integer.MIN_VALUE);
        tail = new DoubleLinkedNode(Integer.MIN_VALUE, Integer.MIN_VALUE);

        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(DoubleLinkedNode dln)
    {
        dln.next = head.next;
        head.next.prev = dln;
        head.next = dln;
        dln.prev = head;
    }

    public DoubleLinkedNode remove(DoubleLinkedNode dln)
    {
        if(dln == null)
            return null;

        dln.prev.next = dln.next;
        dln.next.prev = dln.prev;
        dln.prev = null;
        dln.next = null;

        return dln;
    }

    public DoubleLinkedNode removeTail()
    {
        DoubleLinkedNode node = tail.prev;
        if(node.equals(head))
            return null;

        return this.remove(node);
    }
}
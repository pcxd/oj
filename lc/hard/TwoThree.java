package hard;

import java.util.PriorityQueue;

import base.ListNode;


public class TwoThree
{
    public static ListNode mergeKLists(ListNode[] lists)
    {
        if(lists.length == 0)
            return null;

        ListNode ret = new ListNode(-1);
        ListNode cur = ret;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((o1, o2)->o1.val - o2.val);
        for(ListNode head : lists)
            if(head != null)
                queue.add(head);

        while(!queue.isEmpty())
        {
            ListNode next = queue.poll();
            cur.next = next;
            cur = cur.next;

            if(next.next != null)
                queue.add(next.next);
        }

        return ret.next;
    }


    public static void main(String[] args)
    {

    }
}

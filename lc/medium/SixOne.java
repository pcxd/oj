package medium;

import base.ListNode;


public class SixOne
{
    public static ListNode rotateRight(ListNode head, int k)
    {
        if(head == null || head.next == null)
            return head;

        ListNode fakeHead = new ListNode(-1);
        int cnt = 0;
        ListNode p = head;
        while(p != null)
        {
            p = p.next;
            cnt++;
        }
        k = k % cnt;

        ListNode left = head;
        ListNode right = head;
        while(k-- > 0)
            right = right.next;

        while(right.next != null)
        {
            left = left.next;
            right = right.next;
        }

        right.next = head;
        ListNode ret = left.next;
        left.next = null;

        return ret;
    }
}

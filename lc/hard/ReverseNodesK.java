package hard;

import base.ListNode;


public class ReverseNodesK
{
    public static ListNode reverseKGroup(ListNode head, int k)
    {
        int count = 0;
        ListNode tmp = head;
        while(tmp != null)
        {
            count++;
            tmp = tmp.next;
        }
        if(count < k)
            return head;

        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;

        ListNode preLast = fakeHead;
        ListNode end = head;
        ListNode cur = head.next;

        count = count / k;
        while(count != 0)
        {
            for(int i = 1; i < k; i++)
            {
                end.next = cur.next;
                cur.next = preLast.next;
                preLast.next = cur;

                cur = end.next;
            }

            count--;

            preLast = end;
            if(preLast.next != null)    // if k is the same as ListNode size, preLast.next will be null
            {
                end = preLast.next;
                cur = end.next;
            }
        }

        return fakeHead.next;
    }
}

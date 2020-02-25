package medium;

import java.util.Arrays;
import java.util.Collections;

import base.ListNode;


public class SevenTwoFive
{
    public static ListNode[] splitListToParts(ListNode root, int k)
    {
        if(k <= 0)
            return new ListNode[0];

        int count = 0;
        ListNode cur = root;
        while(cur != null)
        {
            count++;
            cur = cur.next;
        }

        int avg = count / k;
        int rem = count % k;
        int[] size = new int[k];
        Arrays.fill(size, 0, rem, avg + 1);
        Arrays.fill(size, rem, size.length, avg);

        cur = root;
        ListNode[] ret = new ListNode[k];
        for(int i = 0; i < k; i++)
        {
            if(size[i] == 0)
                ret[i] = null;
            else
            {
                ret[i] = cur;
                int step = size[i];
                while(step-- > 1)
                    cur = cur.next;

                ListNode nextHead = cur.next;
                cur.next = null;
                cur = nextHead;
            }
        }

        return ret;
    }
}

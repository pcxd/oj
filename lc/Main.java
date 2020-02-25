import base.ListNode;
import hard.ReverseNodesK;


public class Main
{
    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;


        int k = 5;
        ListNode ret = ReverseNodesK.reverseKGroup(head, k);
        ListNode tmp = ret;
        while(tmp != null)
        {
            System.out.println(tmp.val);

            tmp = tmp.next;
        }
    }
}

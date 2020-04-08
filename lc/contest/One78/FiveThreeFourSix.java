package contest.One78;

import java.util.HashSet;
import java.util.Set;

import base.ListNode;
import base.TreeNode;


public class FiveThreeFourSix
{
    public static boolean isSubPath(ListNode head, TreeNode root)
    {
        if(head == null || root == null)
            return false;

        Set<TreeNode> layer = new HashSet<>();
        layer.add(root);
        while(!layer.isEmpty())
        {
            Set<TreeNode> nextLayer = new HashSet<>();
            for(TreeNode node : layer)
            {
                if(isValidPath(head, node))
                    return true;

                if(node.left != null)
                    nextLayer.add(node.left);
                if(node.right != null)
                    nextLayer.add(node.right);
            }

            layer = nextLayer;
        }

        return false;
    }

    private static boolean isValidPath(ListNode head, TreeNode cur)
    {
        if(head == null)
            return true;
        else if(cur == null)
            return false;

        if(head.val == cur.val)
        {
            if(isValidPath(head.next, cur.left))
                return true;
            if(isValidPath(head.next, cur.right))
                return true;
        }

        return false;
    }
}

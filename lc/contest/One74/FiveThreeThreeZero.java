package contest.One74;


import java.util.LinkedList;


public class FiveThreeThreeZero
{
    private static long MOD = (long) Math.pow(10, 9) + 7;

    public static int maxProduct(TreeNode root)
    {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.val;

        long max = -1;
        LongNode longRoot = new LongNode(-1);
        long treeSum = calcNodeSum(root, longRoot);

        LinkedList<LongNode> queue = new LinkedList<>();
        queue.add(longRoot);
        while(!queue.isEmpty())
        {
            LongNode curNode = queue.pop();
            if(curNode.left != null)
            {
                long remSum = treeSum-curNode.left.val;
                long leftMax = ((curNode.left.val % MOD) *(remSum%MOD))%MOD;
                max = Math.max(max, leftMax);
                queue.add(curNode.left);
            }

            if(curNode.right != null)
            {
                long remSum = treeSum-curNode.right.val;
                long rightMax = ((curNode.right.val % MOD) *(remSum%MOD))%MOD;
                max = Math.max(max, rightMax);
                queue.add(curNode.right);
            }
        }

        return (int) max;
    }

    private static long calcNodeSum(TreeNode root, LongNode longRoot)
    {
        if(root == null)
            return 0;

        LongNode longLeft = new LongNode(-1);
        long leftSum = calcNodeSum(root.left, longLeft);
        longLeft.val = leftSum;

        LongNode longRight = new LongNode(-1);
        long rightSum = calcNodeSum(root.right, longRight);
        longRight.val = rightSum;

        longRoot.left = longLeft;
        longRoot.right = longRight;
        longRoot.val = (long)root.val + longLeft.val + longRight.val;

        return longRoot.val;
    }
}


class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x)
    {
        val = x;
    }
}

class LongNode
{
    long val;
    LongNode left;
    LongNode right;
    LongNode(long x)
    {
        val = x;
    }
}

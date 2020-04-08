package hard;

import base.TreeNode;


public class OneTwoFour
{
    private static int maxSum;

    public static int maxPathSum(TreeNode root)
    {
        if(root == null)
            return 0;

        maxSum = Integer.MIN_VALUE;
        getMaxSinglePath(root);

        return maxSum;
    }


    private static int getMaxSinglePath(TreeNode cur)
    {
        if(cur == null)
            return 0;

        int left = Math.max(0, getMaxSinglePath(cur.left));
        int right = Math.max(0, getMaxSinglePath(cur.right));

        maxSum = Math.max(maxSum, left + right + cur.val);

        return Math.max(left, right) + cur.val;
    }
}

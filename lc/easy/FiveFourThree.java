package easy;

import base.TreeNode;


public class FiveFourThree
{
    static int maxDepth;

    public static int diameterOfBinaryTree(TreeNode root)
    {
        if(root == null)
            return 0;

        maxDepth = Integer.MIN_VALUE;
        getChildDepth(root);

        return maxDepth;
    }

    private static int getChildDepth(TreeNode cur)
    {
        if(cur == null)
            return 0;

        int left = getChildDepth(cur.left);
        int right = getChildDepth(cur.right);

        maxDepth = Math.max(maxDepth, left + right);

        return Math.max(left, right) + 1;
    }
}

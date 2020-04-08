package medium;

import base.TreeNode;


public class FourFiveZero
{
    public static TreeNode deleteNode(TreeNode root, int key)
    {
        if(root == null)
            return root;

        if(root.val > key)
        {
            root.left = deleteNode(root.left, key);
        }
        else if(root.val < key)
        {
            root.right = deleteNode(root.right, key);
        }
        else
        {
            if(root.left != null)
                return root.right;
            else if(root.right == null)
                return root.left;
            else
            {
                TreeNode newRoot = root.left;
                TreeNode newRootParent = null;
                while(newRoot.right == null)
                {
                    newRootParent = newRoot;
                    newRoot = newRoot.right;
                }

                if(newRootParent == null)
                {
                    newRoot.right = root.right;
                    root.left = null;
                    root.right = null;
                    return newRoot;
                }

                newRootParent.right = newRoot.left;
                newRoot.left = root.left;
                newRoot.right = root.right;
                return newRoot;
            }
        }

        return root;
    }
}

package lc.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import base.TreeNode;


public class FiveOneFive
{
    public List<Integer> largestValues(base.TreeNode root)
    {
        if(root == null)
            return Collections.emptyList();


        Queue<base.TreeNode> level = new LinkedList<>();
        level.offer(root);

        List<Integer> ret = new ArrayList<>();
        Queue<base.TreeNode> nLevel = new LinkedList<>();
        while(!level.isEmpty())
        {
            int levelMax = Integer.MIN_VALUE;
            nLevel.clear();
            for(int i = 0; i < level.size(); i++)
            {
                base.TreeNode curNode = ((LinkedList<TreeNode>) level).get(i);
                levelMax = Math.max(levelMax, curNode.val);

                if(curNode.left != null)
                    nLevel.add(curNode.left);
                if(curNode.right != null)
                    nLevel.add(curNode.right);
            }

            ret.add(levelMax);
            level = nLevel;
        }

        return ret;
    }
}

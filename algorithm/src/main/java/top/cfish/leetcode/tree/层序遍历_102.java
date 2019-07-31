package top.cfish.leetcode.tree;

import javafx.util.Pair;
import top.cfish.algorithm.queue.ArrayQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * author: isisiwish
 * date: 2018/9/4 0004
 * time: 22:40
 * No.102
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/
 * todo ness
 */
public class 层序遍历_102
{
    private class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x)
        {
            val = x;
        }
    }
    
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
        {
            return res;
        }
        
        // 我们使用LinkedList做为先入先出队列
        ArrayQueue<Pair<TreeNode, Integer>> queue = new ArrayQueue<Pair<TreeNode, Integer>>();
        queue.enqueue(new Pair<TreeNode, Integer>(root, 0));
        
        while (!queue.isEmpty())
        {
            Pair<TreeNode, Integer> front = queue.dequeue();
            TreeNode node = front.getKey();
            int level = front.getValue();
            
            if (level == res.size())
            {
                res.add(new ArrayList<Integer>());
            }
            assert level < res.size();
            
            res.get(level).add(node.val);
            if (node.left != null)
            {
                queue.enqueue(new Pair<TreeNode, Integer>(node.left, level + 1));
            }
            if (node.right != null)
            {
                queue.enqueue(new Pair<TreeNode, Integer>(node.right, level + 1));
            }
        }
        
        return res;
    }
}

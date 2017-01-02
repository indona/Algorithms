import java.lang.*;
import java.util.*;

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x)
    {
        this.val = x;
        this.left=null;
        this.right=null;
    }
}

public class MaxPathSum
{
    public static int maxPathSum(TreeNode root)
    {
        if(root==null)
            return 0;

        int[] max=new int[1];
        max[0]=Integer.MIN_VALUE;
        _maxPathSum(root, max);
        return max[0];
    }

    public static int _maxPathSum(TreeNode node, int[] max)
    {
        if(node==null)
            return 0;

        //Recursively find the maxSum for each subtree
        int left=_maxPathSum(node.left, max);
        int right=_maxPathSum(node.right, max);

        //Check the maxValue for this current node. Is it the node's value or one of its subtree rooted at node.
        int current=Math.max(node.val, Math.max(node.val+left, node.val+right));

        //Update max- compare existing max, value of node and value of the path when assumed to be spread across the node.
        max[0]=Math.max(max[0], Math.max(current, left+node.val+right));
        return current;

    }

    public static void main(String args[])
    {
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(20);
        root.left.right=new TreeNode(1);
        root.right=new TreeNode(10);
        root.right.right=new TreeNode(-25);
        root.right.right.left=new TreeNode(3);
        root.right.right.right=new TreeNode(4);

        System.out.println("Max path sum: "+maxPathSum(root));

    }
}

import java.util.*;

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

public class HouseRobber3
{
    public static int rob(TreeNode root)
    {
        //The idea behind this problem is to use the tree structure to recurse down. On our way up, we maintain two pieces of information for each node.
        //The max amount the robber can rob if this node was not robbed and if this was robbed.
        //Eg.    3                   [10,16]
        //      / \                     / \
        //     2   3                [6,9]  [8,10]
        //    /\   /      =>         /\        /
        //   3  1 4             [6,3] [0,1]  [8,4]
        //  /    /               /            /
        //  6   8             [0,6]         [0,8]

        int[] result=robSubtree(root);
        return Math.max(result[0], result[1]);
    }

    public static int[] robSubtree(TreeNode root)
    {
        int[] result=new int[2];

        if(root==null)
            return result;

        int[] left=robSubtree(root.left);
        int[] right=robSubtree(root.right);

        //Result0 is the max we can rob if the current node is not robbed. It is the maximum sum that can be robbed from the previous level - this may be by robbing the next level or by not robbing the next level -
        //max(left[0], left[1]) + max(roght[0], right[1])
        result[0]=Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        //Result1 is when we rob this node and don't rob the next level nodes - root.val + left[0] + right[0]
        result[1]=root.val+left[0]+right[0];

        return result;
    }

    public static void main(String args[])
    {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(3);
        root.right=new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(1);
        root.right.left=new TreeNode(4);
        root.left.left.left=new TreeNode(6);
        root.right.left.left=new TreeNode(8);

        System.out.println("Max amount: "+rob(root));
    }
}

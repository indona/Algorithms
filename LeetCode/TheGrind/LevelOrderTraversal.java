import java.lang.*;
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

public class LevelOrderTraversal
{
    public static List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> traversal=new ArrayList<List<Integer>>();
        if(root==null)
            return traversal;

        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);

        while(!q.isEmpty())
        {
            List<Integer> level=new ArrayList<Integer>();
            int levelSize=q.size();

            for(int i=0;i<levelSize;i++)
            {
                TreeNode node=q.poll();
                level.add(node.val);

                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            traversal.add(level);
        }

        return traversal;
    }

    public static void main(String args[])
    {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.right.left=new TreeNode(5);
        root.right.left.left=new TreeNode(6);

        List<List<Integer>> traversal=new ArrayList<List<Integer>>();
        traversal=levelOrder(root);
        for(List<Integer> level: traversal)
            System.out.println(Arrays.toString(level.toArray()));
    }
}

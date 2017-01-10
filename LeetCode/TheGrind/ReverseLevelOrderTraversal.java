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

public class ReverseLevelOrderTraversal
{
    public static List<List<Integer>> reverseLevelOrder(TreeNode root)
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
                if(q.peek().left!=null)
                    q.add(q.peek().left);
                if(q.peek().right!=null)
                    q.add(q.peek().right);
                level.add(q.poll().val);
            }
            traversal.add(0, level);
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
        traversal=reverseLevelOrder(root);
        for(List<Integer> level: traversal)
            System.out.println(Arrays.toString(level.toArray()));
    }
}

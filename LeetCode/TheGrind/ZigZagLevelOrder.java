import java.util.*;
import java.lang.*;

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
}

public class ZigZagLevelOrder
{
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root)
    {
        //For this question we use a queue to explore the current level.
        //Use q.size() to limit the number of nodes explored in one level to the number of nodes in that level.
        //Always add the left sub-child first followed by the right.
        //To add the result in zig-zag manner, use a boolean variable and use it to determine the order of nodes.
        //This variable is toggled after each level.

        List<List<Integer>> result=new ArrayList<List<Integer>>();

        //Sanity
        if(root==null)
            return result;

        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        boolean order=true;

        while(!q.isEmpty())
        {
            //We find the current level's size before exploring the children - to ensure only nodes from this level are explored.
            List<Integer> currentLevel=new ArrayList<Integer>();
            int levelSize=q.size();

            for(int i=0;i<levelSize;i++)
            {
                TreeNode node=q.poll();

                //Insertion order of nodes is based on the boolean variable
                if(order)
                    currentLevel.add(node.val);
                else
                    currentLevel.add(0, node.val);

                //Add the sub-childs
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            //Add the current level traversal to the final result. And toggle the order.
            result.add(currentLevel);
            order=!order;
        }
        return result;
    }

    public static void main(String args[])
    {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);

        List<List<Integer>> result=new ArrayList<List<Integer>>();
        result=zigzagLevelOrder(root);

        for(List<Integer> level: result)
            System.out.println(Arrays.toString(level.toArray()));
    }
}

import java.util.*;
import java.lang.*;

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

public class VerticalOrderTraversal
{
    public static List<List<Integer>> verticalOrder(TreeNode root)
    {
        List<List<Integer>> result=new ArrayList<List<Integer>>();

        if(root==null)
            return result;

        Queue<TreeNode> nodeQueue=new LinkedList<TreeNode>();
        Queue<Integer> colQueue=new LinkedList<Integer>();
        Map<Integer, List<Integer>> map=new HashMap<Integer, List<Integer>>();

        nodeQueue.add(root);
        colQueue.add(0);
        int min=0;
        int max=0;

        while(!nodeQueue.isEmpty())
        {
            TreeNode node=nodeQueue.poll();
            int col=colQueue.poll();

            if(!map.containsKey(col))
                map.put(col, new ArrayList<Integer>());
            map.get(col).add(node.val);

            if(node.left!=null)
            {
                nodeQueue.add(node.left);
                colQueue.add(col-1);
                min=Math.min(min, col-1);
            }

            if(node.right!=null)
            {
                nodeQueue.add(node.right);
                colQueue.add(col+1);
                max=Math.max(max, col+1);
            }
        }

        for(int i=min;i<=max;i++)
            result.add(map.get(i));

        return result;
    }

    public static void main(String args[])
    {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(8);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(0);
        root.right.left=new TreeNode(1);
        root.right.right=new TreeNode(7);

        List<List<Integer>> result=new ArrayList<List<Integer>>();
        result=verticalOrder(root);

        for(List<Integer> list: result)
            System.out.println(Arrays.toString(list.toArray()));
    }
}

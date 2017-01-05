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

public class BinaryTreeClosestK
{
    public static List<Integer> closestKValues(TreeNode root, double target, int k)
    {
        //The idea is to maintain two stacks with the values closest to the given target in increasing and decreasing order.
        //To find the K closest elements, pop elements from each of the stacks add the closest one to the result set.
        //Optimization: Instead of doing two full in-order traversals, traverse only till the target for both fwd and reverse.
        List<Integer> result=new ArrayList<Integer>();
        Stack<Integer> s1=new Stack<Integer>();
        Stack<Integer> s2=new Stack<Integer>();

        inOrderTraversal(root, s1, false, target);
        inOrderTraversal(root, s2, true, target);
        System.out.println("Stack1: "+Arrays.toString(s1.toArray()));
        System.out.println("Stack2: "+Arrays.toString(s2.toArray()));


        while(k>0)
        {
            if(s1.isEmpty())
                    result.add(s2.pop());
            else if(s2.isEmpty())
                    result.add(s1.pop());
            else if(Math.abs(s1.peek()-target)<Math.abs(s2.peek()-target))
                result.add(s1.pop());
            else
                result.add(s2.pop());

            k--;
        }
        return result;
    }

    public static void inOrderTraversal(TreeNode root, Stack<Integer> s, boolean reverse, double target)
    {
        if(root==null)
            return;

        inOrderTraversal(!reverse ? root.left:root.right, s, reverse, target);

        //Early termination condition
        if((!reverse && root.val>=target) || (reverse && root.val<target))
            return;

        s.push(root.val);
        inOrderTraversal(!reverse ? root.right:root.left, s, reverse, target);
    }

    public static void main(String args[])
    {
        TreeNode root=new TreeNode(8);
        root.left=new TreeNode(1);
        
        List<Integer> result=new ArrayList<Integer>();
        result=closestKValues(root, 6.0, 1);
        System.out.println("4 closest: "+Arrays.toString(result.toArray()));
    }
}

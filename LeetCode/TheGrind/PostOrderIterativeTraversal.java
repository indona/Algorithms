import java.lang.*;
import java.util.*;

class Node
{
     int value;
     Node left;
     Node right;
     Node(int x) { value = x; }
}

public class PostOrderIterativeTraversal
{
    public static List<Integer> postOrderIterative(Node root)
    {
        List<Integer> traversal = new ArrayList<Integer>();
        if(root==null)
            return traversal;

        Stack<Node> stack=new Stack<Node>();
        stack.push(root);

        while(!stack.empty())
        {
            Node tos=stack.peek();
            if(tos.right==null && tos.left==null)
            {
                Node node=stack.pop();
                traversal.add(node.value);
            }
            else
            {
                if(tos.right!=null)
                {
                    stack.push(tos.right);
                    tos.right=null;
                }
                if(tos.left!=null)
                {
                    stack.push(tos.left);
                    tos.left=null;
                }
            }
        }

        return traversal;
    }

    public static void main(String args[])
    {
        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.left.left.right=new Node(6);
        root.right=new Node(3);

        List<Integer> traversal=new ArrayList<Integer>();

        traversal=postOrderIterative(root);
        System.out.println("Post-Order traversal: "+Arrays.toString(traversal.toArray()));
    }
}

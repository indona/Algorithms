import java.util.*;
import java.lang.*;

class IterativeTraversals
{
    public static List<Integer> inOrderIterative(Node root)
    {
        List<Integer> traversal = new ArrayList<Integer>();
        if(root==null)
            return traversal;

        Stack<Node> stack = new Stack<Node>();
        Node tos=root;

        while(!stack.empty() || tos!=null)
        {
            //Consume all left childs
            if(tos!=null)
            {
                stack.push(tos);
                tos=tos.left;
            }
            else //Print the current node and proceed to the right sub-child
            {
                Node node=stack.pop();
                traversal.add(node.value);
                tos=node.right;
            }
        }
        return traversal;
    }

    public static List<Integer> preOrderIterative(Node root)
    {
        List<Integer> traversal = new ArrayList<Integer>();
        if(root==null)
            return traversal;

        Stack<Node> stack = new Stack<Node>();
        Node tos=root;

        while(!stack.empty() || tos!=null)
        {
            if(tos!=null)
            {
                traversal.add(tos.value);
                stack.push(tos);
                tos=tos.left;
            }
            else
            {
                Node node=stack.pop();
                tos=node.right;
            }
        }
        return traversal;
    }

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

        traversal=inOrderIterative(root);
        System.out.println("In-Order traversal: "+Arrays.toString(traversal.toArray()));

        traversal.clear();
        traversal=preOrderIterative(root);
        System.out.println("Pre-Order traversal: "+Arrays.toString(traversal.toArray()));

        traversal.clear();
        traversal=postOrderIterative(root);
        System.out.println("Post-Order traversal: "+Arrays.toString(traversal.toArray()));
    }
}

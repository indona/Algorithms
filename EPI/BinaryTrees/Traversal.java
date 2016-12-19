import java.util.*;
import java.lang.*;

public class Traversal
{
    public static void preOrderTraversal(Node root, List<Integer> traversal) //Root-Left-Right
    {
        if(root==null)
            return;

        traversal.add(root.value);
        if(root.left!=null)
            inOrderTraversal(root.left, traversal);
        if(root.right!=null)
            inOrderTraversal(root.right, traversal);

        return;
    }

    public static void inOrderTraversal(Node root, List<Integer> traversal) //Left-Root-Right
    {
        if(root==null)
            return;

        if(root.left!=null)
            inOrderTraversal(root.left, traversal);
        traversal.add(root.value);
        if(root.right!=null)
            inOrderTraversal(root.right, traversal);

        return;
    }

    public static void postOrderTraversal(Node root, List<Integer> traversal) //Left-Right-Root
    {
        if(root==null)
            return;

        if(root.left!=null)
            inOrderTraversal(root.left, traversal);
        if(root.right!=null)
            inOrderTraversal(root.right, traversal);
        traversal.add(root.value);

        return;
    }

    public static void main(String args[])
    {
        Node root=new Node(314);
        root.left=new Node(6);
        root.left.left=new Node(271);
        root.left.right=new Node(561);
        root.left.left.left=new Node(28);
        root.left.left.right=new Node(0);
        root.left.right.right=new Node(3);
        root.left.right.right.left=new Node(17);
        root.right=new Node(6);
        root.right.left=new Node(2);
        root.right.left.right=new Node(1);
        root.right.left.right.left=new Node(401);
        root.right.left.right.left.right=new Node(641);
        root.right.left.right.right=new Node(257);
        root.right.right=new Node(271);
        root.right.right.right=new Node(28);

        List<Integer> preOrder=new ArrayList<Integer>();
        preOrderTraversal(root, preOrder);
        System.out.println("Pre-order: "+Arrays.toString(preOrder.toArray()));

        List<Integer> inOrder=new ArrayList<Integer>();
        inOrderTraversal(root, inOrder);
        System.out.println("In-order: "+Arrays.toString(inOrder.toArray()));

        List<Integer> postOrder=new ArrayList<Integer>();
        postOrderTraversal(root, postOrder);
        System.out.println("Post-order: "+Arrays.toString(postOrder.toArray()));
    }
}

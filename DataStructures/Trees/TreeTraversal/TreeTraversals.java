import java.util.*;

class Node
{
    int value;
    Node left;
    Node right;

    Node(int val)
    {
        this.value=val;
        this.right=null;
        this.left=null;
    }
}

class BinaryTree
{
    static Node root;

    BinaryTree(Node newNode)
    {
        root=newNode;
    }

    void addNode(Node parent, Node newNode)
    {
        if(root==null)
            root=newNode;
        else
        {
            if (parent.left==null)
                parent.left=newNode;
            else
                parent.right=newNode;
        }
    }
}

//Recursion
class InOrderTraversal
{
   ArrayList<Integer> traversal = new ArrayList<Integer>();

   public  ArrayList<Integer> inOrderTraversal(Node root)
   {
        if(root!=null)
            traverse(root);
        
        return traversal;
   }

   public void traverse(Node node)
   {
        if(node.left!=null)
            traverse(node.left);

        traversal.add(node.value);

        if(node.right!=null)
            traverse(node.right);
   }  
}

class LevelOrderTraversal
{
    ArrayList<Integer> traversal = new ArrayList<Integer>();

    public ArrayList<Integer> levelOrderTraversal(Node root)
    {
        if(root!=null)
        {
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);

            while(!queue.isEmpty())
            {
                Node currentNode = queue.poll();
                traversal.add(currentNode.value);
                
                if(currentNode.left!=null)
                    queue.add(currentNode.left);

                if(currentNode.right!=null)
                    queue.add(currentNode.right);
            }
        }
        return traversal;
    }
}

public class TreeTraversals
{
    public static void main(String args[])
    {
        Node root =  new Node(1);
        Node n1 = new Node(10);
        Node n2 = new Node(39);
        Node n3 = new Node(5);

        BinaryTree binaryTree = new BinaryTree(root);
        binaryTree.addNode(root, n1);
        binaryTree.addNode(root, n2);
        binaryTree.addNode(n1, n3);

        InOrderTraversal inOrder = new InOrderTraversal();
        LevelOrderTraversal levelOrder = new LevelOrderTraversal();

        ArrayList<Integer> result = new ArrayList<Integer>();

        result=inOrder.inOrderTraversal(root);
        System.out.println("In-Order traversal: "+Arrays.toString(result.toArray()));

        result=levelOrder.levelOrderTraversal(root);
        System.out.println("Level-Order traversal: "+Arrays.toString(result.toArray()));
    }
}

import java.util.*;
import java.lang.*;

public class ConstructBinaryTreeFromTraversals
{
    public static Node buildTree(int[] preorder, int[] inorder)
    {
        int pStart=0, pEnd=preorder.length-1;
        int iStart=0, iEnd=inorder.length-1;

        return _buildTree(preorder, pStart, pEnd, inorder, iStart, iEnd);
    }

    public static Node _buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd)
    {
        if(pEnd<pStart || iEnd<iStart)
            return null;

        int rootVal=preorder[pStart];
        Node root=new Node(rootVal);

        int leftSize=0;
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i]==rootVal)
            {
                leftSize=i;
                break;
            }
        }

        root.left = _buildTree(preorder, pStart+1, pStart+(leftSize-iStart), inorder, iStart, leftSize-1);
        root.right = _buildTree(preorder, pStart+(leftSize-iStart)+1, pEnd, inorder, leftSize+1, iEnd);

        return root;
    }

    public static void main(String args[])
    {
        int[] inorder={4, 2, 5, 1, 6, 7, 3, 8};
        int[] preorder={1, 2, 4, 5, 3, 7, 6, 8};

        Node root=buildTree(preorder, inorder);

        IterativeTraversals traverse = new IterativeTraversals();
        List<Integer> traversal=new ArrayList<Integer>();
        traversal=traverse.inOrderIterative(root);
        System.out.println("In-Order traversal: "+Arrays.toString(traversal.toArray()));
        traversal.clear();
        traversal=traverse.preOrderIterative(root);
        System.out.println("In-Order traversal: "+Arrays.toString(traversal.toArray()));
        traversal.clear();
        traversal=traverse.postOrderIterative(root);
        System.out.println("In-Order traversal: "+Arrays.toString(traversal.toArray()));
    }
}

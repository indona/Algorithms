//Refer to Node.java for structure of the node.
public class IsBalanced
{
    public static boolean isBalanced(Node root)
    {
        if (root==null)
        {
            root.height=0;
            return true;
        }

        boolean left=true, right=true;
        int lHeight=0, rHeight=0;

        if(root.left!=null)
        {
            left=isBalanced(root.left);
            lHeight=root.left.height;
        }
        if(root.right!=null)
        {
            right=isBalanced(root.right);
            rHeight=root.right.height;
        }

        root.height=Math.max(lHeight, rHeight)+1;
        if(Math.abs(lHeight-rHeight)>1)
            return false;
        else
            return (left && right);
    }

    public static void main(String args[])
    {
        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.left.left=new Node(5);
        root.right=new Node(3);

        boolean balanced=isBalanced(root);
        System.out.println("Balanced status: "+balanced);
    }
}

class DiameterOfBinaryTree
{
    public static int findDiameterOfBinaryTree(Node root)
    {
        if(root==null)
            return 0;

        //Recursively find diameter of left and right subtrees
        int lDiameter=findDiameterOfBinaryTree(root.left);
        int rDiameter=findDiameterOfBinaryTree(root.right);

        //Find maximum possible path length spanning the two subtrees
        int lHeight=findHeight(root.left);
        int rHeight=findHeight(root.right);

        //Return max
        return Math.max(lDiameter, Math.max(rDiameter, (lHeight+rHeight+1)));
    }

    public static int findHeight(Node node)
    {
        if(node==null)
            return 0;
        else
            return Math.max(findHeight(node.left), findHeight(node.right))+1;
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
        root.right=new Node(16);
        root.right.left=new Node(2);
        root.right.left.right=new Node(1);
        root.right.left.right.left=new Node(401);
        root.right.left.right.left.right=new Node(641);
        root.right.left.right.right=new Node(257);
        root.right.right=new Node(271);
        root.right.right.right=new Node(28);

        System.out.println("Diameter is: "+ findDiameterOfBinaryTree(root));
    }
}

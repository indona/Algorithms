class KthNodeInOrderTraversal
{
    public static Node findKthNodeInOrderTraversal(Node root, int k)
    {
        if(root==null || k<0 || k>root.numNodesInSubtree)
            return null;

        Node node=root;
        while(node!=null)
        {
            int left= (node.left==null ? 0:node.left.numNodesInSubtree);
            if(k>left+1) //Right subtree
            {
                k-=left+1;
                node=node.right;
            }
            else if(k==left+1) //Root
                return node;
            else //Left subtree
                node=node.left;
        }
        return null;
    }

    public static void main(String args[])
    {
        Node root=new Node(1, 7);
        root.left=new Node(2, 4);
        root.left.left=new Node(4, 3);
        root.left.left.left=new Node(5, 1);
        root.left.left.right=new Node(6, 1);
        root.right=new Node(3, 2);
        root.right.left=new Node(7, 1);

        Node result;

        for(int i=1;i<8;i++)
        {
            result=findKthNodeInOrderTraversal(root, i);
            System.out.println(i+" element in In-Order traversal: "+(result==null ? null:result.value));
        }
    }
}

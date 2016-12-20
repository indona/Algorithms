class InOrderSuccessor
{
    public static Node findInOrderSuccessor(Node node)
    {
        if(node==null)
            return null;

        if(node.right!=null) //Right subtree exists - find the leftmost child
        {
            node=node.right;
            while(node.left!=null)
                node=node.left;
        }
        else //No right subtree - find the final parent or an ancestor for which this node's parent is a left sub-child
        {
            while(node.parent!=null && node.parent.right==node)
                node=node.parent;
        }
        return node;
    }

    public static void main(String args[])
    {
        Node root=new Node(314, null);
        Node n1=new Node(6, root);
        root.left=n1;
        Node n2=new Node(271, n1);
        root.left.left=n2;
        Node n3=new Node(561, n1);
        root.left.right=n3;
        Node n4=new Node(28, n3);
        root.left.left.left=n4;
        Node n5=new Node(0, root);
        root.left.left.right=n5;

        Node result1=findInOrderSuccessor(n4);
        System.out.println("In order successor of "+n4.value+" is: "+result1.value);

        Node result2=findInOrderSuccessor(n1);
        System.out.println("In order successor of "+n1.value+" is: "+result2.value);

        Node result=findInOrderSuccessor(n3);
        System.out.println("In order successor of "+n3.value+" is: "+result.value);
    }
}

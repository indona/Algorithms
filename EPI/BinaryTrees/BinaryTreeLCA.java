public class BinaryTreeLCA
{
    static class Status
    {
        public int nodesFound;
        public Node ancestor;

        public Status(int nodesFound, Node ancestor)
        {
            this.nodesFound=nodesFound;
            this.ancestor=ancestor;
        }
    }

    public static Node lca(Node root, Node node1, Node node2)
    {
        if(root==null)
            return null;
        else
            return lcaHelper(root, node1, node2).ancestor;
    }

    public static Status lcaHelper(Node root, Node node1, Node node2)
    {
        if(root==null)
            return (new Status(0, null));

        Status left=lcaHelper(root.left, node1, node2);
        if(left.nodesFound==2)
            return left;

        Status right=lcaHelper(root.right, node1, node2);
        if(right.nodesFound==2)
            return right;

        int count=left.nodesFound+right.nodesFound;
        if(root==node1)
            count++;
        if(root==node2)
            count++;

        if(count==2)
            return (new Status(count, root));
        else
            return (new Status(count, null));
    }

    public static void main(String args[])
    {
        Node root=new Node(314);
        Node n1=new Node(6);
        root.left=n1;
        Node n2=new Node(271);
        root.left.left=n2;
        Node n3=new Node(561);
        root.left.right=n3;
        Node n4=new Node(28);
        root.left.left.left=n4;
        Node n5=new Node(0);
        root.left.left.right=n5;
        Node n6=new Node(3);
        root.left.right.right=n6;
        Node n7=new Node(17);
        root.left.right.right.left=n7;
        Node n8=new Node(6);
        root.right=n8;
        Node n9=new Node(2);
        root.right.left=n9;
        Node n10=new Node(1);
        root.right.left.right=n10;
        Node n11=new Node(401);
        root.right.left.right.left=n11;
        Node n12=new Node(641);
        root.right.left.right.left.right=n12;
        Node n13=new Node(257);
        root.right.left.right.right=n13;
        Node n14=new Node(271);
        root.right.right=n14;
        Node n15=new Node(28);
        root.right.right.right=n15;

        Node random1=new Node(10);
        Node random2=new Node(11);
        Node fakeRoot=new Node(10);

        Node result;
        result=lca(root, n5, n7);
        System.out.println("LCA of "+n5.value+" and "+n7.value+" : "+(result==null ? null:result.value));

        result=lca(root, n5, random1);
        System.out.println("LCA of "+n5.value+" and "+random1.value+" : "+(result==null ? null:result.value));

        result=lca(root, n12, n13);
        System.out.println("LCA of "+n12.value+" and "+n13.value+" : "+(result==null ? null:result.value));

        result=lca(root, random1, random2);
        System.out.println("LCA of "+random1.value+" and "+random2.value+" : "+(result==null ? null:result.value));

        result=lca(fakeRoot, n5, random1);
        System.out.println("LCA of "+n5.value+" and "+random1.value+" : "+(result==null ? null:result.value));

    }
}

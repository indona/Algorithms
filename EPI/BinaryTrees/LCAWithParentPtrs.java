class LCAWithParentPtrs
{
    public static int findDepth(Node root, Node node)
    {
        int depth=0;
        while(node!=root)
        {
            depth++;
            if(node.parent==null)
                return -1;
            else
              node=node.parent;
        }
        return depth+1;
    }

    public static Node lca(Node root, Node node1, Node node2)
    {
        if (root==null)
            return null;

        int depth1=findDepth(root, node1);
        int depth2=findDepth(root, node2);

        if(depth1==-1 || depth2==-1)
            return null;

        Node deeper=depth1>=depth2 ? node1:node2;
        Node shallower=depth1<depth2 ? node1:node2;

        int difference=Math.abs(depth1-depth2);
        while(difference--!=0)
            deeper=deeper.parent;

        while(deeper!=shallower)
        {
            deeper=deeper.parent;
            shallower=shallower.parent;
        }

        return deeper;
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

      Node random=new Node(10, null);
      Node fakeRoot=new Node(15, null);

      Node result;
      result=lca(root, n2, n4);
      System.out.println("Root: "+root.value+"| LCA of "+n2.value+" and "+n4.value+" : "+(result==null ? null:result.value));

      result=lca(root, n4, n5);
      System.out.println("Root: "+root.value+"| LCA of "+n4.value+" and "+n5.value+" : "+(result==null ? null:result.value));

      result=lca(root, n1, random);
      System.out.println("Root: "+root.value+"| LCA of "+n1.value+" and "+random.value+" : "+(result==null ? null:result.value));

      result=lca(fakeRoot, n1, n3);
      System.out.println("Root: "+fakeRoot.value+"| LCA of "+n1.value+" and "+n3.value+" : "+(result==null ? null:result.value));
    }
}

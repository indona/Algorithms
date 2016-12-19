class SumRootToLeaf
{
    public static int sumRootToLeaf(Node root, int base)
    {
        return _sumRootToLeaf(root, 0, base);
    }

    public static int _sumRootToLeaf(Node node, int partialSum, int base)
    {
        if(node==null)
          return 0;

        //If you want to consider the path as one number
        partialSum = (partialSum*base)+node.value;

        ////If you want to find the sum of all nodes
        //partialSum+=node.value;

        //Leaf
        if(node.left==null && node.right==null)
            return partialSum;
        //Non-leaf
        return _sumRootToLeaf(node.left, partialSum, base) + _sumRootToLeaf(node.right, partialSum, base);
    }

    public static void main(String args[])
    {
      int result;
      /*
                1
              /   \
            0       1
          /  \     /
         0    1   0
       /   \
      0     1
      */
      Node root=new Node(1);
      root.left=new Node(0);
      root.left.left=new Node(0);
      root.left.right=new Node(1);
      root.left.left.left=new Node(0);
      root.left.left.right=new Node(1);
      root.right=new Node(1);
      root.right.left=new Node(0);

      result=sumRootToLeaf(root, 10); //1000+1001+101+110=2212
      System.out.println("Root: "+root.value+", Base: 10, Sum: "+result);

      result=sumRootToLeaf(root, 2);//1000(8)+1001(9)+101(5)+110(6)=28
      System.out.println("Root: "+root.value+", Base: 2, Sum: "+result);
    }
}

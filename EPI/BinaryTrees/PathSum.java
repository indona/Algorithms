class PathSum
{
    public static boolean hasPathSum(Node root, int target)
    {
        return _hasPathSum(root, 0, target);
    }

    public static boolean _hasPathSum(Node node, int partialSum, int target)
    {
        if(node==null)
          return false;

        partialSum+=node.value;

        //Leaf
        if(node.left==null && node.right==null)
            return (partialSum==target);

        //Non-Leaf
        return _hasPathSum(node.left, partialSum, target) || _hasPathSum(node.right, partialSum, target);
    }

    public static void main(String args[])
    {
      boolean result;
      /*
                10
              /    \
            6       7
          /  \     /
         0    1   1
       /  \
      2   5
      */
      Node root=new Node(10);
      root.left=new Node(6);
      root.left.left=new Node(0);
      root.left.right=new Node(1);
      root.left.left.left=new Node(2);
      root.left.left.right=new Node(5);
      root.right=new Node(7);
      root.right.left=new Node(1);

      result=hasPathSum(root, 10);
      System.out.println("Root: "+root.value+", Target: 10, Result: "+result);

      result=hasPathSum(root, 21);
      System.out.println("Root: "+root.value+", Target: 10, Result: "+result);

      result=hasPathSum(root, 18);
      System.out.println("Root: "+root.value+", Target: 10, Result: "+result);
    }
}

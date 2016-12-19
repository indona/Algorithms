class IsSymmetric
{
      public static boolean isSymmetric(Node root)
      {
          if (root==null || (root.left==null && root.right==null))
              return true;
          else
              return isSymmetricHelper(root.left, root.right);
      }

      public static boolean isSymmetricHelper(Node left, Node right)
      {
          if(left==null || right==null)
              return true;
          else if (left!=null && right !=null && left.value==right.value)
              return (isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left));
          else
              return false;
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
        root.right=new Node(6);
        root.right.left=new Node(2);
        root.right.left.right=new Node(1);
        root.right.left.right.left=new Node(401);
        root.right.left.right.left.right=new Node(641);
        root.right.left.right.right=new Node(257);
        root.right.right=new Node(271);
        root.right.right.right=new Node(28);
        System.out.println("Is Symmetric: "+ isSymmetric(root));

        Node root1=new Node(1);
        root1.left=new Node(2);
        root1.left.right=new Node(3);
        root1.right=new Node(2);
        root1.right.left=new Node(3);
        System.out.println("Is Symmetric: "+ isSymmetric(root1));

      }
}

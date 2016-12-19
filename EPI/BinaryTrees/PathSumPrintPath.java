import java.lang.*;
import java.util.*;

class PathSumPrintPath
{
    public static List<List<Integer>> printPaths(Node root, int target)
    {
        List<List<Integer>> pathList=new ArrayList<List<Integer>>();
        if(root==null)
            return pathList;

        List<Integer> path=new ArrayList<Integer>();
        path.add(root.value);
        findPath(root, target-root.value, pathList, path);

        return pathList;
    }

    public static void findPath(Node node, int target, List<List<Integer>> pathList, List<Integer> path)
    {
        if(node.left==null && node.right==null && target==0)
        {
            ArrayList<Integer> tempPath=new ArrayList<Integer>();
            tempPath.addAll(path);
            pathList.add(tempPath);
        }

        if(node.left!=null)
        {
            path.add(node.left.value);
            findPath(node.left, target-node.left.value, pathList, path);
            path.remove(path.size()-1);
        }

        if(node.right!=null)
        {
            path.add(node.right.value);
            findPath(node.right, target-node.right.value, pathList, path);
            path.remove(path.size()-1);
        }
    }

    public static void main(String args[])
    {
      List<List<Integer>> pathList= new ArrayList<List<Integer>>();
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

      pathList=printPaths(root, 18);
      System.out.println("Root: "+root.value+", Target: 18, Paths: "+Arrays.toString(pathList.toArray()));

      pathList=printPaths(root, 21);
      System.out.println("Root: "+root.value+", Target: 21, Paths: "+Arrays.toString(pathList.toArray()));

      pathList=printPaths(root, 51);
      System.out.println("Root: "+root.value+", Target: 51, Paths: "+Arrays.toString(pathList.toArray()));
      
    }
}

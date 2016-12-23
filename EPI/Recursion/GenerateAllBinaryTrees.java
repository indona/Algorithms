import java.util.*;
import java.lang.*;

class GenerateAllBinaryTrees
{
    public static List<Node> generateAllBinaryTrees(int n)
    {
        List<Node> allTrees = new ArrayList<Node>();

        if(n==0)
            allTrees.add(null);

        for(int leftTreeNodes=0; leftTreeNodes<n; ++leftTreeNodes)
        {
            int rightTreeNodes=n-leftTreeNodes-1;
            List<Node> leftTrees=generateAllBinaryTrees(leftTreeNodes);
            List<Node> rightTrees=generateAllBinaryTrees(n-leftTreeNodes-1);

            for (Node left: leftTrees)
            {
                for(Node right: rightTrees)
                    allTrees.add(new Node(0, left, right));
            }
        }
        return allTrees;
    }

    public static void main(String args[])
    {
        int n, i;
        List<Node> allTrees=new ArrayList<Node>();

        n=3;
        allTrees=generateAllBinaryTrees(n);
        System.out.println("For n: "+n+", Number of binary trees: "+allTrees.size());

        n=6;
        allTrees=generateAllBinaryTrees(n);
        System.out.println("For n: "+n+", Number of binary trees: "+allTrees.size());

        n=10;
        allTrees=generateAllBinaryTrees(n);
        System.out.println("For n: "+n+", Number of binary trees: "+allTrees.size());
    }
}

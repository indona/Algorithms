public class Node
{
    //Original
    int value;
    Node left, right;

    /*//Added later
    int height;
    Node parent;
    int numNodesInSubtree;*/

    //Original
    Node(int value)
    {
        this.value=value;
        left=null;
        right=null;
    }

    //Added Later
    Node(int value, Node left, Node right)
    {
        this.value=value;
        this.left=left;
        this.right=right;
    }
    /*Node(int value, Node parent)
    {
        this.value=value;
        left=null;
        right=null;
        this.parent=parent;
    }

    Node(int value, int numNodesInSubtree)
    {
        this.value=value;
        left=null;
        right=null;
        this.parent=parent;
        this.numNodesInSubtree=numNodesInSubtree;
    }*/
}

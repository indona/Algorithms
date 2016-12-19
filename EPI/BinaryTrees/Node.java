public class Node
{
    //Original
    int value;
    Node left, right;

    //Added later
    int height;
    Node parent;

    //Original
    Node(int value)
    {
        this.value=value;
        left=null;
        right=null;
    }

    //Added Later
    Node(int value, Node parent)
    {
        this.value=value;
        left=null;
        right=null;
        this.parent=parent;
    }
}

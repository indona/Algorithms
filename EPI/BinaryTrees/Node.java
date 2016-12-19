public class Node
{
    //Original
    int value;
    Node left, right;

    //Added later
    int height;

    Node(int value)
    {
        this.value=value;
        left=null;
        right=null;
    }
}

import java.util.*;
import java.lang.*;

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x)
    {
        val = x;
    }
}

public class SerializeBTCodec
{
    //The idea behind this problem is to do a BFS - level ordered or a DFS - preorder and store the traversal with # for missing nodes. We use the same traversal for recreating the original tree.

    // Encodes a tree to a single string.
    public String serialize(TreeNode root)
    {
        //Sanity
        if(root==null)
            return "";

        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<TreeNode>();

        //Start the Level-Order traversal
        q.add(root);

        while(!q.isEmpty())
        {
            TreeNode node=q.poll();
            if(node!=null) //If the node is not null, add its value to the serialize string
            {
                sb.append(node.val);
                sb.append(",");

                q.add(node.left);
                q.add(node.right);
            }
            else //Else add a # to mark the empty node
                sb.append("#,");
        }

        //Remove the last ','
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data)
    {
        if(data==null || data.length()==0)
            return null;

        String[] arr=data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(arr[0]));

        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        int i=1;

        //Now we process the traversal, and re-generate the tree in Level-order fashion
        while(!q.isEmpty())
        {
            TreeNode node=q.poll();

            //In case of #, we create a null treenode and link it to the parent. To handle this we insert null into the queue.
            //This takes care of skipping those nulls.
            if(node==null)
                continue;

            //Processing the left child
            if(!arr[i].equals("#")) //If not null, create a node and add it to the tree. ALso insert into queue.
            {
                node.left=new TreeNode(Integer.parseInt(arr[i]));
                q.add(node.left);
            }
            else //Is null. Mark the left child as null and insert a null to the queue.
            {
                node.left=null;
                q.add(null);
            }
            i++;

            //Processing the right child
            if(!arr[i].equals("#")) //If not null, create new right node, link it to the root and insert into the queue.
            {
                node.right=new TreeNode(Integer.parseInt(arr[i]));
                q.add(node.right);
            }
            else //If null, mark root's right child as null and insert a null into the queue.
            {
                node.right=null;
                q.add(null);
            }
            i++;
        }
        return root;
    }

    public static void levelOrderTraversal(TreeNode root, List<Integer> traversal)
    {
        if(root==null)
            return;

        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);

        while(!q.isEmpty())
        {
            TreeNode node=q.poll();

            if(node!=null)
                traversal.add(node.val);
            else
                traversal.add(-1);

            if(node.left!=null)
                q.add(node.left);

            if(node.right!=null)
                q.add(node.right);
        }
        return;
    }

    public static void main(String args[])
    {
        /*Tree:
                         314
                        /  \
                      6    16
                     /     / \
                  271     2  271
                          \
                          17
        */
        TreeNode root=new TreeNode(314);
        root.left=new TreeNode(6);
        root.left.left=new TreeNode(271);
        root.right=new TreeNode(16);
        root.right.left=new TreeNode(2);
        root.right.left.right=new TreeNode(17);
        root.right.right=new TreeNode(271);


        SerializeBTCodec codec = new SerializeBTCodec();


        String serialized=codec.serialize(root);
        System.out.println("Serialized: "+serialized);

        List<Integer> traversal=new ArrayList<Integer>();
        TreeNode deserializedRoot=codec.deserialize(serialized);
        levelOrderTraversal(deserializedRoot, traversal);
        System.out.println("Deserialized inOrder: "+Arrays.toString(traversal.toArray()));
        
    }
}

import java.lang.*;
import java.util.*;

class UndirectedGraphNode
{
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}

public class CloneGraph
{
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node)
    {
        if(node==null)
            return null;

        //Create a queue to do a BFS of the given graph
        //Create a map to maintain mapping between the newly created nodes and nodes in the given graph so that you don't create duplicate nodes
        LinkedList<UndirectedGraphNode> queue=new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map=new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        queue.add(node);
        UndirectedGraphNode newNode=new UndirectedGraphNode(node.label);
        map.put(node, newNode);

        //Start the BFS
        while(!queue.isEmpty())
        {
            UndirectedGraphNode currentNode=queue.poll();
            List<UndirectedGraphNode> currentNodeNeighbors= currentNode.neighbors;

            //Process its neighbors
            for(UndirectedGraphNode neighbor: currentNodeNeighbors)
            {
                //If the neighbor node is a new node and not previously seen, then craete a new node and add it to the list of neighbors of the currentNode being processed.
                if(!map.containsKey(neighbor))
                {
                    UndirectedGraphNode newNeighbor=new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, newNeighbor);
                    map.get(currentNode).neighbors.add(newNeighbor);
                    queue.add(neighbor);
                }
                //If the node is previously seen, simply add it to the list of neighbors of the currentNode being processed.
                else
                    map.get(currentNode).neighbors.add(map.get(neighbor));
            }
        }
        return newNode;
    }
}

import java.util.*;
import java.lang.*;

public class AlienDictionary
{
    public static String alienOrder(String[] words)
    {
        if (words==null || words.length==0)
            return null;

        HashMap<Character, HashSet<Character>> graph=new HashMap<Character, HashSet<Character>>();
        //HashMap<Character, Integer> edgeCount=new HashMap<Character, Integer>();
        int[] incomingEdgeCount=new int[26];
        Arrays.fill(incomingEdgeCount, -1);
        buildGraph(words, graph, incomingEdgeCount);

        System.out.println("Graph size: "+graph.size());

        Queue<Character> queue=new LinkedList<Character>();
        StringBuilder sb=new StringBuilder();
        int noIncomingEdges=0;

        //Add all vertices which do not have any incoming edge to the queue for topo sort
        for(int i=0;i<incomingEdgeCount.length;i++)
        {
            if(incomingEdgeCount[i]==0)
            {
                queue.add((char)(i+'a'));
                sb.append((char)(i+'a'));
                noIncomingEdges++;
            }
        }

        for(int i=0;i<incomingEdgeCount.length; i++)
        {
            if(incomingEdgeCount[i]!=-1)
                System.out.println((char)(i+'a')+" count: "+incomingEdgeCount[i]);
        }

        //Start Topo Sort
        while(!queue.isEmpty())
        {
            char polledChar=queue.poll();
            //System.out.println("Element polled: "+polledChar);
            HashSet<Character> connectedVertices=graph.get(polledChar);
            // System.out.println("Vertices: "+connectedVertices.size());
            for(Character cv: connectedVertices)
            {
                char vertex=cv.charValue();
                int c=(int)(vertex-'a');
                incomingEdgeCount[c]--;
                // System.out.println((char)(c+'a')+" reduced to" +incomingEdgeCount[c]);
                if(incomingEdgeCount[c]==0)
                {
                    queue.add((char) (c+'a'));
                    sb.append((char) (c+'a'));
                    noIncomingEdges++;
                }
            }
        }
        // System.out.println("noIncomingEdges: "+noIncomingEdges+"\nGraph size: "+graph.size()+" Result: "+sb.toString());
        return noIncomingEdges==graph.size() ? sb.toString() : "";
    }

    public static void buildGraph(String[] words, HashMap<Character, HashSet<Character>> graph, int[] edgeCount)
    {
        //Go trhough all the words and create the edge graph
        for(int i=0;i<words.length;i++)
        {
            //Set the edge counts to 0 for the relevant characters
            for(char c: words[i].toCharArray())
                edgeCount[c-'a']=0;

            if(i>0)
            {
                System.out.println("\nAt "+i);
                String w1=words[i-1];
                String w2=words[i];
                System.out.println("W1: "+w1+" W2: "+w2);

                int minLen=Math.min(w1.length(), w2.length());
                for(int j=0;j<minLen;j++)
                {
                    char c1=w1.charAt(j);
                    char c2=w2.charAt(j);

                    System.out.println("C1: "+c1+" C2: "+c2);
                    if(c1!=c2)
                    {
                        if(! graph.containsKey(c1)) //If key already not present
                            graph.put(new Character(c1), new HashSet<Character>());

                        if(! graph.containsKey(c2)) //If key already not present
                            graph.put(new Character(c2), new HashSet<Character>());

                        //Add the vertex if it is not already added
                        if(! graph.get(c1).contains(c2))
                        {
                            //Add the other vertex to the HashSet
                            graph.get(c1).add(c2);

                            //Also update the vertex count for the 2nd vertex. Here we are keeping track of only the incoming edges
                            edgeCount[c2-'a']++;
                            System.out.println("Added "+c2+" to: "+c1+"| Edgecount of "+((char)(c2))+" increased to "+edgeCount[c2-'a']);
                            break;
                        }
                    }
                    else
                    {
                        if(! graph.containsKey(c1)) //If key already not present
                            graph.put(new Character(c1), new HashSet<Character>());
                    }
                }
            }
        }
        System.out.println("Size: "+graph.size());

    }

    public static void main(String args[])
    {
        String[] words={"z","x"};
        String result=alienOrder(words);
        System.out.println(result);

        String[] words2={"wrt","wrf","er","ett","rftt"};
        //String result2=alienOrder(words2);
        //System.out.println(result2);
    }

}

import java.util.*;
import java.lang.*;

public class ReconstructItinerary
{
    public static List<String> findItinerary(String[][] tickets)
    {
        LinkedList<String> itinerary=new LinkedList<String>();

        if(tickets==null)
            return itinerary;

        //Create a graph where each airport has a list of other airports it is linked to based on the given tickets. The list is ordered lexicographically (small first) by using a min-heap or PriorityQueue
        HashMap<String, PriorityQueue<String>> flights=new HashMap<String, PriorityQueue<String>>();

        //Create the graph for each airport in lexicographical order
        for(String[] ticket: tickets)
        {
            if(!flights.containsKey(ticket[0]))
                flights.put(ticket[0], new PriorityQueue<String>());

            flights.get(ticket[0]).add(ticket[1]);
        }

        /*for(String entry : flights.keySet())
        {
            System.out.println("Source: "+entry+", Connected to:"+Arrays.toString(flights.get(entry).toArray()));
        }*/

        //Start dfs from JFK and pick the lexicographically smaller edge in every iteration
        dfs("JFK", flights, itinerary);
        return itinerary;
    }

    public static void dfs(String source, HashMap<String, PriorityQueue<String>> flights, LinkedList<String> itinerary)
    {
        PriorityQueue<String> destination=flights.get(source);
        while(destination!=null && !destination.isEmpty())
        {
            String current=destination.poll();
            dfs(current, flights, itinerary);
        }
        itinerary.addFirst(source);
    }

    public static void main(String args[])
    {
        String[][] tickets={{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        List<String> itinerary=new ArrayList<String>();
        itinerary=findItinerary(tickets);
        System.out.println("Itinerary: "+ Arrays.toString(itinerary.toArray()));

        String[][] tickets2={{"JFK","SFO"}, {"JFK","ATL"}, {"SFO","ATL"}, {"ATL","JFK"}, {"ATL","SFO"}};
        itinerary.clear();
        itinerary=findItinerary(tickets2);
        System.out.println("Itinerary: "+ Arrays.toString(itinerary.toArray()));

        String[][] tickets3={{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
        itinerary.clear();
        itinerary=findItinerary(tickets3);
        System.out.println("Itinerary: "+ Arrays.toString(itinerary.toArray()));
    }
}

import java.lang.*;
import java.util.*;

public class EvaluateDivision
{
    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries)
    {
        //Sanity checks
        if(queries==null || queries.length==0)
            return (new double[0]);

        if(equations==null || equations.length==0)
            return null;

        //Create a weighted graph for the equations
        // Eg. [a,b], [c,d] == 2.0, 4.0
        HashMap<String, ArrayList<String>> graph=new HashMap<String, ArrayList<String>>();
        HashMap<String, ArrayList<Double>> weights=new HashMap<String, ArrayList<Double>>();
        for(int i=0;i<equations.length;i++)
        {
            if(!graph.containsKey(equations[i][0]))
            {
                graph.put(equations[i][0], new ArrayList<String>());
                weights.put(equations[i][0], new ArrayList<Double>());
            }
            if(!graph.containsKey(equations[i][1]))
            {
                graph.put(equations[i][1], new ArrayList<String>());
                weights.put(equations[i][1], new ArrayList<Double>());
            }
            graph.get(equations[i][0]).add(equations[i][1]);
            graph.get(equations[i][1]).add(equations[i][0]);
            weights.get(equations[i][0]).add(values[i]);
            weights.get(equations[i][1]).add(1/values[i]);
        }

        //Process the queries - each query is equivalent to finding a path from numerator to the denominator using DFS
        double[] result=new double[queries.length];
        for(int i=0;i<queries.length;i++)
        {
            String[] query=queries[i];
            String source=query[0];
            String destination=query[1];
            result[i]=dfs(source, destination, graph, weights, 1.0, new HashSet<String>());

            if(result[i]==0.0)
                result[i]=-1.0;
        }

        return result;
    }

    public static double dfs(String source, String destination, HashMap<String, ArrayList<String>> graph, HashMap<String, ArrayList<Double>> weights, double value, HashSet<String> set)
    {
        if(!graph.containsKey(source))
            return 0.0;
        if(set.contains(source))
            return 0.0;
        if(source.equals(destination))
            return value;

        set.add(source);
        ArrayList<String> neighbors=graph.get(source);
        ArrayList<Double> neighborWeights=weights.get(source);
        double v=0.0;
        for(int i=0;i<neighbors.size();i++)
        {
            v=dfs(neighbors.get(i), destination, graph, weights, (value*neighborWeights.get(i)), set);
            if(v!=0.0) //i.e. DFS has found the destination node and the value of the edge is returned. The recursion now comes back up.
                break;
        }
        return v;
    }

    public static void main(String args[])
    {
      String[][] equations={{"a", "b"}, {"a", "c"}};
      double[] values={2.0, 3.0};
      String[][] queries = {{"a", "c"}, {"b", "c"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
      System.out.println("Result: "+Arrays.toString(calcEquation(equations, values, queries)));

      String[][] equations2={{"a","b"},{"b","c"}};
      double[] values2={2.0, 3.0};
      String[][] queries2={{"a","c"},{"b","c"},{"a","e"},{"a","a"},{"x","x"}};
      System.out.println("Result: "+Arrays.toString(calcEquation(equations2, values2, queries2)));

    }
}

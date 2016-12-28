import java.util.*;
import java.lang.*;

public class CourseSchedule
{
    public static boolean canFinish(int[][] prerequisites, int numCourses)
    {
        if(prerequisites==null || numCourses==0)
            return true;

        int numPrereq=prerequisites.length;

        //Keep a list of number of prerequisites for each course
        int[] prereqList=new int[numCourses];
        for(int i=0;i<numPrereq;i++)
        {
            int course=prerequisites[i][0]; //i.e. This course has a documented prerequisite.
            prereqList[course]++; //Hence its prerequisite count is increased.
        }

        //For starting a topological sort, you need the nodes with no incoming edges or courses with no prerequisites.
        LinkedList<Integer> queue=new LinkedList<Integer>();
        for(int i=0;i<prereqList.length;i++)
        {
            if(prereqList[i]==0) //Courses which have a 0 prerequisite count, can be used to start the Topo sort.
                queue.add(i);
        }

        int noPrereqCourses=queue.size();

        //Start the topological sort
        while(!queue.isEmpty())
        {
            int course=queue.poll();
            //Check if this course serves as the prerequisite for any other course. If yes, decrement their prerequisite count as this node has been processed.
            for(int i=0;i<numPrereq;i++)
            {
                if(prerequisites[i][1]==course)
                {
                    prereqList[prerequisites[i][0]]--;
                    if(prereqList[prerequisites[i][0]]==0)
                    {
                        queue.add(prerequisites[i][0]);
                        noPrereqCourses++;
                    }
                }
          }
      }
      return noPrereqCourses==numCourses;
    }

    public static void main(String args[])
    {
        int[][] prerequisites={{1,2},{1,3},{2,5},{3,4},{4,3},{5,6}};
        int numCourses=7;
        System.out.println("Status: "+canFinish(prerequisites, numCourses));

        int[][] prerequisites2={{1,2},{1,3},{2,4},{4,6},{5,4},{5,6}};
        int numCourses2=7;
        System.out.println("Status: "+canFinish(prerequisites2, numCourses2));

    }
}

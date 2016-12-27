import java.util.*;
import java.lang.*;

public class CourseScheduleII
{
    public static int[] findOrder(int[][] prerequisites, int numCourses)
    {
        //Sanity check
        if(numCourses<=0)
            return null;

        //If courses don't have any prerequisite, then return the courses in any order
        int[] order=new int[numCourses];
        if(prerequisites==null || prerequisites.length==0)
        {
            for(int i=0;i<numCourses;i++)
                order[i]=i;
            return order;
        }

        //Create a list to track the number of prerequisites that each course has. This will help in topological sort of the courses. i.e. The course with no prerequisite can be added to the final list.
        int[] coursePrereqCount=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++)
            coursePrereqCount[prerequisites[i][0]]++;

        //Identify the courses with no prerequisites and add them to the queue for topological sort
        LinkedList<Integer> queue=new LinkedList<Integer>();
        for(int i=0;i<coursePrereqCount.length;i++)
        {
            if(coursePrereqCount[i]==0)
                queue.add(i);
        }

        int coursesWithNoPrereq=queue.size();
        int index=0;
        //Start the topological sort and keep adding the polled element to the final order of courses
        while(!queue.isEmpty())
        {
            int course=queue.poll();
            order[index]=course;
            index++;
            for(int i=0;i<prerequisites.length;i++)
            {
                if(prerequisites[i][1]==course)
                {
                    coursePrereqCount[prerequisites[i][0]]--;
                    if(coursePrereqCount[prerequisites[i][0]]==0)
                    {
                        queue.add(prerequisites[i][0]);
                        coursesWithNoPrereq++;
                    }
                }
            }
        }

        if(coursesWithNoPrereq==numCourses)
          return order;
        else
          return (new int[0]);
    }

    public static void main(String args[])
    {
        int[][] prerequisites={{1,2},{1,3},{2,5},{3,4},{4,3},{5,6}};
        int numCourses=7;
        System.out.println("Status: "+Arrays.toString(findOrder(prerequisites, numCourses)));

        int[][] prerequisites2={{1,0}};
        int numCourses2=2;
        System.out.println("Status: "+Arrays.toString(findOrder(prerequisites2, numCourses2)));
    }
}

import java.lang.*;
import java.util.*;

class ListNode
{
    int val;
    ListNode next;
    ListNode(int x)
    {
        this.val = x;
        this.next=null;
    }
 }

class ListComparator implements Comparator<ListNode>
{
    @Override
    public int compare(ListNode a, ListNode b)
    {
        return a.val-b.val;
    }
}

public class MergeKSortedLists
{
    public static ListNode mergeKLists(ListNode[] lists)
    {
        if(lists.length==0)
            return null;

        //Create a priority queue to hold the final list in the required order
        /*
        PriorityQueue<ListNode> queue=new PriorityQueue<ListNode>(new Comparator<ListNode>()
        {
            public int compare(ListNode a, ListNode b)
            {
                return a.val-b.val;
            }
        });
        */

        ListComparator lc=new ListComparator();
        PriorityQueue<ListNode> queue=new PriorityQueue<ListNode>(lc);

        //Create a fakeHead for the final list
        ListNode fakeHead=new ListNode(0);
        ListNode ptr=fakeHead;

        //Add all list heads to the queue
        for(ListNode listHead:lists)
        {
            if(listHead!=null)
                queue.add(listHead);
        }

        //Process all elements of each list. Poll the minimum listHead from the queue, add it to the final list. Move the final lists's head pointer to the newly added element. Add the next element to the queue and repeatedly extract the min element.
        while(!queue.isEmpty())
        {
            ListNode current =queue.poll();
            ptr.next=current;
            ptr=ptr.next;

            if(current.next!=null)
                queue.add(current.next);
        }

        return fakeHead.next;
    }

    public static void main(String args[])
    {
        ListNode n1=new ListNode(10);
        n1.next=new ListNode(12);
        ListNode n2=new ListNode(71);
        n2.next=new ListNode(82);
        n2.next.next=new ListNode(93);
        ListNode n3=new ListNode(5);
        n3.next=new ListNode(6);

        ListNode[] lists={n1, n2, n3};
        ListNode result=mergeKLists(lists);
        System.out.println("Final Head: "+result.val);
    }
}

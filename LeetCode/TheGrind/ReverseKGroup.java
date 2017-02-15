class ListNode
{
    int val;
    ListNode next;

    ListNode(int x)
    {
        val = x;
    }
}

public class ReverseKGroup
{
    public static ListNode reverseKGroup(ListNode head, int k)
    {
        //The idea behind this problem is to define the boundaries of each K-group and swap the nodes inside the k-group and reattached them back to the boundary nodes appropriately.
        //We add a dummy node to act as start boundary of the first k-node group.
        //We perform a running scan of the linkedList, whenever we encounter K nodes, we pass the boundaries - i.e. end of the previous K-group and start of the next K-group.
        //The reverse function reverses the k-nodes between these boundaries, re-attaches the nodes appropriately and returns the end of this group.
        //This end acts as the boundary for the next k-Group.

        if(k<2)
          return head;

        ListNode newHead=new ListNode(0);
        newHead.next=head;
        ListNode start=newHead;

        int i=0;
        while(head!=null)
        {
            i++;
            if(i%k==0) //K-group found. Pass the boundaries for reversing.
            {
                start=reverseGroup(start, head.next);
                head=start.next;
            }
            else
                head=head.next;
        }
        return newHead.next;
    }

    public static ListNode reverseGroup(ListNode start, ListNode end)
    {
        ListNode prev=start;
        ListNode curr=start.next;
        ListNode toReturn=start.next;

        while(curr!=end)
        {
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }

        //Crucial! Reattachment part.
        //Eg: 1->2->3->4 k=3
        // 0->1->2->3->4 | boudaries=0, 4
        //During reversal: 0<->1<-2<-3->4
        //During reattachment: 0->1<-2<-3->4 and 1->4 : 1's pointer changed to end instead of start
        // Final reattachment: 0->3->2->1->4 : 0's pointer changed to 3 instead of 1.
        //Keep a track of the start node -> this will become the end (or start for the next k-Group) -> return it.
        start.next.next=curr;
        start.next=prev;
        return toReturn;
    }

    public static void main(String args[])
    {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(6);
        head.next.next.next.next.next.next=new ListNode(7);

        ListNode newHead=reverseKGroup(head, 3);

        while(newHead!=null)
        {
            System.out.print(newHead.val);
            newHead=newHead.next;
        }
        System.out.println();
    }
}

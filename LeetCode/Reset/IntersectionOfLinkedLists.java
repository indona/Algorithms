class ListNode
{
     int val;
     ListNode next;

     ListNode(int x)
     {
         val = x;
         next = null;
     }
}

public class IntersectionOfLinkedLists
{
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        if (headA==null || headB==null)
            return null;

        //find lengths
        int length1=1, length2=1;
        ListNode node=headA;
        while(node.next!=null)
        {
            node=node.next;
            length1++;
        }

        node=headB;
        while(node.next!=null)
        {
            node=node.next;
            length2++;
        }

        //align the heads
        if(length1>length2)
        {
            for(int i=0; i<length1-length2;i++)
                headA=headA.next;
        }
        else if(length2>length1)
        {
            for(int i=0;i<length2-length1;i++)
                headB=headB.next;
        }

        //traverse
        while(headA!=headB)
        {
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }

    public static void main(String args[])
    {
        ListNode headA=new ListNode(1);
        headA.next=new ListNode(3);
        headA.next.next=new ListNode(5);
        headA.next.next.next=new ListNode(7);
        headA.next.next.next.next=new ListNode(9);
        headA.next.next.next.next.next=new ListNode(11);
        headA.next.next.next.next.next.next=new ListNode(13);

        ListNode headB=new ListNode(2);

        ListNode intersection = getIntersectionNode(headA, headB);
        if(intersection!=null)
            System.out.println("Intersection: "+ intersection.val);
        else
            System.out.println("Intersection: null");
    }
}

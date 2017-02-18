import java.util.*;
class ListNode
{
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

public class LinkListRandomNode
{
    //The logic behind this problem is the concept of Reservoir sampling. We have a target number in mind, for which we need to return its right indices at random.
    //We scan through the LinkedListlist. We keep a running counter called count.
    //We generate a random number between 0 and count+1 [0 to (count-inclusive)]. We observe the probability of getting the count (rather - probability that we'll have to change the last picked number) in this step. => This is the actual randomize part.
    //1st occurrence: P=1 (Only 1 node)
    //2nd: P=1/2 (P that we'll get the 2nd node)
    //3rd: P=1/3 (P of getting the new node=1/3, or getting an old node=2/3)
    //During this process, whenever we generate a random number=count, we update the result as that node's value.

    ListNode head;
    Random rand;

    public LinkListRandomNode(ListNode head)
    {
        this.head=head;
        rand=new Random();
    }

    /** Returns a random node's value. */
    public int getRandom()
    {
        int count=0;
        ListNode node=head, candidate=head;

        while(node!=null)
        {
            if(rand.nextInt(count+1)==count)
                candidate=node;
            count++;
            node=node.next;
        }
        return candidate.val;
    }


    public static void main(String args[])
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        LinkListRandomNode obj = new LinkListRandomNode(head);
        int param_1 = obj.getRandom();

        System.out.println("random node: "+param_1);
    }
}

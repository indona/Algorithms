class ListNode
{
    int val;
    ListNode next;

    ListNode(int x)
    {
        val = x;
    }
}

public class PalindromeLinkedList
{
    public static boolean isPalindrome(ListNode head)
    {
        //The idea behind this problem is to find the middle of the LinkedList and reverse the second half of the LinkedList.
        //Now compare both halves of the LinkedList node by node till you hit the end of one or both the LinkedLists.
        //If only one LinkedList ends, confirm if the 2nd LinkedList has one extra node (odd numbers).

        //Sanity
        if(head==null || head.next==null)
            return true;

        //Find the center using slow and fast pointers
        ListNode slow=head, fast=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        //Now slow points to the tail of the 1st LinkedList and fast points to the head of the 2nd LinkedList. Reverse this portion of the LinkedList.
        fast=slow.next;

        ListNode ptr=null;
        while(fast!=null)
        {
            ListNode next=fast.next;
            fast.next=ptr;
            ptr=fast;
            fast=next;
        }

        //Disconnect the two halves of LinkedLists
        slow.next=null;

        //Now compare the two LinkedLists
        ListNode newHead=ptr;
        while(head!=null && newHead!=null)
        {
            if (head.val!=newHead.val)
                return false;

            head=head.next;
            newHead=newHead.next;
        }

        if(head==null && newHead==null)
            return true;
        else if((head!=null && head.next==null) || (newHead!=null && newHead.next==null))
            return true;
        else
            return false;
    }

    public static void main(String args[])
    {
        ListNode head=new ListNode(2);
        head.next=new ListNode(1);
        head.next.next=new ListNode(4);
        head.next.next.next=new ListNode(1);
        head.next.next.next.next=new ListNode(2);
        System.out.println("Status: "+isPalindrome(head));

        ListNode head1=new ListNode(2);
        head1.next=new ListNode(1);
        head1.next.next=new ListNode(4);
        head1.next.next.next=new ListNode(4);
        head1.next.next.next.next=new ListNode(1);
        head1.next.next.next.next.next=new ListNode(2);
        System.out.println("Status: "+isPalindrome(head1));

        ListNode head2=new ListNode(1);
        head2.next=new ListNode(2);
        head2.next.next=new ListNode(2);
        System.out.println("Status: "+isPalindrome(head2));
    }
}

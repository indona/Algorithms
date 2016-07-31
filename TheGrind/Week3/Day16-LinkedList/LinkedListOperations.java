//Day16 Problem: LinkedList Operations
//Operations and their complexities:
//1. Add at front (head) = O(1)
//2. Add at end (tail) = O(1)
//3. Add after a given key = O(N)
//4. Delete node after a given key = O(N)
//5. Delete node at a given position = O(N)
//6. Print Linked List = O(N)
//7. Space Complexity = O(N)
//
//Input Format:
//N = No of ops. Followed by <Opcode> <Key(s)>
//H 5 = Insert 5 at Head. 
//T 7 = Insert 7 at Tail.
//I 7 8 = Insert 8 after node with key 7
//K 5 = Delete by key 5
//P 1 = Delete at 1st position

import java.util.Scanner;

class Node
{
    int data;
    Node next;

    Node(int data)
    {
        this.data=data;
        next=null;
    }
}

class LinkedList
{
    Node head=null;

    void addAtFront(int data)
    {
        Node newHead = new Node(data);
        newHead.next=head;
        head=newHead;
        System.out.println(newHead.data+" added as head.");
        return;
    }

    void addAfter(int previousKey, int newKey)
    {
        Node iterator=head, previousNode=null, newNode;
        if(head.data==previousKey)
            previousNode=head;
        else
        {
            while(iterator.next!=null && iterator.data!=previousKey)
            {
                previousNode=iterator;
                iterator=iterator.next;
            }

            if(iterator.next==null)
            {
                System.out.println("Previous key "+previousKey+" not found. New node not inserted.");
                return;
            }
        }

        newNode = new Node(newKey);
        newNode.next=previousNode.next;
        previousNode.next=newNode;
        System.out.println("Key "+newNode.data+" added after key "+previousNode.data);
        return;
    }

    void addAtEnd(int data)
    {
        Node newNode;

        if(head==null)
        {
            newNode = new Node(data);
            head=newNode;
        }
        else
        {
            Node tail=head;
            while(tail.next!=null)
                tail=tail.next;

            newNode = new Node(data);
            tail.next=newNode;
        }
        System.out.println(newNode.data+" added at the tail.");
        return;
    }

    void deleteByKey(int key)
    {
        Node iterator=head, previousNode=null;
        if(head.data==key) //If key is found at the head
        {
            previousNode=head;
            head=iterator.next;
            previousNode.next=null;
            System.out.println("Key "+iterator.data+" deleted at head.");
            return;
        }
        else
        {
            while(iterator.data!=key && iterator.next!=null) //Iterate through the LinkedList to find the key
            {
                previousNode=iterator;
                iterator=iterator.next;
            }

            if(iterator.next==null) //End of the Linked List reached. Key not found
            {
                System.out.println("Key "+key+" not found in the Linked List.");
                return;
            }
            else //Key found
            {
                previousNode.next=iterator.next;
                iterator.next=null;
                System.out.println("Key "+iterator.data+" deleted.");
                return;
            }
        }
    }

    void deleteByPosition(int position)
    {
        int counter=0;
        Node iterator=head, previousNode=null;

        if(position==0) //position given is head
        {
            previousNode=head;
            head=iterator.next;
            previousNode.next=null;
            System.out.println("Key "+iterator.data+" at position 0 has been deleted.");
            return;
        }
        else
        {
            counter++;
            while(counter!=position && iterator.next!=null) //Traverse the Linked List to find the required position.
            {
                previousNode=iterator;
                iterator=iterator.next;
                counter++;
            }

            if(iterator.next==null) //LinkedList has been traversed till end but the position has not been found. Invalid position value.
            {
                System.out.println("Position "+position+" to be deleted not found.");
                return;
            }
            else //Position found
            {
                previousNode.next=iterator.next;
                iterator.next=null;
                System.out.println("Key "+iterator.data+" at position "+counter+" deleted.");
                return;
            }
        }
    }

    void printLinkedList()
    {
        Node iterator=head;
        System.out.print("Linked List state: ");
        while(iterator.next!=null)
        {
            System.out.print(iterator.data + " ");
            iterator=iterator.next;
        }
        System.out.print(iterator.data+"\n\n");
    }
}

public class LinkedListOperations
{
    public static void main(String args[])
    {
        int N, newKey, previousKey, deleteKey, deletePosition;
        String opcode;
        LinkedList linkedList = new LinkedList();

        Scanner scanner = new Scanner(System.in);

        N=scanner.nextInt();
        for(int i=0; i<N; i++)
        {
            opcode=scanner.next();

            switch(opcode)
            {
                case "H":
                    newKey=scanner.nextInt();
                    linkedList.addAtFront(newKey);
                    linkedList.printLinkedList();
                    break;

                case "T":
                    newKey=scanner.nextInt();
                    linkedList.addAtEnd(newKey);
                    linkedList.printLinkedList();
                    break;

                case "I":
                    newKey=scanner.nextInt();
                    previousKey=scanner.nextInt();
                    linkedList.addAfter(newKey, previousKey);
                    linkedList.printLinkedList();
                    break;

                case "K":
                    deleteKey=scanner.nextInt();
                    linkedList.deleteByKey(deleteKey);
                    linkedList.printLinkedList();
                    break;

                case "P":
                    deletePosition=scanner.nextInt();
                    linkedList.deleteByPosition(deletePosition);
                    linkedList.printLinkedList();
                    break;

                default:
                    linkedList.printLinkedList();
            }
        }
        scanner.close();
    }   
}

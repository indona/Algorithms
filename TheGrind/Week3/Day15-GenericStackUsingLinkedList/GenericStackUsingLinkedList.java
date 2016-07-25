//Day15 Problem: Implement a stack using LinkedList.
//Concepts: Generics
//Operations: Push, Pop, isFull, isEmpty, Peek.
//Complexity: Stack Creation=O(N) | Other operations=O(1)
//Constraints: Capacity>0

import java.util.Scanner;

class Node<T>
{
    T data;
    Node<T> next;

    Node(T data)
    {
        this.data=data;
    }
}

class GenericLinkedList<T>
{
    Node<T> head=null;

    void addNode(T data)
    {
        Node<T> newHead = new Node<T> (data);
        newHead.next=head;
        head=newHead;
        return;
    }

    T removeNode()
    {
        Node<T> removedNode = head;
        head=head.next;
        return removedNode.data;
    }

    boolean isEmpty()
    {
        if(head==null)
            return true;
        else
            return false;
    }

    void peek()
    {
        if(isEmpty())
            System.out.println("Stack empty. Nothing to peek.\n");
        else
            System.out.println(head.data+" peeked.\n");
    }
}


class Stack<T>
{
    GenericLinkedList<T> linkedList = new GenericLinkedList<T>();

    static int capacity;
    int tos=0;

    Stack(int capacity)
    {
        this.capacity=capacity;
    }

    void push(T data)
    {
        if(tos==capacity)
        {
            System.out.println("Stack full. Cannot push.");
            return;
        }
        else
        {
            linkedList.addNode(data);
            tos++;
            System.out.println(data+" pushed.");
            return;
        }
    }

    void pop()
    {
        if(linkedList.isEmpty())
        {
            System.out.println("Stack empty. Nothing to pop.");
            return;
        }
        else
        {
            T poppedNode=linkedList.removeNode();
            tos--;
            System.out.println(poppedNode+" popped.");
            return;
        }
    }

    void isEmpty()
    {
        if(linkedList.isEmpty())
            System.out.println("Stack is empty.");
        else
            System.out.println("Stack is not empty.");
        return;
    }

    void peek()
    {
        linkedList.peek();
        return;
    }
}

public class GenericStackUsingLinkedList
{
    public static void main(String args[])
    {
        int T, C, N, P;
        Stack<Integer> stack;

        Scanner scanner = new Scanner(System.in);

        T=scanner.nextInt();
        for(int i=0; i<T; i++)
        {
            C=scanner.nextInt();
            stack = new Stack<Integer>(C);

            N=scanner.nextInt();
            for(int j=0; j<N; j++)
                stack.push(scanner.nextInt());

            P=scanner.nextInt();
            for(int j=0; j<P; j++)
                stack.pop();

            stack.peek();
        }
        scanner.close();
        System.out.println("");
    }
}

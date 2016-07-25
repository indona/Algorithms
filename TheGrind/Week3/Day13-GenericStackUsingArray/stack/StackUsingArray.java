//Day13 Problem: Implement a stack using Arrays.
//Concepts: Generics, Interfaces
//Operations: Push, Pop, isFull, isEmpty, Peek.
//Complexity: Stack Creation=O(N) | Other operations=O(1)
//Constraints: Capacity>0

package stack;

import java.util.Scanner;

class Stack <T> implements StackInterface <T>
{
    static int stackCapacity;
    int tos;
    T[] stack;

    public Stack(int size)
    {
        stackCapacity=size;
        tos=-1;
        stack=(T[])(new Object[size]);
    }

    public void push(T item)
    {
        if(isFull())
            System.out.println("Stack full. Cannot push.");
        else
        {
            stack[++tos]=item;
            System.out.println(item+" pushed.");
        }
    }

    public void pop()
    {
        if(isEmpty())
            System.out.println("Stack empty. Nothing to pop.");
        else
        {
            T poppedElement;
            poppedElement=stack[tos];
            stack[tos--]=null;
            System.out.println(poppedElement+" popped.");
        }
    }

    public boolean isFull()
    {
        if (tos==stackCapacity-1)
            return true;
        else
            return false;
    }

    public boolean isEmpty()
    {
        if(tos<0)
            return true;
        else
            return false;
    }

    public void peek()
    {
        if(isEmpty())
            System.out.println("Stack empty. Noting to peek");
        else
            System.out.println(stack[tos]+" peeked.");
    }
}


public class StackUsingArray
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
            System.out.print("\n");
        }
        scanner.close();
    }
}

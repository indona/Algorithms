package stack;

class Stack <T> implements StackInterface
{
    static int stackSize;
    int tos;
    T[] stack;

    public Stack(int size)
    {
        stackSize=size;
        tos=0;
        stack=(T[])(new Object[size]);
    }

    public void push(T item)
    {
        if(isFull())
            System.out.println("Stack full. Cannot push.");
        else
        {
            stack[tos]=item;
            tos++;
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
            poppedElement = stack[tos];
            tos--;
            System.out.println(poppedElement+" popped.");
        }
    }

    public boolean isFull()
    {
        if (tos==stackSize-1)
            return true;
        else
            return false;
    }

    public boolean isEmpty()
    {
        if(tos==0)
            return true;
        else
            return false;
    }

    public void peek()
    {
        if(isEmpty())
            System.out.println("Stack empty.");
        else
            System.out.println(stack[tos]);
    }
}


public class StackUsingArray
{
    public static void main(String args[])
    {
        Stack<Integer> stack = new Stack<Integer>(5); 

        for(int i=1;i<=5;i++)
        {
            stack.push(i);
        }
    }
}

package stack;

public interface StackInterface<T>
{
    public void push(T element);
    public void pop();
    public void peek();
    public boolean isEmpty();
    public boolean isFull();
}

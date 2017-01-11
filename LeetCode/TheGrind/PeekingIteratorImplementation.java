import java.lang.*;
import java.util.*;

class PeekingIterator implements Iterator<Integer>
{
		Integer next=null;
		Iterator<Integer> iter; //Actual iterator from the interface

		public PeekingIterator(Iterator<Integer> iterator)
		{
		    // initialize any member here.
				iter=iterator;
				if(iter.hasNext())
						next=iter.next();
		}

	  // Returns the next element in the iteration without actually moving the iterator.
		public Integer peek()
		{
				return next;
		}

		// hasNext() and next() should behave the same as in the Iterator interface.
		// Override them if needed.
		
		@Override
		//Here next returns the element currently pointed to by next and sets it to the next available element or sets it to null if it reaches the end of elements.
		public Integer next()
		{
				Integer result=next;
				if(iter.hasNext())
						next=iter.next();
				else
						next=null;
				return result;
		}

		@Override
		//hasNext simply checks the value of next and returns T/F based on that.
		public boolean hasNext()
		{
				if(next!=null)
						return true;
				else
						return false;
		}
}

public class PeekingIteratorImplementation
{
		public static void main(String args[])
		{
	    	List<Integer> list=new ArrayList<Integer>(){{
					add(1);
					add(5);
					add(-10);
					add(100);
				}};

				Iterator<Integer> it=list.iterator();
				PeekingIterator pi=new PeekingIterator(it);

				System.out.println("Array: "+Arrays.toString(list.toArray())+"\n");

				if(pi.hasNext())
						System.out.println("Peeked: "+pi.peek());

				if(pi.hasNext())
						System.out.println("Next: "+pi.next());

				if(pi.hasNext())
						System.out.println("Peeked: "+pi.peek());

				if(pi.hasNext())
						System.out.println("Next: "+pi.next());

				if(pi.hasNext())
						System.out.println("Next: "+pi.next());

				if(pi.hasNext())
						System.out.println("Peeked: "+pi.peek());

				if(pi.hasNext())
						System.out.println("Next: "+pi.next());

				if(pi.hasNext())
						System.out.println("Peeked: "+pi.peek());
				else
						System.out.println("Nothing to peek");
		}
}

import java.util.*;

class Node
{
    int key, value;
    Node prev, next;

    Node(int key, int value)
    {
        this.key=key;
        this.value=value;
    }
}

class LRUCache
{
    int capacity;
    Map<Integer, Node> map=new HashMap<Integer, Node>();
    Node head=null, tail=null;

    public LRUCache(int capacity)
    {
        this.capacity=capacity;
    }

    public int get(int key)
    {
        if(map.containsKey(key)) //Return and remove the node from current location and insert it at head to update its location
        {
            Node node=map.get(key);
            remove(node);
            insertAtHead(node);
            return node.value;
        }
        else
            return -1;
    }

    public void put(int key, int value)
    {
        if(map.containsKey(key))
        {
            Node node=map.get(key);
            node.value=value;
            remove(node);
            insertAtHead(node);
        }
        else
        {
            Node newNode=new Node(key, value);
            if(map.size()>=capacity)
            {
                map.remove(tail.key);
                remove(tail);
                insertAtHead(newNode);
            }
            else
                insertAtHead(newNode);

            map.put(key, newNode);
        }
    }

    public void remove(Node node)
    {
        if(node.prev!=null) //Node is not the head node
            node.prev.next=node.next;
        else //Node is the head node
            head=node.next;

        if(node.next!=null) //Node is not the tail node
            node.next.prev=node.prev;
        else //Node is the tail node
            tail=node.prev;
    }

    public void insertAtHead(Node node)
    {
        node.next=head;
        node.prev=null;

        if(head!=null) //The original queue was not empty
            head.prev=node;

        head=node;

        if(tail==null) //If queue was empty
            tail=head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

public class LRU
{
    public static void main(String args[])
    {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}

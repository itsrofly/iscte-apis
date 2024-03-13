Implement the following API dynamically (i.e. with linked nodes). 


### public class Queue<T> implements Iterable<T>
    public Queue()                           constructor
    public void enqueue(T item)              add item to the queue
    public T dequeue()                       remove and return the least recently added item
    public boolean isEmpty()                 is the queue empty?
    public int size()                        number of items in the queue
    public void shift()		         move the last element to the start of the queue
    public Iterator<T> iterator()		 return the iterator for this queue

The queue must maintain at least one Node first reference for the first node. A Node last reference can be added if deemed relevant.
The representation of the connected nodes must follow the following structure. You can add a Node previous field if you want to implement a doubly linked list.

### private class Node
	public T item;
	public Node next;

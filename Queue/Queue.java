package Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<T> implements Iterable<T> {
    private Node first;

    private class Node {
        public T item;
        public Node next;
    }

    public Queue() { // constructor
        first = new Node();
    }

    public boolean isEmpty() { // is the queue empty?
        return first.item == null;
    }

    public void enqueue(T item) { // add item to the queue

        if (isEmpty()) {
            first.item = item;
            first.next = new Node();
        } else {
            Queue<T> Qnext = new Queue<T>();
            Qnext.first = first.next;
            Qnext.enqueue(item);
            first.next = Qnext.first;
        }
    }

    public T dequeue() {// remove and return the least recently added item
        if (isEmpty())
            throw new IllegalStateException("Error: Underflow ");

        T Oldfirst = first.item;
        first = first.next;
        return Oldfirst;
    }

    public int size() { // number of items in the queue
        int s = 0;
        Iterator<T> it = iterator();

        while (it.hasNext()) {
            it.next();
            s++;
        }
        return s;
    }

    public void shift() {// move the last element to the start of the queue
        Queue<T> Qnext = new Queue<T>();
        Qnext.first.item = last();
        Qnext.first.next = first;
        first = Qnext.first;
    }

    private T last() {// return the last element
        if (isEmpty())
            throw new IllegalStateException("Error: Underflow ");

        Queue<T> Qnext = new Queue<T>();
        Qnext.first = first.next;
        if (Qnext.isEmpty()) {
            T Oldlast = first.item;
            first.item = null;
            first.next = null;
            return Oldlast;
        } else
            return Qnext.last();
    }

    public Iterator<T> iterator() { // return the iterator for this queue
        return new QueueListIterator();
    }

    private class QueueListIterator implements Iterator<T> { // Create the iterator
        private Node current = first;

        public boolean hasNext() {
            return current.item != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}

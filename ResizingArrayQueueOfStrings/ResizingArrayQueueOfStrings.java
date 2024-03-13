package ResizingArrayQueueOfStrings;

public class ResizingArrayQueueOfStrings {
    private String[] q;
    private int first, last;

    public ResizingArrayQueueOfStrings() {
        q = new String[1];
        first = -1;
        last = -1;
    }

    public void enqueue(String item) { // add item to the queue
        if (last + 1 == q.length)
            resize(q.length * 2);
        if (isEmpty())
            first++;
        q[++last] = item;
    }

    public String dequeue() { // remove and return the least recently added item
        if (isEmpty())
            throw new IllegalStateException("Error: queue underflow ");
        String firstOne = q[first];

        for (int i = first; i < last; i++)
            q[i] = q[i + 1];
        q[last--] = null;

        if (first > 0)
            first = 0;

        if (q[0] == null) {
            first = -1;
            last = -1;
        }
        if (q.length / 2 == last + 1)
            resize(q.length / 2);
        return firstOne;
    }

    public boolean isEmpty() { // is the queue empty?
        return first == -1;
    }

    public int size() { // number of items in the queue
        return last + 1;
    }

    public void shift() { // move the last element to the start of the queue
        first = last;
    }

    private void resize(int capacity) {
        String[] cpy = new String[capacity];

        for (int i = 0; i < q.length && i < cpy.length; i++)
            cpy[i] = q[i];
        q = cpy;
    }
}

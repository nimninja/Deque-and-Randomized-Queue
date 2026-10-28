import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A double-ended queue that supports adding and removing items at either end.
 * @param <Item> the type of items stored in this deque
 */
public class Deque<Item> implements Iterable<Item> {

    /** A node in the doubly linked list. */
    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    private Node head;
    private Node tail;
    private int size;

    /** Construct an empty deque. */
    public Deque() {
        // TODO: Initialize an empty linked list.
        Node head = new Node();
        head.item = null;
        Node tail = new Node();
        tail.item = null;


    }

    /** Return whether the deque is empty. */
    public boolean isEmpty() {
        // TODO: Report whether this linked list contains no items.
        return size == 0;
    }

    /** Return the number of items in the deque. */
    public int size() {
        // TODO: Return this linked list's item count.
        return size;
    }

    /** Add an item to the front; reject null items with IllegalArgumentException. */
    public void addFirst(Item item) {
        // TODO: Create a node and link it at the front; update head/tail pointers.
        Node n = new Node();
        n.next = head;
        n.prev = null;
        n.item = item;
        size++;
    }

    /** Add an item to the back; reject null items with IllegalArgumentException. */
    public void addLast(Item item) throws IllegalArgumentException {
        // TODO: Create a node and link it at the back; update head/tail pointers.
        if (item == null) {throw new IllegalArgumentException();}
        else {
            Node n = new Node();
            n.item = item;
            n.prev = tail;
            tail.next = n;
            tail = n;
            size++;
        }

    }

    /** Remove and return the front item; throw NoSuchElementException if empty. */
    public Item removeFirst() throws NoSuchElementException {
        // TODO: Remove the front node and update head/tail pointers.
        if (head.item == null) {throw new NoSuchElementException();}
        else {
            head = head.next;
            head.prev.next = null;
            size--;
        }
        return null;
    }

    /** Remove and return the back item; throw NoSuchElementException if empty. */
    public Item removeLast() throws NoSuchElementException{
        // TODO: Remove the back node and update head/tail pointers.
        if (tail.item == null) {throw new NoSuchElementException();}
        else {
            tail = tail.prev;
            tail.next.prev = null;
            size--;
        }

        return null;
    }

    /** Return an iterator from front to back; next() and remove() follow the specified exceptions. */
    @Override
    public Iterator<Item> iterator() {
        // TODO: Return an iterator that follows next links from head to tail.
        return new DequeIterator() {
        };
    }

    private class DequeIterator implements Iterator<Item>{
        private Node current = head.next;
        @Override
        public boolean hasNext() {
            return current != tail;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;

            return item;
        }
    }

    /** Run unit tests for the deque. */
    public static void main(String[] args) {
        // TODO: Add unit tests.
    }
}

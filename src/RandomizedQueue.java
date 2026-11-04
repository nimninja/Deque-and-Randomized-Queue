import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A queue that removes items uniformly at random.
 * @param <Item> the type of items stored in this randomized queue
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items;
    private int size;

    /** Construct an empty randomized queue. */
    public RandomizedQueue() {
        // TODO: Initialize an empty array-backed randomized queue. Resize by doubling when full and halving when quarter full.
        items = (Item[]) new Object[2];
    }

    /** Return whether the randomized queue is empty. */
    public boolean isEmpty() {
        // TODO: Report whether this array-backed queue contains no items.
        return size == 0;
    }

    /** Return the number of items in the randomized queue. */
    public int size() {
        // TODO: Return this array-backed queue's item count.
        return size;
    }

    /** Add an item; reject null with IllegalArgumentException. */
    public void enqueue(Item item) {
        // TODO: Add the item to the backing array, resizing as needed.
        if (item == null) {throw new IllegalArgumentException();}
        else {
            if (items.length<=(size++)) {
                Item[] tmp = (Item[]) new
            }
        }
    }

    /** Remove and return a uniformly random item; throw NoSuchElementException if empty. */
    public Item dequeue() {
        // TODO: Pick a random index between 0 and size-1; swap the chosen item with the last item, then remove and resize as needed.
        int rand = (int) (Math.random() * size);
        Item save;
        if (items[rand] == null) {
            throw new NoSuchElementException();
        } else {
            save = items[rand];
            items[rand] = null;
        }
        return save;
    }

    /** Return a uniformly random item without removing it; throw NoSuchElementException if empty. */
    public Item sample() {
        // TODO: Pick a random index between 0 and size-1 and return that array item without removing it.
        int rand = (int) (Math.random() * size);
        return items[rand];
    }

    /** Return an independent iterator in uniformly random order; define next() and remove() exceptions. */
    @Override
    public Iterator<Item> iterator() {
        // TODO: Return an independent iterator that traverses the array items in random order.



        return new RandomizedQueueIterator();
    }
    private class RandomizedQueueIterator implements Iterator<Item>{
        private Item[] shuffledItems;
        private int current;
        public RandomizedQueueIterator() {
            shuffledItems = (Item[]) new Object[size];
            for (int i = 0; i < size; i++) {
                shuffledItems[i] = items[i];
            }
            for (int i = 0; i < size; i++) {
                int x = (int) (Math.random()*(i+1));
                Item tmp = shuffledItems[x];
                shuffledItems[i] = shuffledItems[x];
                shuffledItems[x] = tmp;
            }
            current = 0;
        }
        @Override
        public boolean hasNext() {
            return current < size - 1;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return shuffledItems[current+1];
        }
    }

    /** Run unit tests for the randomized queue. */
    public static void main(String[] args) {
        // TODO: Add unit tests.
    }
}

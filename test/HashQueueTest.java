import com.tycrowe.dsc.hashqueue.HashNode;
import com.tycrowe.dsc.hashqueue.HashQueue;

import static org.junit.jupiter.api.Assertions.*;

class HashQueueTest {

    private HashQueue<Integer, String> testQueue;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.testQueue = new HashQueue<>();
    }

    @org.junit.jupiter.api.Test
    void size() {
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
    }

    @org.junit.jupiter.api.Test
    void contains() {
    }

    @org.junit.jupiter.api.Test
    void add() {
        HashNode<Integer, String> temp = new HashNode<>(0, "Apple");
        assertTrue(testQueue.add(new HashNode<>(0, "Tyler")));
        assertTrue(testQueue.add(new HashNode<>(0, "Crowe")));
        assertTrue(testQueue.add(temp));

        assertEquals(testQueue.peek(), temp);

        assertEquals(testQueue.size(), 3);
        assertFalse(testQueue.add(new HashNode<>(0, "Tyler")));
        assertEquals(testQueue.size(), 3);

        temp = new HashNode<>(3, "Oranges");
        assertTrue(testQueue.add(new HashNode<>(1, "Pear")));
        assertTrue(testQueue.add(new HashNode<>(1, "Banana")));
        assertTrue(testQueue.add(new HashNode<>(2, "Grapes")));
        assertTrue(testQueue.add(temp));

        assertEquals(testQueue.peek(), temp);

        temp = new HashNode<>(4, "Item 100");
        for (int i = 0; i < 100; i++) {
            assertTrue(testQueue.add(new HashNode<>(4, "Item " + i)));
        }
        assertTrue(testQueue.add(temp));

        assertEquals(testQueue.peek(), temp);

        testQueue.printHash();
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }

    @org.junit.jupiter.api.Test
    void clear() {
    }

    @org.junit.jupiter.api.Test
    void poll() {
        HashNode<Integer, String> temp0 = new HashNode<>(0, "HashQueueTest");
        HashNode<Integer, String> temp1 = new HashNode<>(0, "Tyler");
        HashNode<Integer, String> temp2 = new HashNode<>(0, "Crowe");

        assertTrue(testQueue.add(temp1));
        assertTrue(testQueue.add(temp2));
        assertTrue(testQueue.add(temp0));

        testQueue.printHash();
    }

    @org.junit.jupiter.api.Test
    void peek() {
    }
}
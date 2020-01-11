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
        testQueue.add(new HashNode<>(0, "Tyler"));
        testQueue.add(new HashNode<>(0, "Crowe"));
        testQueue.add(new HashNode<>(0, "Apple"));

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
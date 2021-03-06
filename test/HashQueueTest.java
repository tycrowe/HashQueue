import com.tycrowe.dsc.hashqueue.HashNode;
import com.tycrowe.dsc.hashqueue.HashQueue;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class HashQueueTest {

    private HashQueue<Integer, String> testQueue;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.testQueue = new HashQueue<>();
    }

    @org.junit.jupiter.api.Test
    void size() {
        // Integer Test!
        int rGen = 0;
        for (int i = 0; i < 1000; i++) {
            rGen = ThreadLocalRandom.current().nextInt(0, 10000);
            assertTrue(testQueue.add(new HashNode<>(rGen, "Item " + i)));
        }
        assertEquals(1000, testQueue.getNodeCount());
        System.out.println(testQueue.toString());
        HashQueue<String, String> testQueue2 = new HashQueue<>();
        // String test
        String strGen = "test";
        for (int i = 0; i < 1000; i++) {
            strGen = UUID.randomUUID().toString();
            assertTrue(testQueue2.add(new HashNode<>(strGen, "Item " + i)));
        }
        assertEquals(1000, testQueue2.getNodeCount());
        System.out.println(testQueue2.toString());
    }

    @org.junit.jupiter.api.Test
    void contains() {
        int rGen = 0;
        HashNode<Integer, String> node;
        for (int i = 0; i < 1000; i++) {
            rGen = i;
            node = new HashNode<>(rGen, "Item " + i);
            assertTrue(testQueue.add(node));
            assertTrue(testQueue.contains(node));
        }
    }

    @org.junit.jupiter.api.Test
    void add() {
        HashNode<Integer, String> temp = new HashNode<>(0, "Apple");
        assertTrue(testQueue.add(new HashNode<>(0, "Tyler")));
        assertTrue(testQueue.add(new HashNode<>(0, "Crowe")));
        assertTrue(testQueue.add(temp));

        assertEquals(testQueue.peek(), temp);
        assertEquals(testQueue.peek().getPrevNodeAddedFromQueue().getVal(), "Crowe");
        assertEquals(testQueue.peek().getPrevNodeAddedFromQueue().getPrevNodeAddedFromQueue().getVal(), "Tyler");

        assertEquals(testQueue.getNodeCount(), 3);
        assertFalse(testQueue.add(new HashNode<>(0, "Tyler")));
        assertEquals(testQueue.getNodeCount(), 3);

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

        System.out.println(testQueue.toString());
    }

    @org.junit.jupiter.api.Test
    void large_add_test() {
        int rGen = 0;
        for (int i = 0; i < 100000; i++) {
            rGen = ThreadLocalRandom.current().nextInt(0, 25000);
            assertTrue(testQueue.add(new HashNode<>(rGen, "Item " + i)));
        }

        System.out.println(testQueue.toString());
    }

    @org.junit.jupiter.api.Test
    void remove() {
        ArrayList<HashNode<Integer, String>> nodes = new ArrayList<>();
        int rGen = 0;
        HashNode<Integer, String> temp;
        for (int i = 0; i < 1000; i++) {
            rGen = ThreadLocalRandom.current().nextInt(0, 25000);
            temp = new HashNode<>(rGen, "Item " + i);
            if(i % 3 == 0) {
                nodes.add(temp);
            }
            assertTrue(testQueue.add(temp));
        }
        assertEquals(testQueue.size(), 100);
        assertEquals(testQueue.getNodeCount(), 1000);

        assertTrue(nodes.size() > 0);
        for (HashNode<Integer, String> node : nodes) {
            testQueue.remove(node);
        }

        assertEquals(testQueue.size(), 100);
    }

    @org.junit.jupiter.api.Test
    void clear() {
        assertEquals(0, testQueue.getNodeCount());
        int rGen = 0;
        for (int i = 0; i < 1000; i++) {
            rGen = ThreadLocalRandom.current().nextInt(0, 10000);
            assertTrue(testQueue.add(new HashNode<>(rGen, "Item " + i)));
        }
        assertNotEquals(0, testQueue.getNodeCount());
        assertEquals(testQueue.getNodeCount(), 1000);
        testQueue.clear();
        assertTrue(testQueue.getNodeCount() == 0);
        assertEquals(testQueue.getNodeCount(), 0);
        assertEquals(testQueue.size(), 100);
    }

    @RepeatedTest(3)
    void poll() {
        HashNode<Integer, String> temp0 = new HashNode<>(0, "Item 0");
        HashNode<Integer, String> temp1 = new HashNode<>(1, "Item 1");
        HashNode<Integer, String> temp2 = new HashNode<>(2, "Item 2");
        HashNode<Integer, String> temp3 = new HashNode<>(5, "Item 3");

        assertTrue(testQueue.add(temp0));
        assertTrue(testQueue.add(temp1));
        assertTrue(testQueue.add(temp2));
        assertTrue(testQueue.add(temp3));

        System.out.println(testQueue.poll());
        System.out.println(testQueue.poll());
        System.out.println(testQueue.poll());
        System.out.println(testQueue.poll());
        //testQueue.poll();
    }

    @org.junit.jupiter.api.Test
    void peek() {
        HashNode<Integer, String> temp = new HashNode<>(0, "Apple");
        assertTrue(testQueue.add(new HashNode<>(0, "Tyler")));
        assertTrue(testQueue.add(new HashNode<>(0, "Crowe")));
        assertTrue(testQueue.add(temp));

        assertEquals(temp, testQueue.peek());
    }
}
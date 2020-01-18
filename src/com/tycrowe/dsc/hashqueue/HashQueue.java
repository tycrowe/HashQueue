package com.tycrowe.dsc.hashqueue;

import java.util.ArrayList;
import java.util.Collections;

public class HashQueue<K, V> {
    private ArrayList<HashNode<K, V>> queue;

    private HashNode<K, V> top;
    private HashNode<K, V> prev;

    private int nodeCount = 0;

    public HashQueue() {
        this.queue = new ArrayList<>(
                Collections.nCopies(100, null)
        );
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.size() == 0;
    }

    public int getNodeCount() {
        return nodeCount;
    }

    public boolean contains(HashNode<K, V> kvHashNode) {
        if (kvHashNode == null || queue.isEmpty()) return false;
        else {
            int point = kvHashNode.hash(queue.size());
            if (queue.get(point) != null) {
                HashNode<K, V> node = queue.get(point);
                while (node.hasNeighbor()) {
                    if (node.getVal().equals(kvHashNode.getVal()))
                        return true;
                    node = node.getNeighborNode();
                }
            }
        }
        return false;
    }

    /**
     * To imitate the structure of any traditional queue, one must consider two things: All nodes have a neighbor and
     * all nodes understand "who" was added before them. The "neighbor" refers to the next node in the chain representative
     * inside their resolved key. For example:
     *  After the execution of the following commands in order, the structure would appear:
     *  add(HashNode(2, D));
     *  add(HashNode(1, A));
     *  add(HashNode(1, B));
     *      1: A -> B
     *      2: D
     *  Where A's neighbor would be "B" but it's previous pointer would reference "D." As that was the node previously added
     *  to the queue. This structure is encouraged to maintain a polling environment!
     * @param kvHashNode - The new hashnode that will be added to the hashqueue.
     * @return - If the addition was successful.
     */
    public boolean add(HashNode<K, V> kvHashNode) {
        // Preconditions: If the passed node is null, throw back false.
        if(kvHashNode == null) return false;
        else {
            // Post-Pre condition:
            /*
                - If the position at the point is null
             */
            // Resolve the point of which the node will be added.
            int point = kvHashNode.hash(queue.size());
            if(queue.get(point) == null) {
                queue.add(point, kvHashNode);
            } else {
                if (!contains(kvHashNode)) {
                    HashNode<K, V> node = queue.get(point);
                    while (node.hasNeighbor()) node = node.getNeighborNode();
                    node.setNeighborNode(kvHashNode);
                } else return false;
            }
            if(top != null) {
                kvHashNode.setPreviousNode(top);
            }
            top = kvHashNode;
            nodeCount++;
            return true;
        }
    }

    public boolean remove(HashNode<K, V> kvHashNode) {
        return false;
    }

    public void clear() {
        this.queue.clear();
    }

    // TODO
    public HashNode<K, V> poll() {
        if(top == null) {
            return null;
        } else {
            HashNode<K, V> temp = top;
            top = top.getPreviousNode();
            nodeCount--;
            return temp;
        }
    }

    public HashNode<K, V> peek() {
        return top;
    }

    @Override
    public String toString() {
        System.out.println("Index\t\t\t\tKey\t\t\t\tValue");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append("\n").append(i).append("\t\t\t\t\t");
            if(queue.get(i) != null) {
                HashNode<K, V> node = queue.get(i);
                sb.append(node.getKey()).append("\t\t\t\t").append(node.getVal());
                while(node.hasNeighbor()) {
                    node = node.getNeighborNode();
                    sb.append(" -> ").append(node.getVal());
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

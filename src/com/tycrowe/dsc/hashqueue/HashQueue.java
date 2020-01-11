package com.tycrowe.dsc.hashqueue;

import java.util.ArrayList;
import java.util.Collections;

public class HashQueue<K, V> {
    private int size = 0;
    private int capacity = 0;
    private ArrayList<HashNode<K, V>> queue;

    private HashNode<K, V> top;

    public HashQueue() {
        this.size = 0;
        this.queue = new ArrayList<>(
                Collections.nCopies(100, null)
        );
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(HashNode<K, V> kvHashNode) {
        if (kvHashNode == null || queue.isEmpty()) return false;
        else {
            int point = kvHashNode.hash(size);
            if (queue.get(point) != null) {
                HashNode<K, V> node = queue.get(point);
                while (node.hasNext()) {
                    if (node.getVal().equals(kvHashNode.getVal()))
                        return true;
                    node = node.getNext();
                }
            }
        }
        return false;
    }

    public boolean add(HashNode<K, V> kvHashNode) {
        if(kvHashNode == null) return false;
        int point = kvHashNode.hash(size);
        if(queue.isEmpty()) {
            queue.add(point, kvHashNode);
            capacity++;
        } else if(queue.get(point) == null) {
            queue.add(point, kvHashNode);
            capacity++;
        } else {
            if(!contains(kvHashNode)) {
                HashNode<K, V> node = queue.get(point);
                while (node.hasNext()) node = node.getNext();
                node.setNext(kvHashNode);
            } else return false;
        }
        size++;
        top = kvHashNode;
        return true;
    }

    public boolean remove(HashNode<K, V> kvHashNode) {
        if(contains(kvHashNode)) {
            HashNode<K, V> node = queue.get(kvHashNode.hash(size));
            while (node.hasNext()) {
                if (node.getNext().getVal().equals(kvHashNode.getVal())) {
                    node.setNext(node.getNext().getNext());
                    size--;
                    return true;
                }
                node = node.getNext();
            }
        }
        return false;
    }

    public void clear() {
        this.queue.clear();
    }

    public HashNode<K, V> poll() {
        HashNode<K, V> temp = top;
        top = top.getNext();
        size--;
        return temp;
    }

    public HashNode<K, V> peek() {
        return top;
    }


    public void printHash() {
        System.out.println("Index\t\t\t\tKey\t\t\t\tValue");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            sb.append("\n").append(i).append("\t\t\t\t\t");
            if(queue.get(i) != null) {
                HashNode<K, V> node = queue.get(i);
                sb.append(node.getKey()).append("\t\t\t\t").append(node.getVal());
                while(node.hasNext()) {
                    node = node.getNext();
                    sb.append(" -> ").append(node.getVal());
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

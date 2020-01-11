package com.tycrowe.dsc.hashqueue;

import java.util.ArrayList;

public class HashQueue<K, V> {

    private int size = 0;
    private ArrayList<HashNode<K, V>> queue;
    private HashNode<K, V>[] queue1;

    private HashNode<K, V> top;

    public HashQueue() {
        this.size = 0;
        this.queue = new ArrayList<>(100);
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
        if(queue.isEmpty() || queue.get(point) == null) {
            queue.add(point, kvHashNode);
        } else {
            HashNode<K, V> node = queue.get(point);
            while(node.hasNext()) node = node.getNext();
            node.setNext(kvHashNode);
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
        System.out.println("Key --- \t\t\t\t --- Value");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            HashNode<K, V> node = queue.get(i);
            sb.append(node.getKey()).append("\t\t\t\t").append(node.getVal());
            while(node.hasNext()) {
                node = node.getNext();
                sb.append(" -> ").append(node.getVal());
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

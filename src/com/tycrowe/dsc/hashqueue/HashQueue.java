package com.tycrowe.dsc.hashqueue;

import java.util.ArrayList;

public class HashQueue<K, V> {

    private int size = 0;
    private ArrayList<HashNode<K, V>[]> queue;

    private HashNode<K, V> top;
    private HashNode<K, V> back;

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

    public boolean contains(K key) {
        if(key == null) return false;
        else {
            int point = key.hashCode() % size;
            if(queue.get(point) != null) {
                HashNode<K, V>[] nodes = queue.get(point);
                for (HashNode<K, V> node: nodes) {

                }
            }
        }
    }

    public boolean add(K key, V val) {
        if(key == null) return false;
        else {
            HashNode<K, V> temp = new HashNode<>(
                key, val
            );
            queue.add(temp.hash(size), temp);
        }
    }

    public boolean remove(K key) {
        return false;
    }

    public void clear() {
        this.queue.clear();
    }

    public V remove() {
        return null;
    }

    public V poll() {
        return null;
    }

    public V element() {
        return null;
    }

    public V peek() {
        return null;
    }
}

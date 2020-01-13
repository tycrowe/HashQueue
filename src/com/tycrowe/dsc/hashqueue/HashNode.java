package com.tycrowe.dsc.hashqueue;

public class HashNode<K, V> {

    private K key;
    private V val;

    private HashNode<K, V> next;

    public HashNode(K key, V value) {
        this.key = key;
        this.val = value;
    }

    public boolean hasNext() {
        return next != null;
    }

    public HashNode<K, V> getNext() {
        return next;
    }

    public void setNext(HashNode<K, V> next) {
        this.next = next;
    }

    public int hash(int size) {
        if(size == 0) return 0;
        return this.key.hashCode() % size;
    }

    public K getKey() {
        return key;
    }

    public V getVal() {
        return val;
    }

    @Override
    public String toString() {
        return "HashNode{" +
                "key=" + key +
                ", val=" + val +
                ", next=" + next +
                '}';
    }
}
package com.tycrowe.dsc.hashqueue;

public class HashNode<K, V> {

    private K key;
    private V val;

    private HashNode<K, V> next;
    private HashNode<K, V> prev;

    private HashNode<K, V> prevNodeAddedFromQueue;

    public HashNode(K key, V value) {
        this.key = key;
        this.val = value;
    }

    public HashNode(HashNode<K, V> node) {
        this.key = node.key;
        this.val = node.val;
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

    public boolean hasPrev() {
        return prev != null;
    }

    public HashNode<K, V> getPrev() {
        return prev;
    }

    public void setPrev(HashNode<K, V> prev) {
        this.prev = prev;
    }

    public HashNode<K, V> getPrevNodeAddedFromQueue() {
        return prevNodeAddedFromQueue;
    }

    public void setPrevNodeAddedFromQueue(HashNode<K, V> prevNodeAddedFromQueue) {
        this.prevNodeAddedFromQueue = prevNodeAddedFromQueue;
    }

    public int hash(int size) {
        if(size == 0) return 0;
        int point = this.key.hashCode() % size;
        if(point < 0) point = Math.abs(point);
        return point;
    }

    public K getKey() {
        return key;
    }

    public V getVal() {
        return val;
    }

    public void setVal(V val) {
        this.val = val;
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
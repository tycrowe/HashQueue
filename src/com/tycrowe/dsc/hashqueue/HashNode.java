package com.tycrowe.dsc.hashqueue;

public class HashNode<K, V> {

    private K key;
    private V val;

    private HashNode<K, V> neighborNode;
    private HashNode<K, V> previousNode;

    public HashNode(K key, V value) {
        this.key = key;
        this.val = value;
    }

    public boolean hasNeighbor() {
        return neighborNode != null;
    }

    public HashNode<K, V> getNeighborNode() {
        return neighborNode;
    }

    public void setNeighborNode(HashNode<K, V> neighborNode) {
        this.neighborNode = neighborNode;
    }

    public HashNode<K, V> getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(HashNode<K, V> previousNode) {
        this.previousNode = previousNode;
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
                ", next=" + neighborNode +
                '}';
    }
}
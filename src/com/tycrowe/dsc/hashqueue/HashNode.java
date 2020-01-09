package com.tycrowe.dsc.hashqueue;

public class HashNode<K, V> {

    private K key;
    private V val;

    private HashNode<K, V> next;

    public HashNode(K key, V value) {
        this.key = key;
        this.val = value;
    }

    public int compareTo(HashNode<K, V> node) {
        if(key.equals(node.key) && val.equals(node.val)) {
            return 1;
        }
    }

    public int hash(int size) {
        return this.key.hashCode() % size;
    }

}
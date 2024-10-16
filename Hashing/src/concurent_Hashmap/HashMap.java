package concurent_Hashmap;

import java.util.LinkedList;

class HashMap<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    private LinkedList<Entry<K, V>>[] buckets;
    private int size;
    private int capacity;
    private final float loadFactor;

    public HashMap() {
        this.capacity = 16; // initial capacity
        this.size = 0;
        this.loadFactor = 0.75f; // load factor threshold
        this.buckets = new LinkedList[this.capacity];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        // Check if key already exists and update the value
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        // Key doesn't exist, add new entry
        buckets[index].add(new Entry<>(key, value));
        size++;

        // Resize if load factor exceeded
        if ((float) size / capacity > loadFactor) {
            resize();
        }
    }

    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        if (bucket != null) {
            for (Entry<K, V> entry : bucket) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null; // Key not found
    }

    public void remove(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        if (bucket != null) {
            for (Entry<K, V> entry : bucket) {
                if (entry.key.equals(key)) {
                    bucket.remove(entry);
                    size--;
                    return;
                }
            }
        }
    }

    private void resize() {
        capacity *= 2;
        LinkedList<Entry<K, V>>[] newBuckets = new LinkedList[capacity];

        for (LinkedList<Entry<K, V>> bucket : buckets) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    int newIndex = Math.abs(entry.key.hashCode()) % capacity;
                    if (newBuckets[newIndex] == null) {
                        newBuckets[newIndex] = new LinkedList<>();
                    }
                    newBuckets[newIndex].add(entry);
                }
            }
        }

        buckets = newBuckets;
    }
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
import java.util.Objects;

public class CustomHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private Node<K, V>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        buckets = new Node[INITIAL_CAPACITY];
        size = 0;
    }

    private static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private int getBucketIndex(K key) {
        return (key == null) ? 0 : Math.abs(key.hashCode() % buckets.length);
    }

    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        Node<K, V> head = buckets[bucketIndex];

        // Check if the key already exists and update the value if found
        Node<K, V> current = head;
        while (current != null) {
            if (Objects.equals(current.key, key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        // If the key doesn't exist, add a new node to the head of the bucket
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = head;
        buckets[bucketIndex] = newNode;
        size++;

        // Resize if the load factor is exceeded
        if ((float) size / buckets.length > LOAD_FACTOR) {
            resize();
        }
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        Node<K, V> current = buckets[bucketIndex];

        while (current != null) {
            if (Objects.equals(current.key, key)) {
                return current.value;
            }
            current = current.next;
        }

        return null; // Key not found
    }

    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);
        Node<K, V> head = buckets[bucketIndex];
        Node<K, V> previous = null;

        Node<K, V> current = head;
        while (current != null) {
            if (Objects.equals(current.key, key)) {
                if (previous == null) {
                    buckets[bucketIndex] = current.next; // Remove the head
                } else {
                    previous.next = current.next; // Bypass the current node
                }
                size--;
                return current.value;
            }
            previous = current;
            current = current.next;
        }

        return null; // Key not found
    }

    private void resize() {
        int newCapacity = buckets.length * 2;
        Node<K, V>[] oldBuckets = buckets;

        @SuppressWarnings("unchecked")
        Node<K, V>[] newBuckets = new Node[newCapacity];
        buckets = newBuckets;

        // Rehash all nodes into the new bucket array
        for (Node<K, V> head : oldBuckets) {
            while (head != null) {
                put(head.key, head.value);
                head = head.next;
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

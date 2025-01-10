import java.util.concurrent.atomic.AtomicReference;

public class CustomConcurrentHashMapCAS<K, V> {
    private final int bucketCount;
    private final AtomicReference<Node<K, V>>[] buckets;

    @SuppressWarnings("unchecked")
    public CustomConcurrentHashMapCAS(int bucketCount) {
        if (bucketCount <= 0) {
            throw new IllegalArgumentException("Bucket count must be greater than 0");
        }
        this.bucketCount = bucketCount;
        this.buckets = (AtomicReference<Node<K, V>>[]) new AtomicReference[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new AtomicReference<>(null);
        }
    }

    private int getBucketIndex(Object key) {
        return Math.abs(key.hashCode()) % bucketCount;
    }

    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        AtomicReference<Node<K, V>> head = buckets[bucketIndex];

        while (true) {
            Node<K, V> current = head.get();
            Node<K, V> newNode = new Node<>(key, value, current);

            if (head.compareAndSet(current, newNode)) {
                return; // Successfully inserted
            }
        }
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        AtomicReference<Node<K, V>> head = buckets[bucketIndex];

        Node<K, V> current = head.get();
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null; // Key not found
    }

    public boolean remove(K key) {
        int bucketIndex = getBucketIndex(key);
        AtomicReference<Node<K, V>> head = buckets[bucketIndex];

        while (true) {
            Node<K, V> current = head.get();
            Node<K, V> previous = null;
            Node<K, V> toRemove = null;

            // Traverse the linked list
            while (current != null) {
                if (current.key.equals(key)) {
                    toRemove = current;
                    break;
                }
                previous = current;
                current = current.next;
            }

            if (toRemove == null) {
                return false; // Key not found
            }

            Node<K, V> newHead = (previous == null) ? toRemove.next : previous;
            if (head.compareAndSet(current, newHead)) {
                return true; // Successfully removed
            }
        }
    }

    private static class Node<K, V> {
        final K key;
        final V value;
        final Node<K, V> next;

        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}

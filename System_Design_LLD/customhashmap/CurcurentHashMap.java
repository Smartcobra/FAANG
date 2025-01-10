import java.util.*;
import java.util.concurrent.locks.*;

public class CustomConcurrentHashMap<K, V> {
    private final int bucketCount;
    private final List<Map<K, V>> buckets;
    private final List<ReentrantLock> locks;

    public CustomConcurrentHashMap(int bucketCount) {
        if (bucketCount <= 0) {
            throw new IllegalArgumentException("Bucket count must be greater than 0");
        }
        this.bucketCount = bucketCount;

        // Initialize buckets and locks
        buckets = new ArrayList<>(bucketCount);
        locks = new ArrayList<>(bucketCount);

        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new HashMap<>());
            locks.add(new ReentrantLock());
        }
    }

    private int getBucketIndex(Object key) {
        return Math.abs(key.hashCode()) % bucketCount;
    }

    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        ReentrantLock lock = locks.get(bucketIndex);

        lock.lock(); // Lock the bucket
        try {
            Map<K, V> bucket = buckets.get(bucketIndex);
            bucket.put(key, value);
        } finally {
            lock.unlock(); // Ensure unlock happens even if an exception occurs
        }
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        ReentrantLock lock = locks.get(bucketIndex);

        lock.lock(); // Lock the bucket
        try {
            Map<K, V> bucket = buckets.get(bucketIndex);
            return bucket.get(key);
        } finally {
            lock.unlock(); // Ensure unlock happens even if an exception occurs
        }
    }

    public boolean containsKey(K key) {
        int bucketIndex = getBucketIndex(key);
        ReentrantLock lock = locks.get(bucketIndex);

        lock.lock(); // Lock the bucket
        try {
            Map<K, V> bucket = buckets.get(bucketIndex);
            return bucket.containsKey(key);
        } finally {
            lock.unlock(); // Ensure unlock happens even if an exception occurs
        }
    }

    public void remove(K key) {
        int bucketIndex = getBucketIndex(key);
        ReentrantLock lock = locks.get(bucketIndex);

        lock.lock(); // Lock the bucket
        try {
            Map<K, V> bucket = buckets.get(bucketIndex);
            bucket.remove(key);
        } finally {
            lock.unlock(); // Ensure unlock happens even if an exception occurs
        }
    }

    public int size() {
        int totalSize = 0;

        // Lock all buckets to calculate the size
        for (int i = 0; i < bucketCount; i++) {
            locks.get(i).lock();
        }

        try {
            for (Map<K, V> bucket : buckets) {
                totalSize += bucket.size();
            }
        } finally {
            // Unlock all buckets
            for (int i = 0; i < bucketCount; i++) {
                locks.get(i).unlock();
            }
        }

        return totalSize;
    }
}

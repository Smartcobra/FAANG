package Custom_HashMap.usingLInkedList;

public class Entry <K,V>{
    K key;
    V value;
    Entry <K,V> next;
    Entry <K,V> before;
    Entry <K,V> after;


    public Entry(K key, V value, Entry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}

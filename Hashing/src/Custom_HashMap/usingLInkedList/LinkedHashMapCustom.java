package Custom_HashMap.usingLInkedList;

public class LinkedHashMapCustom <K,V>{
    private Entry<K,V>[] table;   //Array of Entry.
    private final int capacity= 16;  //Initial capacity of HashMap
    private Entry<K,V> header; //head of the doubly linked list.
    private Entry<K,V> last; //last of the doubly linked list.
    private final int HASH_FACTOR=16;


    public LinkedHashMapCustom(){
        table = new Entry[capacity];
    }

    public void put(K key,V data){
        if(key==null){
            return;
        }

        int hash=key.hashCode()%HASH_FACTOR;

        Entry<K,V> newEntry= new Entry<>(key,data,null);
        if(table[hash]==null){
            table[hash]= newEntry;
        }else{

        }


    }
}

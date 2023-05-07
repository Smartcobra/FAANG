package GoogleInterviewQuestion2;

/*
* I have been asked int google telephonic interview this simple question but unable to resolve it in given 45 time limit,
The question is: U need to design structure in which it will nee to implement following 2 methods :

    public void insertOrReplace(long index, long number)
    public long findSmallestIndex(long number)
    so the first one is to insert the number on the index given by the user, index can be any number of long type and if at the same index another number comes it will replace that number
    2nd method is need to be implemented int which user will be given any number and we need to return the smallest index of that number
    Ex :
    index->number sequence
    2->100
    1->100
    3->100
    5->100
    if any user does findSmallestIndex(100) , output will be 1
    2-> 200
    if new number 200 comes at index 2 then 100 will be present only at indexs 1,3 &5 and 2nd index will be removed.

*
* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    static Map<Long, Long> index_to_num = new HashMap<>();

    public static void insertOrReplace(long index, long number) {

        /// long prevNo=index_to_num.get(index);
        if (index_to_num.containsKey(index)) {
            index_to_num.replace(index, number);
            // index_to_num.remove(index);
        } else {
            index_to_num.put(index, number);
        }

    }

    public static long findSmallestIndex(long number) {
        PriorityQueue<Long> q = new PriorityQueue<>();
        for (Map.Entry<Long, Long> entry : index_to_num.entrySet()) {
            if (number == entry.getValue()) {
                q.add(entry.getKey());
            }
        }

        return q.peek();
    }

    public static void main(String[] args) {
        insertOrReplace(12, 100);
        insertOrReplace(111, 100);
        insertOrReplace(3, 100);
        insertOrReplace(14, 100);
        insertOrReplace(5, 100);
        insertOrReplace(2, 200);
        insertOrReplace(3, 300);

        System.out.println(findSmallestIndex(100));
    }
}

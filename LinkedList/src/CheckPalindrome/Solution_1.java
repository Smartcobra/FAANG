package CheckPalindrome;

/*
*
    Copying the Linked List into an Array.
    Checking whether or not the Array is a palindrome.

* */

import node.Node;

import java.util.ArrayList;

public class Solution_1 {

    public static boolean isPalindrome(Node head) {
        Node temp=head;
        ArrayList<Integer> list= new ArrayList<>();
        while(temp !=null){
            list.add(temp.data);
            temp=temp.next;
        }

        int start=0;
        int end=list.size()-1;

        while(start<=end){
            if(!list.get(start).equals(list.get(end))){
               return false;
            }

            start++;
            end--;
        }
        return true;
    }
}

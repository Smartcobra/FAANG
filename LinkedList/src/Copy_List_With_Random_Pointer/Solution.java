package Copy_List_With_Random_Pointer;


//https://leetcode.com/problems/copy-list-with-random-pointer/description/

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class Solution {

    public Node copyRandomList(Node head) {
        Node head2 = new Node(-100);
        Node tmp1= head;
        Node tmp2 = head2;

        while(tmp1 !=null){
            Node t = new Node(tmp1.val);
            tmp2.next=t;
            tmp2 = t;
            tmp1 = tmp1.next;
        }

        head2 = head2.next;
        tmp1 = head;
        tmp2 = head2;

        /// Alternate Connection
        Node tmp = new Node(-1);

        while(tmp1 !=null){
            tmp.next = tmp1;
            tmp1 = tmp1.next;
            tmp = tmp.next;

            tmp.next = tmp2;
            tmp2 = tmp2.next;
            tmp =tmp.next;
        }

        tmp2 = head2;
        tmp1= head;

        ///Assign Random pointer

        while(tmp1 !=null && tmp2 !=null){
            if(tmp1.random==null) {
                tmp2.random = null;
            }else{
                tmp2.random = tmp1.random.next;
            }

            tmp1=tmp2.next;
            if(tmp1 !=null) tmp2 = tmp1.next;
        }
        tmp2 = head2;
        tmp1= head;

        // Separate the list

        while(tmp1!=null){
            tmp1.next = tmp2.next;
            tmp1 = tmp1.next;
            if(tmp1 !=null) tmp2.next = tmp1.next;
            if(tmp2.next == null) break;
            tmp2 = tmp2.next;
        }
        return head2;

    }
}

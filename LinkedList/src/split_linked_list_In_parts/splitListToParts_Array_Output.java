package split_linked_list_In_parts;

import node.ListNode;

public class splitListToParts_Array_Output {

    public ListNode[] splitListToParts(ListNode head, int k) {

        ListNode curr=head;
        int length=getLength(head);
        int splitSize = length/k;
        int extraNode = length%k;
        ListNode prev =null;
        ListNode[] ans = new ListNode[k];

        int i=0;
        while( head !=null && i<k ){
            int eachPartSize = splitSize;
            ans[i]=curr;
            while(eachPartSize >0){
                prev = curr;
                curr = curr.next;
                eachPartSize--;
            }

            if(extraNode !=0  && curr !=null){
                extraNode--;
                prev = curr;
                curr = curr.next;
            }

            if(prev !=null){
                head =curr;
                prev.next =null;
            }
            i++;

        }
        return ans;
    }

    private int getLength(ListNode head) {
        int count=0;
        while (head !=null){
            count++;
            head=head.next;
        }

        return count;
    }
}

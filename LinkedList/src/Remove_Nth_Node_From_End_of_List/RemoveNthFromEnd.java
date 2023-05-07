package Remove_Nth_Node_From_End_of_List;


import node.ListNode;

///https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
     int length=0;
     ListNode currentNode= head;

     while(currentNode!=null){
         length++;
         currentNode=currentNode.next;
     }

     ///if n=firstnode
        if(length==n){
            return head.next;
        }


     int nodeBeforeDelete=length-n-1;

      currentNode= head;
     for(int i=0;i<nodeBeforeDelete;i++){
         currentNode= currentNode.next;
     }

     currentNode.next=currentNode.next.next;


     return head;


    }
}

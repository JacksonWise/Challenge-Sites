/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(n == 1 && head.next == null){
            head = head.next;
            return head;
        }
        
        ListNode lNode = head,
            rNode = head;
        
        // Move right pointer over n places
        for( int i = 0; i < n; i++){
            rNode = rNode.next;
        }
        
        // Check if n == size of list
        if( rNode == null){
            head = head.next;
            return head;
        }
        
        // Move both pointers until lNode is n places from end of list
        while( rNode.next != null ){
            rNode = rNode.next;
            lNode = lNode.next;
        }
        
        lNode.next = lNode.next.next;
        
        return head;
    }
}
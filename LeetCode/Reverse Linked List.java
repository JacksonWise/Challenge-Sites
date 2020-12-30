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
    public ListNode reverseList(ListNode head) {
        // Only 0 or 1 node
        if(head == null || head.next == null)
            return head;
        
        // New list head
        ListNode newHead = new ListNode();
        newHead.val = head.val;
        
        // Next element to become new head
        ListNode rNode = head.next;
        
        // Push next node to head of list
        while(rNode != null){
            ListNode temp = new ListNode();
            
            temp.val = newHead.val;
            temp.next = newHead.next;
            
            newHead.val = rNode.val;
            newHead.next = temp;
            
            rNode = rNode.next;
        }
        
        return newHead;
    }
}
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode odd = head;           // Start of odd-indexed nodes
        ListNode even = head.next;     // Start of even-indexed nodes
        ListNode evenHead = even;      // Save the head of even list
        
        // Traverse and separate odd and even indexed nodes
        while (even != null && even.next != null) {
            odd.next = even.next;      // Link odd to next odd
            odd = odd.next;            // Move odd pointer
            
            even.next = odd.next;      // Link even to next even
            even = even.next;          // Move even pointer
        }
        
        // Connect odd list to even list
        odd.next = evenHead;
        
        return head;
    }
}
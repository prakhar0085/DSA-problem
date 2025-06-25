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
    public ListNode removeNodes(ListNode head) {
        // Step 1: Reverse the list
        head = reverse(head);

        // Step 2: Traverse and remove nodes with lesser value than max
        int max = head.val;
        ListNode curr = head;
        
        while (curr != null && curr.next != null) {
            if (curr.next.val < max) {
                curr.next = curr.next.next; // remove node
            } else {
                curr = curr.next;
                max = curr.val;
            }
        }

        // Step 3: Reverse the list back and return
        return reverse(head);
    }

    // Helper method to reverse a linked list
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}

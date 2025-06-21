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
    public void reorderList(ListNode head) {
        // Mid Node
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;

        //reverse 2nd half
        
       ListNode curr = mid.next;
       mid.next = null;
       ListNode prev = null;
       ListNode next;
       while(curr != null){
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
       }

       // alternative merging
       ListNode left = head;
       ListNode right = prev;
       ListNode nextLeft , nextRight;
       while(left != null && right != null){
        nextLeft = left.next;
        left.next = right;
        nextRight = right.next;
        right.next = nextLeft;

        left = nextLeft;
        right = nextRight;
       }
        
    }
}
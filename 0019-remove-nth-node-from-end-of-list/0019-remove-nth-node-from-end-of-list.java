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
        ListNode temp = head;
        int sz = 0;
        while(temp != null){
            temp = temp.next;
            sz++;
        }

         if(n == sz){
            return head.next;
        }
        
        ListNode prev = head;
        int i =1;
        int istoFind = sz - n;
        while(i < istoFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return head;
        
    }
}
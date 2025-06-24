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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return mergeRange(lists , 0 , lists.length - 1);
        
    }
    private ListNode mergeRange(ListNode[] lists , int start , int end){
        if(start == end) return lists[start];
        int mid = start + (end - start) / 2;
        ListNode left = mergeRange(lists , start , mid);
        ListNode right = mergeRange(lists , mid + 1 , end);
        return mergeTwoLists(left , right);
    }
    private ListNode mergeTwoLists(ListNode head1 , ListNode head2){
        ListNode mergedLL = new ListNode(-1);
        ListNode temp = mergedLL;

        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
           
        }
         while(head1 != null){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            while(head2 != null){
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
            return mergedLL.next;
    }
}
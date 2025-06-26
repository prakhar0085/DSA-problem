/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null){
            return head;
        }
        Node curr = head;
        while(curr != null){
            if(curr.child != null){
                // flatten the child node
                Node next = curr.next;
                curr.next = flatten(curr.child);
                curr.next.prev = curr;
                curr.child = null;

                // find the tail
                while(curr.next != null){
                    curr = curr.next;
                }

                // Attach tail with next pointer
                if(next != null){
                    curr.next = next;
                    next.prev = curr;
                }
                
            }
            curr = curr.next;
        }
        return head;
        
    }
}
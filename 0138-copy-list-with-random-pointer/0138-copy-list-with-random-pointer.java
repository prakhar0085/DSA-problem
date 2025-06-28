/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.HashMap;

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Map from original node to its copy
        HashMap<Node, Node> map = new HashMap<>();

        // Step 1: Copy all the nodes (just the values)
        Node current = head;
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        // Step 2: Set next and random pointers for each copied node
        current = head;
        while (current != null) {
            Node copy = map.get(current);
            copy.next = map.get(current.next);
            copy.random = map.get(current.random);
            current = current.next;
        }

        // Return the head of the cloned list
        return map.get(head);
    }
}

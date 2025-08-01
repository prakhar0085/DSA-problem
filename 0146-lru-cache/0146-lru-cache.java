class LRUCache {
    class Node{
        int key , val;
        Node prev;
        Node next;
        Node(int k , int v){
            key = k;
            val = v;
            prev = next = null;
        }
    }
    private HashMap<Integer , Node> m;
    private int limit;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        limit = capacity;
        m = new HashMap<>();
        head = new Node(-1 , -1);
        tail = new Node(-1 , -1);
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        if(!m.containsKey(key)){
            return -1;
        }
        Node ansNode = m.get(key);
        int ans = ansNode.val;
        m.remove(key);
        delNode(ansNode);
        addNode(ansNode);
        m.put(key , ansNode);
        return ans;
        
    }
    
    public void put(int key, int value) {
        if(m.containsKey(key)){
            Node oldNode = m.get(key);
            delNode(oldNode);
            m.remove(key);
        }
        if(m.size() == limit){
            m.remove(tail.prev.key);
            delNode(tail.prev);
        }
        Node newNode = new Node(key , value);
        addNode(newNode);
        m.put(key , newNode);
    }

    // addNode Function 
    private void addNode(Node newNode){
        Node oldNext = head.next;
        head.next = newNode;
        oldNext.prev = newNode;
        newNode.next = oldNext;
        newNode.prev = head;
    }

    // delNode Function
    private void delNode(Node oldNode){
        Node oldPrev = oldNode.prev;
        Node oldNext = oldNode.next;
        oldPrev.next = oldNext;
        oldNext.prev = oldPrev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
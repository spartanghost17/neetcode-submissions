class Node {
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    Map<Integer, Node> cache;
    Node head;
    Node tail;
    int cap;
    public LRUCache(int capacity) {
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.cache = new HashMap<>();
        this.cap = capacity;
    }
    
    public void add(Node node) {
        Node prev = this.tail.prev, nxt = this.tail;
        prev.next = node;
        node.prev = prev;
        node.next = nxt;
        nxt.prev = node;
        this.cache.put(node.key, node);
    }

    public void remove(Node node) {
        Node prev = node.prev, nxt = node.next;
        prev.next = nxt;
        nxt.prev = prev;
    }

    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Node node = this.cache.get(key);
        remove(node);
        add(node);
        //remove node 
        //add
        return node.value;
    }
    
    public void put(int key, int value) {
        if(this.cache.containsKey(key)) {
            Node node = this.cache.get(key);
            remove(node);
        }
        add(new Node(key, value));

        if(this.cache.size() > this.cap) {
            Node lru = this.head.next;
            remove(lru);
            this.cache.remove(lru.key);
        }
    }
}

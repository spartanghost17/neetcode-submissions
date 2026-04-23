class Node:
    def __init__(self, key: int, val: int):
        self.key, self.val = key, val
        self.prev, self.next = None, None

class LRUCache:

    def __init__(self, capacity: int):
        self.cache = {}
        self.cap = capacity
        self.head, self.tail = Node(0, 0), Node(0, 0)
        self.head.next = self.tail
        self.tail.prev = self.head    


    def add(self, node):
        prev, nxt = self.tail.prev, self.tail
        
        prev.next = node
        node.prev = prev
        
        nxt.prev = node
        node.next = nxt
        self.cache[node.key] = node
    
    def remove(self, node):
        prev, nxt = node.prev, node.next
        prev.next = nxt
        nxt.prev = prev

    def get(self, key: int) -> int:
        node = self.cache.get(key)
        if node:
            self.remove(node)
            self.add(node)
            return node.val        
        return -1

    def put(self, key: int, value: int) -> None:
        
        node = Node(key, value)
        if key in self.cache:
            self.remove(self.cache.get(key))
        self.add(node)

        if len(self.cache) > self.cap:
            lru = self.head.next
            self.remove(lru)
            del self.cache[lru.key]

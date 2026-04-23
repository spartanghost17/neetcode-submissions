class Node:
    def __init__(self, key: int, val: int):
        self.key, self.val = key, val
        self.prev, self.next = None, None

class LRUCache:

    def __init__(self, capacity: int):
        self.cache = {}
        self.capacity = capacity
        self.head, self.tail = Node(0, 0), Node(0, 0)
        self.head.next = self.tail
        self.tail.prev = self.head

    def add(self, node: Node):
        prev, nxt = self.tail.prev, self.tail
        prev.next = node
        nxt.prev = node
        node.prev = prev
        node.next = nxt
        self.cache[node.key] = node

    def remove(self, node: Node) -> Node:
        prev, nxt = node.prev, node.next
        prev.next = nxt
        nxt.prev = prev

    def get(self, key: int) -> int:
        # if exist:
        #   remove node
        #   add node
        #   return value
        node = self.cache.get(key)
        if node:
            self.remove(node)
            self.add(node)
            return self.cache[node.key].val

        return -1


    def put(self, key: int, value: int) -> None:
        # if at capacity:
        #    remove last item
        #    
        # add new item
        node = Node(key, value)

        if key in self.cache:
            n = self.cache[key]
            self.remove(n)
        self.add(node)

        if len(self.cache) > self.capacity:
            lru = self.head.next
            self.remove(lru)
            del self.cache[lru.key]

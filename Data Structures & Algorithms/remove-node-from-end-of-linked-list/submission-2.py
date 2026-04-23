# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        #head = [1,2,3,4], n = 2
        #          a     b
        #ptr = 3

        #n=2 [1, 2] null  
        #  a        b
        fast = head
        while n > 0:
            fast = fast.next
            n -= 1
        
        dummy = ListNode(0, head)
        slow = dummy

        while fast:
            slow = slow.next
            fast = fast.next
        
        slow.next = slow.next.next
        return dummy.next

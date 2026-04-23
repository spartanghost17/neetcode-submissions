# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        # 999 + 10 = 1009
        # left = 10 % 10 = 0
        # carry = 10 / 10 = 1

        dummy = ListNode(0)
        node = dummy

        carry = 0
        while l1 and l2:
            sum_val = l1.val + l2.val + carry
            left = sum_val % 10
            carry = sum_val // 10
            curr = ListNode(left)
            node.next = curr
            l1 = l1.next
            l2 = l2.next
            node = node.next

        while l1:
            sum_val = l1.val + carry
            left = sum_val % 10
            carry = sum_val // 10
            curr = ListNode(left)
            node.next = curr
            l1 = l1.next
            node = node.next
        
        while l2:
            sum_val = l2.val + carry
            left = sum_val % 10
            carry = sum_val // 10
            curr = ListNode(left)
            node.next = curr
            l2 = l2.next
            node = node.next
        
        if carry > 0:
            node.next = ListNode(carry)
        
        return dummy.next
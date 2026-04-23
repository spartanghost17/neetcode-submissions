# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy: ListNode = ListNode(0)
        node: ListNode = dummy

        carry: int = 0
        while l1 and l2:
            sum_val: int = l1.val + l2.val + carry
            left: int = sum_val % 10
            carry: ListNode = sum_val // 10
            curr = ListNode(left)
            node.next = curr
            node = node.next
            l1 = l1.next
            l2 = l2.next

        while l1:
            sum_val: int = l1.val + carry
            left: int = sum_val % 10
            carry: ListNode = sum_val // 10
            curr = ListNode(left)
            node.next = curr
            node = node.next
            l1 = l1.next

        while l2:
            sum_val: int = l2.val + carry
            left: int = sum_val % 10
            carry = sum_val // 10
            curr: ListNode = ListNode(left)
            node.next = curr
            node = node.next
            l2 = l2.next

        if carry > 0:
            curr = ListNode(carry)
            node.next = curr

        return dummy.next
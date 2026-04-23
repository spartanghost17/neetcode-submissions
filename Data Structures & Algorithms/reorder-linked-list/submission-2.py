# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        # [0, 1, 2, 3, 4, 5, 6]
        #           s        f   
        # [0, 1, 2, 3]
        # [4, 5, 6] -> [6, 5, 4]
        # [0, 6, 1, 5, 2, 4, 3]

        # find mid point
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # reverse second half
        second = slow.next
        slow.next = None
        prev = None # update head for second

        while second:
            temp = second.next
            second.next = prev
            prev = second
            second = temp

        second = prev
        first = head

        while second:
            temp1 = first.next
            temp2 = second.next

            first.next = second
            second.next = temp1

            first = temp1
            second = temp2




# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = prev = ListNode()
        curr1 = list1
        curr2 = list2

        while curr1 and curr2:
            if curr1.val < curr2.val:
                # temp = curr1.next
                # curr1.next = None
                # prev.next = curr1
                # curr1 = temp
                prev.next = curr1
                curr1 = curr1.next
            else:
                prev.next = curr2
                curr2 = curr2.next
                # temp = curr2.next
                # curr2.next = None
                # prev.next = curr2
                # curr2 = temp
            prev = prev.next
    
        if curr1:
            prev.next = curr1
        else:
            prev.next = curr2    


        return dummy.next
        
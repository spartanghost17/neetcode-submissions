/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return; //[], [0]

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
 
        //reverse second half
        ListNode second = slow.next;
        slow.next = null;//split into 2 halves
        ListNode prev = null; //true right head

        while(second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        //merge the two linked-lists
        second = prev; //move second to true head [6, 5, 4]
        ListNode first = head; //[0, 1, 2, 3]

        while(second != null) {
            ListNode tempFirst = first.next;
            ListNode tempSecond = second.next;

            first.next = second;
            second.next = tempFirst;

            first = tempFirst;
            second = tempSecond;
        }
    }
}

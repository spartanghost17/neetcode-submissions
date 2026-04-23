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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1;
        ListNode curr2 = l2;

        ListNode dummy = new ListNode();
        ListNode node = dummy;

        int carry = 0;
        while(curr1 != null || curr2 != null || carry != 0) {
            int v1 = (curr1 != null) ? curr1.val : 0;
            int v2 = (curr2 != null) ? curr2.val : 0;

            int num = v1 + v2 + carry;
            carry = num / 10;
            num = num % 10;  
            node.next = new ListNode(num);
            
            node = node.next;
            curr1 = curr1 != null ? curr1.next : null;
            curr2 = curr2 != null ? curr2.next : null;
        }

        return dummy.next;
    }
}

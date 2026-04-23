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
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        //carry sum / 10 -> 1 
        //left sum % 10 = 8
        //99 + 99 = 891
        //999 + 01 = (0) -> 9 -> 0 -> 0 1
        int carry = 0;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int left = sum % 10;
            carry = sum / 10;
            node.next = new ListNode(left);
            l1 = l1.next;
            l2 = l2.next;
            node = node.next;
        }

        while(l1 != null) {
            int sum = l1.val + carry;
            int left = sum % 10;
            carry = sum / 10;
            node.next = new ListNode(left);
            l1 = l1.next;
            node = node.next;
        }

        
        while(l2 != null) {
            int sum = l2.val + carry;
            int left = sum % 10;
            carry = sum / 10;
            node.next = new ListNode(left);
            l2 = l2.next;
            node = node.next;
        }

        if(carry > 0) {
            node.next = new ListNode(carry);
        }

        return dummy.next;
    }
}

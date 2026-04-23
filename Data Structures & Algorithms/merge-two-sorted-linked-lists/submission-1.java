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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode current1 = list1;
        ListNode current2 = list2;
        ListNode mergeHead = new ListNode(0);
        ListNode mergeCurr = mergeHead;

        while(current1 != null && current2 != null) {
            if(current1.val < current2.val) {
                mergeCurr.next = current1;
                mergeCurr = mergeCurr.next;
                current1 = current1.next;
            } else {
                mergeCurr.next = current2;
                mergeCurr = mergeCurr.next;
                current2 = current2.next;
            }
        }

        if(current1 != null) {
            mergeCurr.next = current1;
        } else {
            mergeCurr.next = current2;
        }

        // while(current1 != null) {
        //     mergeCurr.next = current1;
        //     mergeCurr = mergeCurr.next;
        //     current1 = current1.next;
        // }
        
        // while(current2 != null) {
        //     mergeCurr.next = current2;
        //     mergeCurr = mergeCurr.next;
        //     current2 = current2.next;
        // }

        return mergeHead.next;
    }
}
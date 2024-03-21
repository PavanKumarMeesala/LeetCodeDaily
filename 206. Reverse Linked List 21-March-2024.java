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
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode next = head;
        ListNode prevs = null;

        while(next != null)
        {
            next = next.next;
            current.next = prevs;
            prevs = current;
            current = next;
        }

        return prevs;
    }
}
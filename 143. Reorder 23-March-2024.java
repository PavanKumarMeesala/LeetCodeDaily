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
        if(head == null || head.next == null) return;
    
        ListNode prevs = null;
        ListNode mid = head;
        ListNode end = head;

        while(end != null && end.next != null)
        {
            prevs = mid;
            end = end.next.next;
            mid = mid.next;
        }
        
        prevs.next = null;

        ListNode list2 = reverseList(mid);
        mergeList(head, list2);
    }

    public ListNode reverseList(ListNode mid)
    {
        ListNode current = mid;
        ListNode next = mid;
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

    public void mergeList(ListNode p1, ListNode p2)
    {
        ListNode temp;
        while(p1!=null && p2!=null){
            temp = p1.next;
            p1.next = p2;
            
            p1 = p2;
            p2 = temp;
        }
    }
}
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
        ListNode prevs = null;

        int counter = 0;

        // Set head to the 'a' positon
        // Then prevs will be behind the head
        while(counter < a)
        {
            prevs = head;
            head = head.next;
            counter++;
        }

        // Set head to the 'b' position
        while(counter < b)
        {
            head = head.next;
            counter++;
        }

        // Merge the list2 elements to list1
        while(list2 != null)
        {
            prevs.next = list2;
            list2 = list2.next;
            prevs = prevs.next;
        }

        // Merge elements for head 'b' position
        while(head != null)
        {
            prevs.next = head.next;
            head = head.next;
            prevs = prevs.next;
        }
        
        // return the list one
        return list1;
    }
}
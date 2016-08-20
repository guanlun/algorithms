public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode curr = head.next;
        if (curr == null) {
            return head;
        }
        
        ListNode next = curr.next;
        
        curr.next = head;
        head.next = swapPairs(next);
        
        return curr;
    }
}

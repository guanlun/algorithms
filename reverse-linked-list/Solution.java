public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode prevNode = head;
        ListNode currNode = head.next;

        if (currNode == null) {
            return head;
        }
        
        ListNode nextNode = currNode.next;
        prevNode.next = null;
        
        while (true) {
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            
            if (currNode == null) {
                return prevNode;
            }
            
            nextNode = nextNode.next;
        }
    }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode currNode = head;

        while (true) {
            ListNode nextNode = currNode.next;
            
            if (nextNode == null) {
                return head;
            }

            while (nextNode.val == currNode.val) {
                nextNode = nextNode.next;
                currNode.next = nextNode;
                
                if (nextNode == null) {
                    return head;
                }
            }
            
            currNode = nextNode;
        }
    }
}

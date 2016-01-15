public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        
        if (l1.val < l2.val) {
            ListNode nextNode = mergeTwoLists(l1.next, l2);
            l1.next = nextNode;
            
            return l1;
        } else {
            ListNode nextNode = mergeTwoLists(l1, l2.next);
            l2.next = nextNode;
            
            return l2;
        }
    }
}

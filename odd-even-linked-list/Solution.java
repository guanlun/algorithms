public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode currOdd = head;
        ListNode nextOdd = head;
        ListNode evenAfterCurrOdd = head;
        ListNode evenBeforeNextOdd = head;
        
        int currOffset = 2;
        
        while (true) {
            for (int i = 0; i < currOffset; i++) {
                evenBeforeNextOdd = nextOdd;
                nextOdd = nextOdd.next;
                
                if (nextOdd == null) {
                    return head;
                }
            }
            
            evenAfterCurrOdd = currOdd.next;
            currOdd.next = nextOdd;
            evenBeforeNextOdd.next = nextOdd.next;
            nextOdd.next = evenAfterCurrOdd;
            currOdd = nextOdd;
            
            currOffset++;
        }
    }
}

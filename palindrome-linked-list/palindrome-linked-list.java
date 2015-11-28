public class Solution {
    class Result {
        public boolean valid;
        public ListNode rel;
        
        Result(boolean v, ListNode r) {
            this.valid = v;
            this.rel = r;
        }
    }
    
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            length++;
        }
        
        return iter(head, 0, length).valid;
    }
    
    public Result iter(ListNode curr, int index, int len) {
        int mid = (len - 1) / 2;
        if (index == mid) {
            if (len % 2 == 0) { // even
                if (curr.val != curr.next.val) {
                    return new Result(false, null);
                } else {
                    return new Result(true, curr.next.next);
                }
            } else { // odd
                return new Result(true, curr.next);
            }
        }
        
        Result res = iter(curr.next, index + 1, len);
        if (!res.valid) {
            return new Result(false, null);
        }
        
        if (res.rel == null) {
            return new Result(true, null);
        }
        
        if (curr.val != res.rel.val) {
            return new Result(false, null);
        }
        
        return new Result(true, res.rel.next);
    }
}

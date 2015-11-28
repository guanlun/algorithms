var addTwoNumbers = function(l1, l2) {
    var headNode = new ListNode(0),
        currNode,
        carry = 0;
        
    while (true) {
        if (!l1 && !l2) {
            if (carry !== 0) {
                currNode.next = new ListNode(1);
                currNode = currNode.next;
            }
            return headNode;
        } else if (!currNode) {
            currNode = headNode;
        } else {
            currNode.next = new ListNode(0);
            currNode = currNode.next;
        }
        
        if (l1) {
            currNode.val += l1.val;
            l1 = l1.next;
        }
        
        if (l2) {
            currNode.val += l2.val;
            l2 = l2.next;
        }
        
        currNode.val += carry;
        
        if (currNode.val >= 10) {
            currNode.val -= 10;
            carry = 1;
        } else {
            carry = 0;
        }
    }
};

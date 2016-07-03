var plusOne = function(head) {
    var shouldIncrement = recur(head);
    
    if (!shouldIncrement) {
        return head;
    }
    
    var newHead = new ListNode(1);
    newHead.next = head;
    
    return newHead;
};

var recur = function(node) {
    if (!node) {
        return true;
    }
    
    var shouldIncrement = recur(node.next);
    
    if (!shouldIncrement) {
        return false;
    }
    
    if (node.val === 9) {
        node.val = 0;
        return true;
    }
    
    node.val++;
    return false;
}

var removeElements = function(head, val) {
    while (head && (head.val === val)) {
        head = head.next;
    }
    
    if (!head) {
        return null;
    }
    
    var curr = head.next;
    var prev = head;
    
    while (curr) {
        if (curr.val === val) {
            prev.next = curr.next;
        } else {
            prev = curr;
        }
        curr = curr.next;
    }
    
    return head;
};

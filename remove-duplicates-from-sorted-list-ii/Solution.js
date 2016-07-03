var deleteDuplicates = function(head) {
    if (!head || !head.next) {
        return head;
    }
    
    if (head.val !== head.next.val) {
        head.next = deleteDuplicates(head.next);
        
        return head;
    }
    
    while (head.val === head.next.val) {
        head = head.next;
        
        if (!head.next) {
            return null;
        }
    }
    
    return deleteDuplicates(head.next);
};

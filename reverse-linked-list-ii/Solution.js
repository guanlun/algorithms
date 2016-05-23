var reverseBetween = function(head, m, n) {
    var prev = head;
    var curr = head.next;
    
    if (!curr || (m === n)) {
        return head;
    }
    
    var next = curr.next;

    var reverseBegin, reverseEnd, beforeBegin, afterEnd;
    
    if (m === 1) {
        reverseBegin = head;
    }
    
    var index = 1;
    
    while (index < n) {
        if (index === m - 1) {
            beforeBegin = prev;
            reverseBegin = curr;
        } else if (index === n - 1) {
            reverseEnd = curr;
            afterEnd = next;
        }
        
        if (index >= m && index < n) {
            curr.next = prev;
        }
        
        prev = curr;
        curr = next;
        
        if (!next) {
            break;
        }
        
        next = next.next;
        
        index++;
    }
    
    if (reverseBegin === head) {
        head = reverseEnd;
    } else {
        beforeBegin.next = reverseEnd;
    }
    
    reverseBegin.next = afterEnd;
    
    return head;
};

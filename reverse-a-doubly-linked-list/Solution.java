Node Reverse(Node head) {
    if (head == null) {
        return null;
    }
    
    Node prevNode = head;
    Node currNode = head.next;
    Node nextNode;
    
    while (currNode != null) {
        nextNode = currNode.next;
        
        currNode.next = prevNode;
        prevNode.prev = currNode;
        
        prevNode = currNode;
        currNode = nextNode;
    }
    
    head.next = null;
    prevNode.prev = null;
    
    return prevNode;
}

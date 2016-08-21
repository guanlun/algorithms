Node SortedInsert(Node head,int data) {
    Node newNode = new Node();
    newNode.data = data;
    
    if (head == null) {
        return newNode;
    }
    
    if (data < head.data) {
        newNode.next = head;
        head.prev = newNode;
        
        return newNode;
    }
    
    Node prevNode = head;
    Node curr = head.next;
    
    while (curr != null) {
        if (data < curr.data) {
            prevNode.next = newNode;
            newNode.prev = prevNode;
            curr.prev = newNode;
            newNode.next = curr;
            
            return head;
        }
        
        prevNode = curr;
        curr = curr.next;
    }
    
    prevNode.next = newNode;
    newNode.prev = prevNode;
    
    return head;
}

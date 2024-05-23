class OddEven
{

   // Should rearrange given linked list such that all even
   // positioned Nodes are before odd positioned.
   // Returns nothing
    void rearrangeEvenOdd(Node head)
    {
          //  The task is to complete this method
Node evenStart = null;
        Node evenEnd = null;
        Node oddStart = null;
        Node oddEnd = null;
        Node currentNode = head;
        
        boolean isOdd = true;
        while(currentNode != null) {
            int element = currentNode.data;
            
            if(!isOdd) {
                
                if(evenStart == null) {
                    evenStart = currentNode;
                    evenEnd = evenStart;
                } else {
                    evenEnd.next = currentNode;
                    evenEnd = evenEnd.next;
                }
                
                
            } else {
                
                if(oddStart == null) {
                    oddStart = currentNode;
                    oddEnd = oddStart;
                } else {
                    oddEnd.next = currentNode;
                    oddEnd = oddEnd.next;
                }
            }
                        // Move head pointer one step in forward direction
            currentNode = currentNode.next; 
            isOdd = !isOdd;
        }
        
        
        if(oddStart == null || evenStart == null) {
            return;
        }
        
        oddEnd.next = evenStart;
        evenEnd.next = null;
        head=oddStart;
          
     }
}

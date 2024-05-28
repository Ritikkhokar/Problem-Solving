class IntersectionLinkedList
{
    //Function to find intersection point in Y shaped Linked Lists.
	int intersectPoint(Node head1, Node head2)
	{
         // code here
        int size1 = findSize(head1);
        int size2 = findSize(head2);
        
        int big = Math.max(size1, size2);
        if(big == size1){
            for(int i=1;i<=size1-size2;i++){
                head1 = head1.next;
            }
        }else{
            for(int i=1;i<=size2-size1;i++){
                head2 = head2.next;
            }
        }
        return traverse(head1, head2);
	}
	
	public static int findSize(Node node){
        int size = 0;
        while(node != null){
            node = node.next;
            size++;
        }
        return size;
    }
    
    public static int traverse(Node head1, Node head2){
        
        while(head1 != null && head2 != null){
            if(head1 == head2){
                return head1.data;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return -1;
    }
}
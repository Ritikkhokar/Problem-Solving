class MergeSortLinkedList
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        // add your code here
        if(head == null || head.next == null)return head;
        
         Node fast = head;
         Node slow = head;
         Node prev = null;
         while(fast != null && fast.next != null){
             prev = slow;
             slow = slow.next;
             fast = fast.next.next;
         }
         
         prev.next = null;
         
         Node left = mergeSort(head);
         Node right = mergeSort(slow);
         Node res = merger(left, right);
         return res;
    }
    
    
    static Node merger(Node h1, Node h2) {

     if(h1 == null && h2 != null){
         return h2;
     } else if(h2 == null && h1 != null){
         return h1;
     }else if(h1 == null && h2 == null){
         return null;
     }
    
     if(h1.data<=h2.data){
        h1.next=merger(h1.next,h2);
        return h1;
    }
    else{
        h2.next=merger(h1,h2.next);
        return h2;
    }
     
   } 
}
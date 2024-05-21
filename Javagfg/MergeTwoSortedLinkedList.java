
class LinkedList
{
    //Function to merge two sorted linked list.
    Node sortedMerge(Node h1, Node h2) {

     if(h1 == null && h2 != null){
         return h2;
     } else if(h2 == null && h1 != null){
         return h1;
     }else if(h1 == null && h2 == null){
         return null;
     }
     
  
    // if(h1.data>h2.data){
    //     Node n = h2;
    //     h2 = h2.next;
    //     n.next = h1;
    //     h1 = n;
    //     h1.next = sortedMerge(h1.next, h2);
    //     return h1;
    // } else{
    //     h1.next = sortedMerge(h1.next, h2);
    //     return h1;
    // }
     
     
    //  better Approach
    
     if(h1.data<=h2.data){
        h1.next=sortedMerge(h1.next,h2);
        return h1;
    }
    else{
        h2.next=sortedMerge(h1,h2.next);
        return h2;
    }
    // return h2;
     
     
   } 
}
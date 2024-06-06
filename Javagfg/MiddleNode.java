
class Node {
    int data;
     Node next;
     Node left;
     Node right;
     Node(int d)  { data = d;  next = null; }
 }


class MiddleNode
{
    int getMiddle(Node head)
    {
         // Your code here.
         Node fast = head;
         Node slow = head;
         while(fast != null && fast.next != null){
             slow = slow.next;
             fast = fast.next.next;
         }
         return slow.data;
    }
}
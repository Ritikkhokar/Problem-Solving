
//   public class ListNode {

//   }
 
class Reorder {
    public void reorderList(ListNode head) {
        if(head.next == null){
            return;
        }
        
        reorder(head);
    }

    public static void reorder(ListNode root){
        ListNode middle = getMiddle(root);
        ListNode rightReversed = reverse(null,middle.next, middle.next.next);
        ListNode node = root;
        while(node != middle){
            ListNode temp = rightReversed.next;
            rightReversed.next = node.next;
            node.next = rightReversed;
            node = rightReversed.next;
            rightReversed = temp;
        }
        if(rightReversed != null){
            node.next = rightReversed;
            rightReversed.next = null;
        }else{
            node.next = null;
        }
    }

    public static ListNode getMiddle(ListNode head)
    {
         // Your code here.
         ListNode fast = head;
         ListNode slow = head;
         while(fast != null && fast.next != null){
             if(fast.next.next == null)return slow;
             slow = slow.next;
             fast = fast.next.next;
         }
         return slow;
    }
    
        public static ListNode reverse(ListNode pre, ListNode curr, ListNode post){
        if(post == null){
            return curr;
        }
        
        curr.next = pre;
        pre = curr;
        curr = post;
        post = post.next;
        curr.next = pre;
        return reverse(pre,curr,post);
    }
}
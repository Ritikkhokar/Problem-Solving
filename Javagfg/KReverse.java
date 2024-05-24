class KReverse
{
    public static Node reverse(Node node, int k)
    {
        //Your code here
        if(node == null)return null;
        Node head = node;
        int kk = k;
        while(k != 1 ){
            if(node.next == null)break;
            node = node.next;
            k--;
        }
        Node headForNextList = node.next;
        node.next = null;
        Node reverseHead = reverseLinks(null, head, head.next);
        head.next = reverse(headForNextList, kk);
        return reverseHead;
    }
    
    public static Node reverseLinks(Node pre, Node curr, Node post){
        if(post == null){
            return curr;
        }
        
        curr.next = pre;
        pre = curr;
        curr = post;
        post = post.next;
        curr.next = pre;
        return reverseLinks(pre,curr,post);
    }
}
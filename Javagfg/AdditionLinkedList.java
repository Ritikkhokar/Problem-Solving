public class AdditionLinkedList{
    static Node head = null;
    static int carry = 0;
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node num1, Node num2){
        // code here
        // return head of sum list
        head = null;
        carry =0;
        int L1Size = findSize(num1);
        int L2Size = findSize(num2);
        
        addition(num1, L1Size, num2, L2Size);
        if(carry>0){
            Node n = new Node(carry);
            n.next = head;
            return n;
        }
        while(head != null && head.data == 0){
            head = head.next;
        }
        if(head == null ){
        return new Node(0);
        }
        
        return head;
    }
    
    public static int findSize(Node node){
        int size = 0;
        while(node != null){
            node = node.next;
            size++;
        }
        return size;
    }
    
    public static void addition(Node node1, int size1, Node node2, int size2){
        if(size1 ==0 && size2 ==0){
            return;
        }
        
        Node temp  = new Node(0);
        if(size1>size2){
            addition(node1.next, size1-1, node2, size2);
            temp.data = (node1.data + carry)%10;
            carry = (node1.data + carry)/10;
        }else if(size1<size2){
            addition(node1, size1, node2.next, size2-1);
            temp.data = (node2.data + carry)%10;
            carry = (node2.data + carry)/10;
        }else{
            addition(node1.next, size1-1, node2.next, size2-1);
            temp.data = (node1.data + node2.data + carry)%10;
            carry = (node1.data + node2.data + carry)/10;
        }
        temp.next = head;
        head = temp;
        
    }
    
}

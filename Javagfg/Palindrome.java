class Palindrome
{
    //Function to check whether the list is palindrome.
    static Node left = null;
    boolean isPalindrome(Node head) 
    {
        //Your code here
        left = head;
       return checkPalindrome(head);
    }  
    
    public static boolean checkPalindrome(Node node){
        if(node.next == null){
            return (node.data == left.data);
        }
        
        boolean check = checkPalindrome(node.next);
        if(check == false)return false;
        left = left.next;
        
        return (left.data == node.data);
    }
    
}
import java.util.*;
class Inorder
{
    // Return a list containing the inorder traversal of the given tree
    ArrayList<Integer> inOrder(Node root)
    {
        // Code
        ArrayList<Integer> ans = new ArrayList<>();
        
        // return traverse(root, ans);
        return iterate(root);
    }
    
    public static ArrayList<Integer> traverse(Node node, ArrayList<Integer> ans){
        
        if(node == null)return ans;
        
        if(node.left != null){
            ans = traverse(node.left, ans);
        }
        ans.add(node.data);
        if(node.right != null){
            ans = traverse(node.right, ans);
        }
        return ans;
        
        
    }
    
    public static ArrayList<Integer> iterate(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack();
        
        st.push(root);
        
        while(st.size()!=0){
            Node node  = st.peek();
            if(node.left != null){
             st.push(node.left);
             node.left = null;
            }else{
                ans.add(node.data);
                st.pop();
                if(node.right != null)st.push(node.right);
                
            }
        }
        return ans;
    }
    
    
}
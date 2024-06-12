import java.util.ArrayList;
import java.util.Queue;
import java.util.*;
class NodeAtKDistance
{
     // Recursive function to print right view of a binary tree.
     ArrayList<Integer> Kdistance(Node root, int k)
     {
          // Your code here
          Queue<Node> q1 = new LinkedList<>();
          Queue<Node> q2 = new LinkedList<>();
          ArrayList<Integer> ans = new ArrayList<>();
          q1.add(root);
          
        while(k!=0){
              
          while(q1.size() > 0){
              Node node = q1.remove();
              if(node.left != null){
                  q2.add(node.left);
              }
              if(node.right != null){
                  q2.add(node.right);
              }
          }
          q1 = q2;
          q2 = new LinkedList<>();
          k--;
        }
        
        
    while(q1.size()>0){
        Node n= q1.remove();
        ans.add(n.data);
    }
    return ans;
        
    }
}

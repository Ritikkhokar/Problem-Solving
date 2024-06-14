import java.util.Stack;

class Pair{
    Node node;
    Integer state;
    
    Pair(Node node){
        this.node = node;
        this.state = -1;
    }
   }
   class Solution{
       Node constructTree(int n, int pre[], char preLN[]){
           // code here
           Stack<Pair> stack = new Stack<>();
           Node ans = new Node(pre[0]);
           if(preLN[0] == 'N'){
              stack.push(new Pair(ans));
           }
           for(int i=1; i<pre.length && stack.size()>0; i++){
                   Node node  = new Node(pre[i]);
                   Pair pair = stack.peek();
                   pair.state += 1;
                   stack.pop();
                   if(pair.state == 0){
                     pair.node.left = node;
                     stack.push(pair);
                   }else if(pair.state == 1){
                     pair.node.right = node;
                   }
               
               if(preLN[i] == 'N'){
                 stack.push(new Pair(node)); 
               }
           }
           
           return ans;
       }
   }
import java.util.ArrayList;
import java.util.Collections;

class NodesAtKdistanceFromTarget
{
    static ArrayList<Integer> ans = new ArrayList<>();
    static ArrayList<Node> nodeToRootPath = new ArrayList<>();
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
    //     ans = new ArrayList<>();
    //     if(k == 0 || root == null)return ans;
    //     // return the sorted list of all nodes at k dist
    //     Integer targetNodeDepth = null;
    //     if(root.data == target){
    //         findKDistanceNodes(root.left, 1, k, true);
    //         findKDistanceNodes(root.right, 1, k, true);
    //         return ans;
    //     }
    //     targetNodeDepth = findNodeDepth(root.left,target);
    //     if(targetNodeDepth != null){
    //     //   targetNodeDepth++; 
    //       findKDistanceNodes(root.left, targetNodeDepth-1, k, false);
    //       findKDistanceNodes(root.right, targetNodeDepth + 1, k, true);
    //         return ans;
    //     }
    //     targetNodeDepth = findNodeDepth(root.right,target); 
    //     if(targetNodeDepth != null){
    //         // targetNodeDepth++; 
    //         findKDistanceNodes(root.left, targetNodeDepth+1, k, true);
    //         findKDistanceNodes(root.right, targetNodeDepth-1, k, false);
    //         return ans;
    //     }
    //     return ans;
    
           nodeToRootPath = new ArrayList<>();
           findNodeToRootPath(root, target);
           ans = new ArrayList<>();
           
           for(int i=0; i<nodeToRootPath.size();i++){
               if(i==0){
                   kDistanceDownward(nodeToRootPath.get(i), k, null);
               }else{
               kDistanceDownward(nodeToRootPath.get(i), k-i ,nodeToRootPath.get(i-1));
               }
           }
           Collections.sort(ans);
           return ans;
    }
    
    public static boolean findNodeToRootPath(Node root, int target){
        
        if(root == null)return false;
        
        if(root.data == target){
           nodeToRootPath.add(root); 
           return true;
        }
        
        if(root.left != null && findNodeToRootPath(root.left, target)){
          nodeToRootPath.add(root);
          return true;
        }
        
        if(root.right != null && findNodeToRootPath(root.right, target)){
          nodeToRootPath.add(root);
          return true;
        }
        return false;
    }
    
    public static void kDistanceDownward(Node root, int k, Node blocker){
        
        if(root == null || k<0)return;
        
        if(k==0){
            ans.add(root.data);
            return;
        }
        if(blocker == null || blocker != root.left){
            kDistanceDownward(root.left, k-1, null);
        }
        if(blocker == null || blocker != root.right){
            kDistanceDownward(root.right, k-1, null);
        }
        
    }
    
    // public static Integer findNodeDepth(Node node, int target){
    //     if(node == null)return null;
        
    //     if(node.data == target){
    //         return 1;
    //     }
        
    //     Integer depth = findNodeDepth(node.left, target);
    //     if(depth != null){
    //         return depth + 1;
    //     }
    //     depth = findNodeDepth(node.right, target);
        
    //     if(depth != null){
    //         return depth + 1;
    //     }
        
    //     return null;
        
    // }
    
    // public static void findKDistanceNodes(Node node,int distanceFromNode ,int k, boolean addition){
    //     if(node == null)return;
        
    //     if(Math.abs(distanceFromNode) == k){
    //         ans.add(node.data);
    //     }
        
    //     if(addition){
    //         findKDistanceNodes(node.left, distanceFromNode + 1, k, addition);
    //         findKDistanceNodes(node.right, distanceFromNode + 1, k, addition);
    //     }else{
    //         findKDistanceNodes(node.left, distanceFromNode - 1, k, addition);
    //         findKDistanceNodes(node.right, distanceFromNode - 1, k, addition);
    //     }
    
    
};
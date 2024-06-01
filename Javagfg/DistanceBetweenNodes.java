
class DistanceBetweenNodes {
    static boolean bothFinded;
    int findDist(Node node, int a, int b) {
        // Your code here
        bothFinded = false;
        return find(node,a,b);
        
    }
    
    
    public static int find(Node node, int a, int b){
        if(a == b)return 0;
        int l = node.left != null ? find(node.left, a,b) : 0;
        int r = node.right != null ? find(node.right, a,b) : 0;
        
        if(l != 0 && r != 0){
            bothFinded = true;
            return l+r;
        }
        
        if(l != 0){
            if(node.data == a || node.data == b || bothFinded){
                bothFinded = true;
                return l;
            }
            return l + 1;
        }
        
        if(r != 0){
            if(node.data == a || node.data == b || bothFinded){
                bothFinded = true;
                return r;
            }
            return r + 1;
        }
        
        if( node.data == a || node.data == b ){
            return 1;
        }
        
        return 0;
    }
}
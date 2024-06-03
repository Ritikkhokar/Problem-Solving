class FloorBst {
    static int floor = Integer.MIN_VALUE;
    public static int floor(Node root, int x) {
        // Code here
        floor = Integer.MIN_VALUE;
        find(root,x);
        if(floor == Integer.MIN_VALUE)return -1;
        return floor;
    }
    
    public static void find(Node node, int x){
        
        if(node == null)return ;
        
        if(node.data <= x && node.data>floor){
            floor = node.data;
        }
        
        find(node.left,x);
        find(node.right,x);
    }
}
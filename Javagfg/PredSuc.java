import java.util.*;
class PredSuc {
    static ArrayList<Node> ans = new ArrayList<>();
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        // code here.
        // update pre[0] with the predecessor of the key
        // update suc[0] with the successor of the key
        ans = new ArrayList<>();
        pre[0] = null;
        suc[0] = null;
        find(root,pre,suc,key);
        // System.out.println(ans);
        for(int i=0;i<ans.size();i++){
            if(ans.get(i).data < key){
                    pre[0] = ans.get(i);
            }
            if(ans.get(i).data > key && suc[0] == null){
                    suc[0] = ans.get(i);
            }
            
        }
        // System.out.println(pre[0]);
        // System.out.println(suc[0]);
    }
    
    public static void find(Node root, Node[] pre, Node[] suc, int key){
        if(root == null){
            return;
        }
        
        find(root.left,pre,suc,key);
        ans.add(root);
        find(root.right,pre,suc,key);
    }
}
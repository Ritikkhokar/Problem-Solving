import java.util.*;
class RootToLeafPath {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        
        return find(root, new ArrayList<ArrayList<Integer>>());
        
    //   ArrayList<ArrayList<Integer>>  al1 = new ArrayList<ArrayList<Integer>>();
    //   ArrayList<ArrayList<Integer>>  al2 = new ArrayList<ArrayList<Integer>>();
        
    //     if(root.left != null ){
    //         al1 = Paths(root.left);
    //     }
        
    //     if(root.right != null){
    //         al2 = Paths(root.right);
    //     }
        
        
    //     if(al1.size() == 0 && al2.size() == 0){
    //         al1.add(new ArrayList<Integer>(root.data));
    //         return al1;
    //     }
    //     if(al1.size() > 0){
    //         for(int i=0;i<al1.size();i++){
    //         al1.get(i).add(0,root.data);
    //         } 
    //     }
        
    //     if(al2.size() > 0){
    //         for(int i=0;i<al2.size();i++){
    //         al2.get(i).add(0,root.data);
    //         }  
    //     }
        
        
    //     for(int i=0;i<al2.size();i++){
    //         al1.add(al2.get(i));
    //     } 
        
    //     return al1;

    }
    
    
    public static ArrayList<ArrayList<Integer>> find(Node root, ArrayList<ArrayList<Integer>> ans){
        
        if(root.left ==null && root.right == null){
            ans.add(new ArrayList<Integer>());
            ans.get(ans.size()-1).add(root.data);
            return ans;
        }
        int val = ans.size();
        if(root.left != null){
           find(root.left, ans); 
        }
        
        if(root.right != null){
            find(root.right,ans);
        }
        
        for(int i=val;i<ans.size();i++){
            ans.get(i).add(0,root.data);
        }
        
        return ans;
        
    }
}
        

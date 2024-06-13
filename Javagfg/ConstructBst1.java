import java.util.HashMap;
import java.util.Map;

class ConstructBst1
{
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        // code here 
        Map<Integer, Integer> map = new HashMap<>();
        // for(int i=0;i<inorder.length;i++){
        //     map.put(inorder[i], i);
        // }
       return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1, map);
    }
    
    public static Node build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> map){
       if(inStart>inEnd || preStart > preEnd){
        return null;
       }
       
       Node node = new Node(preorder[preStart]);
       int i = inStart;
        while(inorder[i] != preorder[preStart]){
            i++;
        }
       
       int tne = i - inStart;
       node.left = build(preorder, inorder, preStart + 1, preStart + tne , inStart, i-1, map);
       node.right = build(preorder, inorder, preStart + tne + 1, preEnd, i + 1, inEnd, map);
       return node;
    }
}
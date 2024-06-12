class ConstructBst
{
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int inorder[], int postorder[], int n) {
        // Your code here
        return construct(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    
    public static Node construct(int[] inorder, int[] postorder, int inFirst, int inLast, int postFirst, int postLast){
        if(inFirst>inLast || postFirst>postLast){
            return null;
        }
        Node parent = new Node(postorder[postLast]);
        int i=inFirst;
        while(inorder[i] != postorder[postLast]){
            i++;
        }
        int tne = i - inFirst;
        parent.left = construct(inorder, postorder, inFirst, i-1, postFirst, postFirst + tne - 1);
        parent.right = construct(inorder, postorder, i+1, inLast, postFirst + tne, postLast-1);
        return parent;
    }
}
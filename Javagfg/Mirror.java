import java.util.*;

class Mirror {
    static int checkMirrorTree(int n, int e, int[] A, int[] B) {
        // code here
        Map<Integer, Stack<Integer>> map = new HashMap<>();
        
        for(int i=0;i<A.length;i = i+2){
            if(!map.containsKey(A[i])){
                Stack<Integer> stack = new Stack<>();
                stack.push(A[i+1]);
                map.put(A[i], stack);
            }else{
                map.get(A[i]).push(A[i+1]);
            }
        }
        
        for(int i=0;i<B.length;i = i+2){
            if(!map.containsKey(B[i])){
                return 0;
            }else if(map.get(B[i]).size() != 0 && map.get(B[i]).pop() == B[i+1]){
                continue;
            }else{
                return 0;
            }
            
        }
        return 1;
    }
}
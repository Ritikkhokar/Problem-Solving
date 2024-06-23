import java.util.Stack;

class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	Stack<Integer>st = new Stack<>();
    	for(int i=0;i<n;i++){
    	    st.push(i);
    	}
    	
        while(st.size()>1){
            int ele1 = st.pop();
            int ele2 = st.pop();
            if(M[ele1][ele2] == 1){
                st.push(ele2);
            }else{
                st.push(ele1);
            }
        }
        
        int ans = st.pop();
        
        for(int i=0;i<n;i++){
            if(M[ans][i] == 1 || (ans != i && M[i][ans] == 0)){
                return -1;
            }
        }
        return ans;
    }
}
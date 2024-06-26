import java.util.*;

class Pair{
    String alphabet;
    int frequency;
    
    Pair(String alphabet, int frequency){
        this.alphabet = alphabet;
        this.frequency = frequency;
    }
}

class Solution
{
    public static String reduced_String(int k, String s)
    {
        // Your code goes here
           if(k ==1)return "";
           
        Stack<Pair> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(st.size()>0){
                Pair element = st.peek();
             if(element.alphabet.equalsIgnoreCase(""+ s.charAt(i))){
                 st.pop(); 
                 if(element.frequency < k-1){
                     element.frequency++;
                     st.push(element);
                     continue;
                 }else if(element.frequency == k-1){
                     continue;
                 }
             }
             
            }
            st.push(new Pair(""+ s.charAt(i), 1));
        }
        
        StringBuilder ans=new StringBuilder();
        while(st.size()>0){
            Pair ele = st.pop();
            for(int i=0;i<ele.frequency;i++){
                ans.insert(0,ele.alphabet);
            }
            
        }
        return ans.toString();
    }
    
}
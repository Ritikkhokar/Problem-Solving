import java.util.Stack;

class ValidParenthesis
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        // add your code here
        Stack<Character> st = new Stack<>();
        
        st.push(x.charAt(0));
        for(int i=1;i<x.length();i++){
            char item =  x.charAt(i);
            if(st.size()>0){
                
            if(item == '}' && st.peek() == '{'){
                st.pop();
            }else if(item == ')' && st.peek() == '('){
                st.pop();
            }else if(item == ']' && st.peek() == '['){
                st.pop();
            }else{
                st.push(item);
            }
            }else{
                st.push(item);
            }
        }
        
        if(st.size() == 0){
            return true;
        }else{
            return false;
        }
    }
}

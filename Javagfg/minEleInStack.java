import java.util.Stack;

class minEleInStack
{
    int minEle;
    Stack<Integer> s;
    Stack<Integer> minS;
    // Constructor    
    minEleInStack()
	{
     s = new Stack<>();
     minS = new Stack<>();
     minEle = Integer.MAX_VALUE;
	}
	
    /*returns min element from stack*/
    int getMin()
    {
	// Your code here
	if(minEle == Integer.MAX_VALUE)return -1;
	return minEle;
    }
    
    /*returns poped element from stack*/
    int pop()
    {
	// Your code here	
	if(s.size()>0){
	    if(s.peek() == minEle){
	        minS.pop();
	        minEle = minS.size()>0 ? minS.peek() : Integer.MAX_VALUE;
	    }
	    return s.pop();
	}
	return -1;
}
    /*push element x into the stack*/
    void push(int x)
    {
	// Your code here
	s.push(x);
	if(x<=minEle){
	  minS.push(x); 
	  minEle = x;
	}
	
    }	
}


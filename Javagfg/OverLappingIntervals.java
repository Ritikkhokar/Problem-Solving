import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

class Solution
{
    public int[][] overlappedInterval(int[][] Intervals)
    {
        // Code here // Code here
        Comparator<int[]> customComparator = new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                
                return o1[0] - o2[0]; // For ascending order
            }
        };
        
        Arrays.sort(Intervals, customComparator);
        List<int[]> mergedIntervals = new ArrayList<>();
        Stack<int[]> st = new Stack<>();
        
        for(int i=Intervals.length-1;i>=0;i--){
            st.push(Intervals[i]);
        }
        
        while(st.size() >1){
            int[] val1 = st.pop();
            int[] val2 = st.pop();
            
            if(val2[0]<=val1[1]){
                st.push(new int[]{Math.min(val1[0], val2[0]), Math.max(val1[1], val2[1])});
            }else{
                st.push(val2);
                mergedIntervals.add(val1);
            }
        }
        mergedIntervals.add(st.pop());
        
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
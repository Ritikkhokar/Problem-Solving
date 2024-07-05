import java.util.ArrayList;

public class ConnectedGraphs {
    static int sum =0;
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        sum = 0;
        boolean[] visited = new boolean[adj.size()];
        for(int i=0;i<V;i++){
            if(visited[i] == false){
                sum++;
                countPaths(adj,i, visited);
            }
        }
        
        return sum;
    }
    
    public static void countPaths(ArrayList<ArrayList<Integer>> adj, int v, boolean[] visited){
            
            visited[v] = true;
            for(int j=0;j<adj.get(v).size();j++){
                if(adj.get(v).get(j) == 1 && visited[j] == false){
                    countPaths(adj, j, visited);
                }
            }
        
    }
};

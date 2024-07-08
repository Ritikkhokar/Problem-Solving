import java.util.ArrayList;

class Hamilton 
{ 
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        // code here
        boolean[] visited = new boolean[N+1];
        ArrayList<ArrayList<Integer>> edgesFromVertice = new ArrayList();
        for(int i=0;i<N+1;i++){
            edgesFromVertice.add(new ArrayList());
        }
        for(int i=0;i<M;i++){
            edgesFromVertice.get(Edges.get(i).get(0)).add(Edges.get(i).get(1));
            edgesFromVertice.get(Edges.get(i).get(1)).add(Edges.get(i).get(0));
        }
        
        for(int i=1;i<N+1;i++){
            visited = new boolean[N+1];
            boolean ans = hamilton(
                    edgesFromVertice,
                    visited,
                    0,
                    i,
                    N
                    ); 
                    if(ans)return true;
            
        }
        
        return false;
    }
    
    public static boolean hamilton(
        ArrayList<ArrayList<Integer>> edgesFromVertice, 
        boolean[] visited, 
        int visitCount, int v, int M)
        {
            visited[v] = true;
            visitCount++;
            if(visitCount == M)return true;
            
            for(int i=0;i<edgesFromVertice.get(v).size();i++){
                if(visited[edgesFromVertice.get(v).get(i)] == false){
                 boolean ans = hamilton(
                    edgesFromVertice,
                    visited,
                    visitCount,
                    edgesFromVertice.get(v).get(i),
                    M
                    ); 
                    if(ans)return true;
                }
                
            }
            // if(visitCount == M)return true;
            visited[v] = false;
            visitCount--;
            return false;
        }
} 
//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class WallsColoringII{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int [][] costs = new int[n][k];
			for(int i = 0; i < n; i++) {
				str = br.readLine().trim().split(" ");
				for(int j = 0; j < k; j++) {
					costs[i][j] = Integer.parseInt(str[j]);
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.minCost(costs));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minCost(int [][] costs) {
		//Write your code here
		if(costs.length > 1 && costs[0].length <2){
		    return -1;
		}
		return tabu(costs);
	}
	
	public static int tabu(int [][] costs){
        
        int[][] dp = new int[costs.length][costs[0].length];
        
        for(int i=0;i<costs[0].length;i++){
            dp[0][i] = costs[0][i];
        }
        
        for(int i=1; i<costs.length; i++){
            
            int firstMinIdx =  minIdx(dp, i-1, costs[0].length + 1);
            int secondMinIdx =  minIdx(dp, i-1, firstMinIdx);
            for(int j=0;j< costs[0].length; j++){
                if(j==firstMinIdx){
                 dp[i][j] = costs[i][j] + dp[i-1][secondMinIdx];   
                }else{
                    dp[i][j] = costs[i][j] + dp[i-1][firstMinIdx];
                }
            }
        }
        int minimumIdx = minIdx(dp, costs.length-1, costs[0].length + 1);
        return dp[costs.length-1][minimumIdx];
        
    }
    
    public static int minIdx(int[][] dp, int row, int exceptColumn ){
        int minimum = Integer.MAX_VALUE;
        int minimumIdx = 0;
        for(int i=0;i< dp[0].length;i++){
            if(i!=exceptColumn){
                if(dp[row][i]<minimum){
                    minimum = dp[row][i];
                    minimumIdx = i;
                }
            }
        }
        return minimumIdx;
    }
}

// input
// 4 3
// 1 5 7
// 5 8 4
// 3 2 9
// 1 2 4
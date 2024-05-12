import java.util.Arrays;

class PartionEqualSubset{
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum =0;
        for(int i=0;i<N;i++){
            sum += arr[i];
        }
        int dp[][] = new int[N + 1][sum + 1];
        
        for (int row[] : dp)
            Arrays.fill(row, -1);
        
        if(sum%2 != 0){
            return 0; 
        }else{
           return findSubset(arr, N,sum/2, dp) == false ? 0 : 1;
        }
    }
    
    public static boolean findSubset(int arr[],int n, int target, int[][] dp){
        
        if(target == 0){
            return true;
        }
        
        if(n == 0 && target != 0){
            return false;
        }
        
        if (dp[n][target] != -1) {
            if(dp[n][target] == 1){
                return true;
            }else{
                return false;
            }
            
        }
        
         if (arr[n - 1] > target){
            return findSubset(arr, n - 1, target, dp);
         }
        
        boolean includeSum = findSubset(arr, n-1,target-arr[n-1], dp);
        boolean excludeSum = findSubset(arr, n-1,target, dp);
        if(includeSum || excludeSum){
            dp[n][target] = 1;
        }else{
            dp[n][target] = 0;
        }
        
        return includeSum || excludeSum;
    }
}
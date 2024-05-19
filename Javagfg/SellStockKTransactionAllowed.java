public class SellStockKTransactionAllowed {
        static int maxProfit(int K, int N, int A[]) {
            // code here
            int[][] dp = new int[K+1][N];
            
            for(int i=1; i<=K; i++){
                int max = Integer.MIN_VALUE;;
                for(int j=1;j<N;j++){
                    max = Math.max(max, dp[i-1][j-1] - A[j-1]);
                    dp[i][j] = Math.max(dp[i][j-1], max + A[j]);
                }
            }
            
            return dp[K][N-1];
        }
}

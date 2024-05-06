import java.util.Arrays;

public class PaintFence {

    long countWays(int n,int k)
    {
        //code here.
        if(n==1){
            return k;
        }
        return tabu(n,k);
        
    }
    
    public static long tabu(int n, int k){
// To store results for subproblems
        long dp[] = new long[n + 1];
        Arrays.fill(dp, 0);
        int mod = 1000000007;

        // There are k ways to color first post
        dp[1] = k;

        // There are 0 ways for single post to
        // violate (same color_ and k ways to
        // not violate (different color)
        int same = 0, diff = k;

        // Fill for 2 posts onwards
        for (int i = 2; i <= n; i++) {
            // Current same is same as previous diff
            same = diff;

            // We always have k-1 choices for next post
            diff = (int)(dp[i - 1]%mod* (k - 1)%mod)%mod;
            diff = diff % mod;

            // Total choices till i.
            dp[i] = (same + diff) % mod;
        }

        return dp[n];
    }
    
}




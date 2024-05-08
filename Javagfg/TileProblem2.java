import java.util.Scanner;

class TileProblem2
{
    static int mod=1000000007;
    public static int countWays(int n, int m)
    {
        // Code here
        
        Integer[] dp = new Integer[n+1];
        return memo(n,m,dp);
    }
    
    public static int memo(int n, int m, Integer[] dp){
        
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        
        if(dp[n] != null){
            return dp[n];
        }
        
        // horizontal call
        int hor = memo(n-m, m, dp)%mod;
        
        int ver = memo(n-1, m, dp)%mod;
        
        return dp[n] = (hor + ver)%mod;
         
    }

        public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        System.out.println(countWays(n,m));
    }
}
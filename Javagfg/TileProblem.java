import java.util.Scanner;

class TileProblem {
    static int mod = 1000000007;

    static int numberOfWays(int n) {
        int[] dp = new int[n + 1]; // Array to store subproblem solutions
        dp[0] = 1; // Base case (empty grid has 1 way)

        for (int i = 1; i <= n; i++) {
            if (i >= 2) { // Consider horizontal domino placement
                dp[i] = (dp[i] + dp[i - 2]) % mod;
            }
            dp[i] = (dp[i] + dp[i - 1]) % mod; // Add vertical placement
        }

        return dp[n];
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(numberOfWays(n));
    }
}
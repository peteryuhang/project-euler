public class Solution {
    private static int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
    
    public static void main(String[] args) {
        System.out.println(coinSums(10));
    }

    private static int coinSums(int size) {
        int[] dp = new int[size + 1];

        dp[0] = 1;
        for (int i = 0; i < coins.length; ++i) {
            for (int j = coins[i]; j <= size; ++j) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[size];
    }
}
public class Solution {
    public static void main(String[] args) {
        System.out.println(sumSquareDiff(100L));
    }

    private static long sumSquareDiff(long n) {
        long sumOfSquare = 0;
        long squareOfSum = 0;
        for (long i = 1; i <= n; ++i) {
            sumOfSquare += (long)Math.pow(i, 2);
            squareOfSum += i;
        }

        return (long)Math.pow(squareOfSum, 2) - sumOfSquare;
    }
}
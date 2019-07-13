class Solution {
    public static void main(String[] args) {
        System.out.println(largestPrime(16L));
    }

    private static int largestPrime(long n) {
        int largestPrime = 2;

        while (n % 2 == 0) {
            n >>= 1;
        }

        for (int i = 3; i <= (int)Math.sqrt(n); i += 2) {
            while (n % i == 0 && n != i) {
                n /= (long)i;
            }
        }

        if (n > 2) {
            largestPrime = (int)n;
        }

        return largestPrime;
    }
}
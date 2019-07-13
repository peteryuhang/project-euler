public class Solution {
    public static void main(String[] args) {
        System.out.println(triNumber(500));
    }

    private static int triNumber(int numberOfDivisor) {
        int number = 1;
        int sum = 1;

        while (countPrimes(sum) < numberOfDivisor) {
            ++number;
            sum += number;
        }

        return sum;
    }

    private static int countPrimes(int n) {
        if (n == 1) {
            return 1;
        }

        int count = 1;

        while (n % 2 == 0) {
            n /= 2;
            ++count;
        }

        for (int j = 3; j <= n; j += 2) {
            int curCount = 1;
            while (n % j == 0) {
                n /= j;
                ++curCount;
            }
            count *= curCount;
        }

        return count - 1;
    }
}
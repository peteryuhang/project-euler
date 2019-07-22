import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(quadraticPrime(1000,1000));
    }

    private static int quadraticPrime(int upperLimitA, int upperLimitB) {
        List<Integer> possibleOfB = findAllPossibleB(upperLimitB);

        int maxN = 0;
        int result = 0;
        for (int b : possibleOfB) {
            for (int a = -upperLimitA + 1; a < upperLimitA; ++a) {
                int n = 0;
                while (isPrime(Math.abs(n * n + n * a + b))) {
                    n++;
                }

                if (maxN < n) {
                    maxN = n;
                    result = a * b;
                }
            }
        }
        
        return result;
    }

    private static boolean isPrime(int n) {
        if (n != 2 && n % 2 == 0) {
            return false;
        }

        int nSqrt = (int)Math.sqrt(n);
        
        for (int i = 3; i <= nSqrt; ++i) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static List<Integer> findAllPossibleB(int upperLimit) {
        List<Integer> primes = new ArrayList<>();

        if (upperLimit < 2) {
            return primes;
        }

        primes.add(2);

        for (int i = 3; i <= upperLimit; i += 2) {
            int j = 0;
            boolean isPrime = true;

            while (primes.size() > j && primes.get(j) * primes.get(j) <= i) {
                if (i % primes.get(j) == 0) {
                    isPrime = false;
                    break;
                }

                j++;
            }

            if (isPrime) {
                primes.add(i);
            }
        }

        int size = primes.size();
        for (int i = 0; i < size; ++i) {
            primes.add(-primes.get(i));
        }

        return primes;
    }
}
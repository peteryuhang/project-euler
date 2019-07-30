import java.util.*;

public class Solution {
    private static Set<Integer> primes;
    
    public static void main(String[] args) {
        System.out.println(countCircularPrimes(1000000));
    }

    private static int countCircularPrimes(int upperLimit) {
        List<Integer> allPrimes = obtainAllPrimes(upperLimit);

        primes = new HashSet<Integer>(allPrimes);

        int result = 0;
        for (int prime : allPrimes) {
            if (isCircularPrime(prime)) {
                result++;
            }
        }

        return result;
    }

    private static boolean isCircularPrime(int prime) {
        List<Integer> rotatedNumbers = rotated(prime);

        for (int i : rotatedNumbers) {
            if (!primes.contains(i)) {
                return false;
            }
        }

        return true;
    }

    private static List<Integer> rotated(int prime) {
        List<Integer> digits = new ArrayList<>();

        while (prime != 0) {
            digits.add(prime % 10);
            prime /= 10;
        }

        Collections.reverse(digits);        // **

        int len = digits.size();
        int numOfRotated = len;
        int startIndex = 0;

        List<Integer> ans = new ArrayList<>();
        while (numOfRotated > 0) {
            int cur = 0, count = 0, index = startIndex;
            while (count != len) {
                cur *= 10;
                cur += digits.get(index % len);
                count++; index++;
            }

            startIndex++; numOfRotated--;
            ans.add(cur);
        }

        return ans;
    }

    private static List<Integer> obtainAllPrimes(int upperLimit) {
        List<Integer> primes = new ArrayList<>();

        primes.add(2);

        for (int i = 3; i <= upperLimit; i += 2) {
            int j = 0;
            boolean isPrime = true;
            
            while (primes.size() > j && primes.get(j) * primes.get(j) <= i) {
                if (i % primes.get(j) == 0) {
                    isPrime = false;
                    break;
                }
                ++j;
            }

            if (isPrime) {
                primes.add(i);
            }
        }

        return primes;
    }
}
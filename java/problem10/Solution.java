import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumOfPrimes(2000000));
    }

    private static long sumOfPrimes(int upperLimit) {
        long result = 0;

        List<Integer> primes = new ArrayList<>();

        result += 2L;
        primes.add(2);
        boolean isPrime = true;
        for (int i = 3; i < upperLimit; i += 2) {
            int j = 0;
            isPrime = true;
            
            while (primes.size() > j && primes.get(j) * primes.get(j) <= i) {
                if (i % primes.get(j) == 0) {
                    isPrime = false;
                    break;
                }

                ++j;
            }

            if (isPrime) {
                primes.add(i);
                result += (long)i;
            }
        }

        return result;
    }
}
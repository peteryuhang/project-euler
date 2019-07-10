import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(smallestMultiple(20));
    }

    private static int smallestMultiple(int maxDividor) {
        List<Integer> primes = generatePrimes(maxDividor);
        // System.out.println(primes);
        int result = 1;
        for (int prime : primes) {
            // perform change base formula in log
            int maxfactor = (int)Math.floor(Math.log(maxDividor) / Math.log(prime));

            result *= (int)Math.pow(prime, maxfactor);
        }

        return result;
    }

    private static List<Integer> generatePrimes(int upperLimit) {
        List<Integer> primes = new ArrayList<>();
        
        primes.add(2);
        // except 2, prime must be odd, so we can start at 3 and add 2 each time
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

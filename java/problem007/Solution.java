// Some useful facts:
// 1 is not a prime.
// All primes except 2 are odd.
// All primes greater than 3 can be written in the form 6k+/-1.
// Any number n can have only one primefactor greater than n .
// The consequence for primality testing of a number n is: if we cannot find a number f less than
// or equal n that divides n then n is prime: the only primefactor of n is n itself

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(findNthPrime(10001));
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }

    private static long findNthPrime(int n) {
        List<Long> primes = new ArrayList<>();

        primes.add(2L);

        long primeCandidate = 3;
        
        boolean isPrime = true;
        while (primes.size() != n) {
            int j = 0;
            isPrime = true;
            while ((primes.size() > j) && (primes.get(j) * primes.get(j) <= primeCandidate)) {
                if (primeCandidate % primes.get(j) == 0) {
                    isPrime = false;
                    break;
                }
                ++j;
            }

            if (isPrime) {
                primes.add(primeCandidate);
            }

            primeCandidate += 2L;
        }

        return primes.get(primes.size() - 1);
    }
}
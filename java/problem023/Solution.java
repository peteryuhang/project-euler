
public class Solution {
    private static boolean[] isAbundant = new boolean[28213 + 1];
    
    public static void main(String[] args) {
        System.out.println(nonAbundantSum());
    }

    private static long nonAbundantSum() {
        // record abundant number
        for (int i = 1; i < isAbundant.length; ++i) {
            int sum = factorsSum(i);

            if (sum > i) {
                isAbundant[i] = true;
            }
        }

        long result = 0;
        for (int i = 1; i < isAbundant.length; ++i) {
            boolean isValid = true;
            for (int j = 1; j <= i / 2; ++j) {
                if (isAbundant[j] && isAbundant[i - j]) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                result += i;
            }
        }

        return result;
    }

    private static int factorsSum(int n) {
        if (n == 1) {
            return 0;
        }

        int sum = 0, sqrtN = (int)Math.sqrt(n);
        for (int i = 2; i <= sqrtN; ++i) {
            if (n % i == 0) {
                if (i == n / i) {
                    sum += i;
                } else {
                    sum += i + n / i;
                }
            }
        }

        return sum + 1;
    }
}
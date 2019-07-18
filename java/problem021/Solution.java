import java.util.*;

public class Solution {
    private static int[] d;
    public static void main(String[] args) {
        System.out.println(amicableNumber(10000));
    }

    private static int amicableNumber(int upperLimit) {
        d = new int[upperLimit + 1];

        int result = 0;
        for (int i = 1; i <= upperLimit; ++i) {
            int factorsSum = calculateFactorsSum(i);

            if (factorsSum <= upperLimit && d[factorsSum] == i) {
                result += i + factorsSum;
                d[i] = 0; d[factorsSum] = 0;
            } else {
                d[i] = factorsSum;
            }
        }

        return result;
    }

    private static int calculateFactorsSum(int number) {
        if (number == 1) {
            return 0;
        }

        int result = 0;

        int sqrNumber = (int)Math.sqrt(number);
        for (int i = 2; i <= sqrNumber; ++i) {
            if (number % i == 0) {
                if (i == number / i) {
                    result += i;
                } else {
                    result += i + (number / i);
                }
            }
        }

        return result + 1;
    }
}
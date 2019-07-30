import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(pandigitalProducts());
    }

    private static int pandigitalProducts() {
        int multiplicand = 2, multiplier = 10;

        int result = 0;
        Set<Integer> validProducts = new HashSet<>();
        for (int i = multiplicand; i <= 99; ++i) {
            for (int j = multiplier; j <= 9999; ++j) {
                if (isValid(i, j, i * j) && validProducts.add(i * j)) {
                    System.out.println("" + i + "*" + j + "=" + (j*i));
                    result += i * j;
                }
            }
        }
        // System.out.println(validProducts);
        return result;
    }

    private static boolean isValid(int multiplicand, int multiplier, int product) {
        boolean[] digits = new boolean[10];

        while (multiplicand != 0) {
            if (multiplicand % 10 == 0) {
                return false;
            }

            if (multiplicand != 0 && digits[multiplicand % 10]) {
                return false;
            }

            digits[multiplicand % 10] = true;
            multiplicand /= 10;
        }

        while (multiplier != 0) {
            if (multiplier % 10 == 0) {
                return false;
            }

            if (digits[multiplier % 10]) {
                return false;
            }

            digits[multiplier % 10] = true;
            multiplier /= 10;
        }

        while (product != 0) {
            if (product % 10 == 0) {
                return false;
            }

            if (digits[product % 10]) {
                return false;
            }

            digits[product % 10] = true;
            product /= 10;
        }

        for (int i = 1; i < digits.length; ++i) {
            if (!digits[i]) {
                return false;
            }
        }

        return true;
    }
}
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(digitCancelingFraction());
    }

    private static int digitCancelingFraction() {
        int denominator = 1;
        int nominator = 1;
        for (int i = 10; i <= 99; ++i) {
            for (int j = i + 1; j <= 99; ++j) {
                int[] result = isOneDiffAndNoTrivial(i, j);
                
                if (result.length > 0 
                    && (double)result[0] / (double)result[1] == (double)i / (double)j) {                    
                        nominator *= result[0];
                        denominator *= result[1];                        
                }
            }
        }
        
        return gcd(nominator, denominator);
    }

    private static int gcd(int nominator, int denominator) {
        for (int i = 2; i <= nominator; ++i) {
            while (nominator % i == 0 && denominator % i == 0) {
                nominator /= i;
                denominator /= i;
            }
        }

        return denominator;
    }

    private static int[] isOneDiffAndNoTrivial(int numerator, int denominator) {
        if ((numerator % 10 == 0) && (denominator % 10 == 0)) {
            return new int[0];
        }

        int numerator1 = numerator % 10;
        int numerator2 = numerator / 10;
        int denominator1 = denominator % 10;
        int denominator2 = denominator / 10;

        if (numerator1 == denominator2 && numerator2 < denominator1) {
            return new int[] {numerator2, denominator1};
        }

        if (numerator1 == denominator1 && numerator2 < denominator2) {
            return new int[] {numerator2, denominator2};
        }

        if (numerator2 == denominator2 && numerator1 < denominator1) {
            return new int[] {numerator1, denominator1};
        }

        if (numerator2 == denominator1 && numerator1 < denominator2) {
            return new int[] {numerator1, denominator2};
        }
        
        return new int[0];
    }
}
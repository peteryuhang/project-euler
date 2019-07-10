public class Solution {
    public static void main(String[] args) {
        System.out.println(palindromProduct(3));
    }

    private static int palindromProduct(int numberOfDigits) {
        int maxValue = (int)Math.pow(10.0, (double)numberOfDigits);
        int minValue = (int)Math.pow(10.0, (double)(numberOfDigits - 1));

        int largestPalindrom = -1;
        for (int i = minValue; i < maxValue; ++i) {
            for (int j = minValue; j < maxValue; ++j) {
                if (isPalindromNumber(String.valueOf(i * j))) {
                    largestPalindrom = Math.max(largestPalindrom, i * j);
                }
            }
        }

        return largestPalindrom;
    }

    private static boolean isPalindromNumber(String n) {
        char[] nArr = n.toCharArray();
        int l = 0, r = nArr.length - 1;
        while (l < r) {
            if (nArr[l++] != nArr[r--]) {
                return false;
            }
        }

        return true;
    }
}
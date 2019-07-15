public class Solution {
    public static void main(String[] args) {
        System.out.println(powerDigitSum(1));
    }

    private static int powerDigitSum(int power) {
        String start = "2";
        
        int p = 1;

        while (p != power) {
            start = addTwoString(start, start);
            ++p;
        }

        int result = 0;
        for (char r : start.toCharArray()) {
            result += r - '0';
        }

        return result;
    }

    private static String addTwoString(String a, String b) {
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();

        String result = "";

        int indexA = aArr.length - 1, indexB = bArr.length - 1;
        int carry = 0;
        while (indexA >= 0 || indexB >= 0) {
            int nextDigit = (bArr[indexB] - '0') + (aArr[indexA] - '0') + carry;

            if (nextDigit > 9) {
                nextDigit = nextDigit - 10;
                carry = 1;
            } else {
                carry = 0;
            }

            result = nextDigit + result;

            --indexA; --indexB;
        }

        if (carry != 0) {
            result = carry + result;
        }

        return result;
    }
}
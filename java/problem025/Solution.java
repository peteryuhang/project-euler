public class Solution {
    public static void main(String[] args) {
        System.out.println(fibonacciNumber(1000));
    }

    private static int fibonacciNumber(int order) {
        String fibCurrent = "1";
        String fibNext = "1";

        int index = 2;
        while (fibNext.length() < order) {
            String res = addTwoString(fibCurrent, fibNext);
            fibCurrent = fibNext;
            fibNext = res;
            index++;
        }

        return index;
    }

    private static String addTwoString(String a, String b) {
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();

        int indexA = aArr.length - 1, indexB = bArr.length - 1;
        int carry = 0;
        String result = "";
        int cur;
        while (indexA >= 0 || indexB >= 0) {
            cur = carry;
            if (indexA >= 0) {
                cur += aArr[indexA--] - '0';
            }

            if (indexB >= 0) {
                cur += bArr[indexB--] - '0';
            }

            carry = cur / 10;
            result = (cur % 10) + result;
        }

        if (carry != 0) {
            result = carry + result;
        }

        return result;
    }
}
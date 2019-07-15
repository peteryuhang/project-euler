import java.util.*;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(factorialDigitSum(100));
        long endTime = System.nanoTime();

        // for 2000!, using StringBuilder -> 2457106484; using String -> 9165838259
        System.out.println("Running time: " + (endTime - startTime)); 
    }

    private static int factorialDigitSum(int lastFactor) {
        int start = 2;
        String multiplyResult = "1";
        while (start <= lastFactor) {
            multiplyResult = multiplyTwoString(multiplyResult, String.valueOf(start));
            start++;
        }

        int sumResult = 0;
        for (char digit : multiplyResult.toCharArray()) {
            sumResult += digit - '0';
        }

        return sumResult;
    }

    private static String multiplyTwoString(String a, String b) {
        char[] bArr = b.toCharArray();
        char[] aArr = a.toCharArray();

        List<String> digitResult = new ArrayList<>();

        for (int i = bArr.length - 1; i >= 0; --i) {
            int carry = 0;
            StringBuilder curDigitResult = new StringBuilder();
            // String curDigitResult = "";
            for (int j = aArr.length - 1; j >= 0; --j) {
                int tmp = (bArr[i] - '0') * (aArr[j] - '0') + carry;
                
                carry = tmp / 10;                
                
                tmp %= 10;
                
                curDigitResult.insert(0, Integer.toString(tmp));
                // curDigitResult = tmp + curDigitResult;
            }

            if (carry != 0) {
                curDigitResult.insert(0, Integer.toString(carry));
                // curDigitResult = carry + curDigitResult;
            }

            int endZero = digitResult.size();
            
            while (endZero != 0) {
                curDigitResult.append("0");
                // curDigitResult += "0";
                endZero--;
            }

            digitResult.add(curDigitResult.toString());
            // digitResult.add(curDigitResult);
        }

        String finalResult = digitResult.size() != 0 ? digitResult.get(0) : "0";
        for (int i = 1; i < digitResult.size(); ++i) {
            finalResult = addTwoString(finalResult, digitResult.get(i));
        }
        
        return finalResult;
    }

    private static String addTwoString(String a, String b) {
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        
        int indexA = aArr.length - 1, indexB = bArr.length - 1;
        
        int carry = 0;
        
        StringBuilder result = new StringBuilder();
        // String result = "";
        while (indexA >= 0 || indexB >= 0) {
            int curRes = 0;
            if (indexA >= 0) {
                curRes += aArr[indexA--] - '0';
            }

            if (indexB >= 0) {
                curRes += bArr[indexB--] - '0';
            }

            curRes += carry;

            carry = curRes / 10;

            curRes %= 10;
            result.insert(0, Integer.toString(curRes));
            // result = curRes + result;
        }

        if (carry != 0) {
            result.insert(0, Integer.toString(carry));
            // result = carry + result;
        }

        return result.toString();
        // return result;
    }
}
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(lexicographicPermu(10, 1000000L));
    }

    private static String lexicographicPermu(int numberOfDigit, long target) {
        int copyOfNumerOfDigit = numberOfDigit;
        long copyOfTarget = target;

        List<Integer> candidate = new ArrayList<>();
        for (int i = 0; i < copyOfNumerOfDigit; ++i) {
            candidate.add(i);
        }

        String result = "";

        while (copyOfNumerOfDigit != 0) {
            long totalPermutation = 1;
            int n = copyOfNumerOfDigit;
            while (n != 1) {
                totalPermutation *= n;
                n--;
            }
            
            int selection = (int)((copyOfTarget - 1) / (totalPermutation / copyOfNumerOfDigit));

            result += candidate.remove(selection);
            copyOfTarget -= (totalPermutation / copyOfNumerOfDigit) * selection;
            copyOfNumerOfDigit--;
            copyOfTarget = copyOfTarget <= 0 ? 0 : copyOfTarget;
        }

        return result;
    }
}
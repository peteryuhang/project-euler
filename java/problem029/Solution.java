import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(distinctPowers(2, 100, 2, 100));
    }

    private static int distinctPowers(int aStart, int aEnd, int bStart, int bEnd) {
        Set<Double> terms = new HashSet<>();

        for (int a = aStart; a <= aEnd; ++a) {
            for (int b = bStart; b <= bEnd; ++b) {
                terms.add(Math.pow(a, b));
            }
        }
        
        return terms.size();
    }
}
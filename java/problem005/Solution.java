import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(smallestMultiple(10));
    }

    private static int smallestMultiple(int maxDividor) {
        int i = 20;
 
        while (i %  2 != 0 || i %  3 != 0 || i %  4 != 0 || i %  5 != 0 ||
                i %  6 != 0 || i %  7 != 0 || i %  8 != 0 || i %  9 != 0 ||
                i % 10 != 0 || i % 11 != 0 || i % 12 != 0 || i % 13 != 0 ||
                i % 14 != 0 || i % 15 != 0 || i % 16 != 0 || i % 17 != 0 ||
                i % 18 != 0 || i % 19 != 0 || i % 20 != 0 ){
            i += 20;
        }

        return i;
    }
}
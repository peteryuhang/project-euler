import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(reciprocalCycles(1000));
    }

    private static int reciprocalCycles(int upperLimit) {
        int maxLength = 0, result = 0;
                
        for (int i = upperLimit - 1; i > 1; --i) {
            if (maxLength > i) {
                break;
            }

            int[] digitPosition = new int[i];

            int position = 0;
            int value = 1;

            while (digitPosition[value] == 0 && value != 0) {
                digitPosition[value] = position;
                value *= 10;
                value %= i;
                position++;
            }

            if (position - digitPosition[value] > maxLength) {
                result = i; 
                maxLength = position - digitPosition[value];
            }
        }

        return result;
    }
}
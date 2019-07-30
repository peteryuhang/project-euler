public class Solution {
    private static int[] factorials = new int[10];

    public static void main(String[] args) {
        System.out.println(digitalFactorials());
    }

    private static int digitalFactorials() {
        int upperLimit = 2540160;

        factorials[0] = 1;
        for (int i = 1; i < 10; ++i) {
            factorials[i] = factorials[i - 1] * i;
        }

        int result = 0;
        for (int i = 10; i < upperLimit; ++i) {
            int sumOfFactorials = calFactorials(i);
            if (sumOfFactorials == i) {
                result += i;
            }
        }

        return result;
    }

    private static int calFactorials(int i) {
        int result = 0;
        
        while (i != 0) {
            result += factorials[i % 10];
            i /= 10;
        }

        return result;
    }
}
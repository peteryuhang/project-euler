public class Solution {

    public static void main(String[] args) {
        System.out.println(pythagoreanTriplet());
    }

    public static int pythagoreanTriplet() {
        for (int a = 1; a < 333; ++a) {
            for (int b = a + 1; b + a < 666; ++b) {
                if (a * a + b * b == (1000 - (a + b)) * (1000 - (a + b))) {
                    return a * b * (1000 - a - b);
                }
            }
        }

        return -1;
    }
}
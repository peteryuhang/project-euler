public class Solution {
    public static void main(String[] args) {
        System.out.println(spiralDiagonals(500));
    }

    private static int spiralDiagonals(int size) {
        // f(n) = 4 * (2n + 1) ^ 2 - 12n + f(n - 1)
        if (size == 0) {
            return 1;
        }

        return 4 * (2 * size + 1) * (2 * size + 1) - 12 * size + spiralDiagonals(size - 1);
    }
}
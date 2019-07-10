// based on the formular n(n + 1) / 2 = sum(n)
// for we assume f(n) = sum(n^2) = an^3 + bn^2 + cn + d
// d = 0
// a + b + c + d = 1
// 8a + 4b + 2c + d = 5
// 27a + 9b + 3c + d = 14
// then we can get sum(n^2) = n(2n + 1)(n + 1)/6

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(sumSquareDiff(100));
    }

    private static int sumSquareDiff(int n) {
        return (int)Math.pow(n * (n + 1) / 2, 2) - n * (2 * n + 1) * (n + 1) / 6;
    }
}
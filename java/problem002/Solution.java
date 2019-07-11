class Solution {
    private static long sum = 0;
    public static void main(String[] args) {
        fibonacci(1, 2);
        System.out.println(sum);
    }

    private static long fibonacci(long prev, long cur) {
        if (cur > 4000000) {
            return 0;
        }

        if ((cur & 1) == 0) {
            sum += cur;
        }

        return fibonacci(cur, prev + cur);
    }
}
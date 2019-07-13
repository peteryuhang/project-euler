public class Solution {
    public static void main(String[] args) {
        System.out.println(longestCollatzSequence(1000000L));
    }

    private static int longestCollatzSequence(long start) {        
        int maxLength = 0;

        int result = 0;

        int[] cache = new int[(int)start + 1];

        for (int i = 1; i <= start; ++i) {
            long tmp = i;
            int length = 1;

            while (tmp != 1) {
                if (cache.length > tmp && cache[(int)tmp] != 0) {
                    length += cache[(int)tmp];
                    break;
                }

                if ((tmp & 1) == 0) {
                    tmp /= 2;
                } else {
                    tmp = 3 * tmp + 1;
                }

                ++length;
            }

            if (maxLength < length) {
                result = i;
                maxLength = length;
            }

            cache[i] = length;
        }

        return result;
    }
}
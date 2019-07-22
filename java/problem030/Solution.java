public class Solution {
    public static void main(String[] args) {
        System.out.println(digitFifthPowers(5));
    }

    private static int digitFifthPowers(int powers) {
        int[] digitPowers = new int[10];

        for (int i = 0; i < 10; ++i) {
            digitPowers[i] = (int)Math.pow(i, powers);
        }

        int result = 0;
        int number = 2;
        while (number <= 389000) {
            if (number == Integer.MAX_VALUE) {
                break;
            }

            int sum = 0;

            int tmp = number;

            while (tmp != 0) {
                sum += digitPowers[(tmp % 10)];
                tmp /= 10;
            }

            if (number == sum) {
                result += number;
            }
            
            number++;
        }

        return result;
    }
}
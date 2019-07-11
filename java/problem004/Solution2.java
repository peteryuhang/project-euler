// we assume the result will be 
// abccba = 100000a + 10000b + 1000c + 100c + 10b + a = 11 * (9091a + 910b + 100c)
// m * n = 11 * (9091a + 910b + 100c) 
// we need to find m and n, please note that m and n must be three digits number

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(palindromProduct());
    }

    private static int palindromProduct() {
        for (int a = 9; a >= 1; --a) {
            for (int b = 9; b >= 0; --b) {
                for (int c = 9; c >= 0; --c) {
                    int result = 9091 * a + 910 * b + 100 * c;
                    
                    for (int n = 90; n >= 10; --n) {
                        if (result % n == 0 && result / n <= 999) {
                            return result * 11;
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}
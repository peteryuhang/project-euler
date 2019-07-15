import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(numberLetterCount(1000));
    }

    private static int numberLetterCount(int upperLimit) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(1, 3);          // one
        map.put(2, 3);          // two
        map.put(3, 5);          // three
        map.put(4, 4);          // four
        map.put(5, 4);          // five
        map.put(6, 3);          // six
        map.put(7, 5);          // seven
        map.put(8, 5);          // eight
        map.put(9, 4);          // nine
        map.put(10, 3);         // ten
        map.put(11, 6);         // eleven
        map.put(12, 6);         // twelve
        map.put(13, 8);         // thirteen
        map.put(14, 8);         // fourteen
        map.put(15, 7);         // fifteen
        map.put(16, 7);         // sixteen
        map.put(17, 9);         // seventeen
        map.put(18, 8);         // eighteen
        map.put(19, 8);         // nineteen
        map.put(20, 6);         // twenty
        map.put(30, 6);         // thirty
        map.put(40, 5);         // forty
        map.put(50, 5);         // fifty
        map.put(60, 5);         // sixty
        map.put(70, 7);         // seventy
        map.put(80, 6);         // eighty
        map.put(90, 6);         // ninety
        map.put(100, 7);        // hundred
        
        int result = 0;
        for (int i = 1; i <= upperLimit; ++i) {
            int previous = result;
            if (map.containsKey(i)) {
                result += map.get(i);
            } else if (i / 100 == 0) {
                result += map.get((i / 10) * 10) + map.getOrDefault(i % 10, 0);
            } else if (i / 100 > 0 && i / 100 <= 9) {
                result += map.get(i / 100) + map.get(100);
                
                if (map.containsKey(i % 100)) {
                    result += 3 + map.get(i % 100);
                } else if (i % 100 != 0) {
                    result += 3 + map.get(i % 100 - i % 10) + map.getOrDefault(i % 10, 0);
                }
            } else {
                result += map.get(i / 1000) + 8;
            }
        }

        return result;
    }
}
public class Solution {
  public static void main(String[] args) {
    int sum = 0;
    
    int multiplesOfThree = 3;
    while (multiplesOfThree < 1000) {
      if (multiplesOfThree < 1000 && multiplesOfThree % 3 == 0 && multiplesOfThree % 5 != 0) {
        sum += multiplesOfThree;
      }
      multiplesOfThree += 3;
    }
    
    int multiplesOfFive = 5;
    while (multiplesOfFive < 1000) {
      if (multiplesOfFive < 1000 && multiplesOfFive % 5 == 0) {
        sum += multiplesOfFive;
      }
      multiplesOfFive += 5;
    }

    System.out.println(sum);
  }
}
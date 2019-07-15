public class Solution {
    private static int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) {
        System.out.println(countingSundays(1901, 2000, 2));
    }

    private static int countingSundays(int startYear, int endYear, int startDay) {
        int count = 0;
        
        int day = startDay;

        int year = startYear;

        int month = 1;

        while (year <= endYear) {
            int totalDaysOfMonth = months[month - 1];
            
            if (month == 2) {
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    totalDaysOfMonth += 1;
                }
            }

            if (day == 7) {
                count++;
            }
            
            day += totalDaysOfMonth % 7;
            
            if (day > 7) {
                day %= 7;
            }
            
            month++;
            
            if (month > 12) {
                month = 1;
                year++;
            }
        }

        return count;
    }
}
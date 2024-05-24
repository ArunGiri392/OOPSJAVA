import java.util.*;

public class Date {
    public String solution(String date) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String latestDate = "xx-xx";

        for (int month = 1; month <= 12; month++) {
            for (int day = 1; day <= daysInMonth[month - 1]; day++) {
                String mm = (month < 10) ? "0" + month : "" + month;
                String dd = (day < 10) ? "0" + day : "" + day;
                if (matches(date, mm + "-" + dd) && isLater(mm + "-" + dd, latestDate)) {
                    latestDate = mm + "-" + dd;
                }
            }
        }
        return latestDate;
    }

    private boolean matches(String pattern, String date) {
        for (int i = 0; i < 5; i++) {
            if (pattern.charAt(i) != '?' && pattern.charAt(i) != date.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isLater(String newDate, String latestDate) {
        return latestDate.equals("xx-xx") || newDate.compareTo(latestDate) > 0;
    }

    static void main(String[] args) {
        Date sol = new Date();
        System.out.println(sol.solution("?1-31")); // Should return "01-31"
        System.out.println(sol.solution("02-??")); // Should return "02-28"
        System.out.println(sol.solution("??-42")); // Should return "xx-xx"
        System.out.println(sol.solution("09-31")); // Should return "xx-xx"
    }
}

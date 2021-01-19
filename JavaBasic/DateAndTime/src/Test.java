import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 * 做一个日历
 *
 * @author RABBIT2002
 * @date  2021/1/6
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("Input year and month (space to split):");
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();

        int date = -1;
        int startDayInWeek = -1;
        int weekOfMonth = -1;
        int dayOfMouth = -1;

        boolean isToday = false;

        Calendar calendar = Calendar.getInstance();
        if (calendar.get(Calendar.YEAR) == year && calendar.get(Calendar.MONTH) + 1 == month) {
            isToday = true;
            date = calendar.get(Calendar.DATE);
        } else {
            calendar.clear();
            calendar.clear();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month - 1);
        }

        startDayInWeek = cacuStart(calendar);
        weekOfMonth = cacuWeek(calendar);
        dayOfMouth = cacuDay(calendar);

        // System.out.println(startDayInWeek);
        // System.out.println(weekOfMonth);
        // System.out.println(dayOfMouth);

        System.out.println("SUN MON TUE WED THU FRI SAT");
        int temp = 1;
        for (int i = 1; i <= weekOfMonth * 7; i++) {
            if (i < startDayInWeek) {
                System.out.print(" - ");
            } else if (i > dayOfMouth + startDayInWeek - 1) {
                System.out.print(" - ");
            } else {
                if (isToday && i == date + startDayInWeek - 1) {
                    System.out.printf("%2s*", temp);
                } else {
                    System.out.printf("%2s ", temp);
                }
                temp++;
            }
            System.out.print(" ");
            if (i % 7 == 0) {
                System.out.println();
            }
        }
    }

    public static void show(Calendar calendar) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd EEEE");
        System.out.println(simpleDateFormat.format(calendar.getTime()));
    }

    public static int cacuStart(Calendar calendar) {
        setStartInMonth(calendar);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public static int cacuWeek(Calendar calendar) {
        setEndInMonth(calendar);
        return calendar.get(Calendar.WEEK_OF_MONTH);
    }

    public static int cacuDay(Calendar calendar) {
        setEndInMonth(calendar);
        return calendar.get(Calendar.DATE);
    }

    private static void setStartInMonth(Calendar calendar) {
        calendar.set(Calendar.DATE, 1);
    }

    private static void setEndInMonth(Calendar calendar) {
        calendar.set(Calendar.DATE, 1);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DATE, -1);
    }
}

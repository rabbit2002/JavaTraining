package datatime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * java.time.* 是 JDK8 新提供的 包
 * <p>
 * LocalDate类  LocalTime类 LocalDateTime类
 * <p>
 * LocalDateTime类, LocalDate类, LocalTime类 都是 final class 也是 immutable class
 * LocalDateTime实例, LocalDate实例, LocalTime实例 是 immutable object
 * <p>
 * 构造器
 * private LocalDateTime(LocalDate date, LocalTime time);
 * <p>
 * 类属性
 * public static final LocalDateTime MIN = LocalDateTime.of(LocalDate.MIN, LocalTime.MIN);
 * public static final LocalDateTime MAX=LocalDateTime.of(LocalDate.MAX,LocalTime.MAX);
 * <p>
 * 实例属性
 * private final LocalDate date;
 * private final LocalTime time;
 * <p>
 * 类方法
 * public static LocalDateTime now([...]);
 * public static LocalDateTime of(...);
 * public static LocalDateTime of(LocalDate date, LocalTime time);
 * public static LocalDateTime ofEpochSecond(long epochSecond, int nanoOfSecond, ZoneOffset offset);
 * <p>
 * public static LocalDateTime ofInstant(Instant instant, ZoneId zone);
 * public static LocalDateTime from(TemporalAccessor temporal);
 * public static LocalDateTime parse(CharSequence text[, DateTimeFormatter formatter]);
 * <p>
 * 实例方法
 * getXXX(): // 获取 指定字段 的值
 * public LocalDate toLocalDate();
 * public int getYear();
 * public int getMonthValue();
 * public Month getMonth();
 * public int getDayOfMonth();
 * public int getDayOfYear();
 * public DayOfWeek getDayOfWeek();
 * ---
 * public LocalTime toLocalTime();
 * public int getHour();
 * public int getMinute();
 * public int getSecond();
 * public int getNano();
 * <p>
 * withXXX(): // 设置 指定字段 的值, 并返回新的 LocalDate实例
 * public LocalDate withYear(int year);
 * public LocalDate withMonth(int month);
 * public LocalDate withDayOfMonth(int dayOfMonth);
 * public LocalDate withDayOfYear(int dayOfYear);
 * ---
 * public LocalTime withHour(int hour);
 * public LocalTime withMinute(int minute);
 * public LocalTime withSecond(int second);
 * public LocalTime withNano(int nanoOfSecond);
 * <p>
 * plusXXX(): // 在 当前LocalDate实例 基础上, 添加 指定字段 的一段 指定时间, 并返回新的 LocalDate实例
 * public LocalDate plusYears(long yearsToAdd);
 * public LocalDate plusMonths(long monthsToAdd);
 * public LocalDate plusWeeks(long weeksToAdd);
 * public LocalDate plusDays(long daysToAdd);
 * ---
 * public LocalTime withHour(int hour);
 * public LocalTime withMinute(int minute);
 * public LocalTime withSecond(int second);
 * public LocalTime withNano(int nanoOfSecond);
 * <p>
 * minusXXX(): // 在 当前LocalDate实例 基础上, 减少 指定字段 的一段 指定时间, 并返回新的 LocalDate实例
 * public LocalDate minusYears(long yearsToSubtract);
 * public LocalDate minusMonths(long monthsToSubtract);
 * public LocalDate minusWeeks(long weeksToSubtract);
 * public LocalDate minusDays(long daysToSubtract);
 * ---
 * public LocalTime plusHours(long hoursToAdd);
 * public LocalTime plusMinutes(long minutesToAdd);
 * public LocalTime plusSeconds(long secondstoAdd);
 * public LocalTime plusNanos(long nanosToAdd);
 * <p>
 * public OffsetDateTime atOffset(ZoneOffset offset);
 * public ZonedDateTime atZone(ZoneId zone);
 * <p>
 * public int compareTo(ChronoLocalDateTime<?> other);
 * public boolean isAfter(ChronoLocalDateTime<?> other);
 * public boolean isBefore(ChronoLocalDateTime<?> other);
 * public boolean isEqual(ChronoLocalDateTime<?> other);
 * <p>
 * public boolean equals(Object obj);
 * public int hashCode();
 * public String toString();
 * <p>
 * 其他说明
 * <p>
 * <p>
 * LocalDateTime localDate / localTime 之间相互转换
 * LocalDateTime -> localDate / localTime:
 * LocalDate localDate = localDateTime.toLocalDate();
 * LocalTime localTime = localDateTime.toLocalTime();
 * localDate -> LocalDateTime:
 * LocalDateTime localDateTime = localDate.atTime(...);
 * localTime -> LocalDateTime:
 * LocalDateTime localDateTime = localTime.atDate(LocalDate date)
 *
 * @author RABBIT2002
 * @date 2020/12/26
 */
public class LocalDateTimeClass {
    public static void main(String[] args) {
        func1();
    }

    private static void func0() {
        LocalDate localDate = null;
        LocalTime localTime = null;
        LocalDateTime localDateTime = null;
    }

    private static void func1() {
        // 调用 类方法: LocalDateTime.now() 获得 当前日期时间 的 LocalDateTime实例
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        System.out.println(localDateTimeNow);

        // 调用 类方法: LocalDateTime of() 获得 指定日期时间 的 LocalDateTime实例
        LocalDateTime dateTime1 = LocalDateTime.of(
                2000, 1, 1, 1, 1, 1, 123456789);
        System.out.println(dateTime1);

        LocalDateTime dateTime2 = LocalDateTime.of(
                LocalDate.of(2010, 10, 10),
                LocalTime.of(20, 10, 30, 987654321));
        System.out.println(dateTime2);

    }
}

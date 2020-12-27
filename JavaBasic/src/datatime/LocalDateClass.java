package datatime;

/**
 * LocalDate类
 * <p>
 * 构造器
 * private LocalDate(int year, int month, int dayOfMonth);
 * <p>
 * 类属性
 * public static final LocalDate MIN = LocalDate.of(Year.MIN_VALUE, 1, 1); // Year.MIN_VALUE = -999_999_999
 * public static final LocalDate MAX = LocalDate.of(Year.MAX_VALUE, 12, 31); // Year.MAX_VALUE = 999_999_999;
 * public static final LocalDate EPOCH = LocalDate.of(1970, 1, 1);
 * <p>
 * 实例属性
 * private final int year;
 * private final short month;
 * private final short day;
 * <p>
 * 类方法
 * public static LocalDate now([...]); // 当前时间
 * public static LocalDate of(...); // 指定时间
 * public static LocalDate ofYearDay(int year, int dayOfYear); // year年, dayOfYear天
 * public static LocalDate ofEpochDay(long epochDay); // 1970年1月1日后 epochDay 天
 * <p>
 * public static LocalDate ofInstant(Instant instant, ZoneId zone);
 * public static LocalDate from(TemporalAccessor temporal);
 * public static LocalDate parse(CharSequence text[, DateTimeFormatter formatter]);
 * <p>
 * 实例方法
 * public boolean isLeapYear(); // 判断是否闰年
 * <p>
 * getXXX(): // 获取 指定字段 的值
 * public int getYear();
 * public int getMonthValue();
 * public Month getMonth();
 * public int getDayOfMonth();
 * public int getDayOfYear();
 * public DayOfWeek getDayOfWeek();
 * <p>
 * withXXX(): // 设置 指定字段 的值, 并返回新的 LocalDate实例
 * public LocalDate withYear(int year);
 * public LocalDate withMonth(int month);
 * public LocalDate withDayOfMonth(int dayOfMonth);
 * public LocalDate withDayOfYear(int dayOfYear);
 * <p>
 * plusXXX(): // 在 当前LocalDate实例 基础上, 添加 指定字段 的一段 指定时间, 并返回新的 LocalDate实例
 * public LocalDate plusYears(long yearsToAdd);
 * public LocalDate plusMonths(long monthsToAdd);
 * public LocalDate plusWeeks(long weeksToAdd);
 * public LocalDate plusDays(long daysToAdd);
 * <p>
 * minusXXX(): // 在 当前LocalDate实例 基础上, 减少 指定字段 的一段 指定时间, 并返回新的 LocalDate实例
 * public LocalDate minusYears(long yearsToSubtract);
 * public LocalDate minusMonths(long monthsToSubtract);
 * public LocalDate minusWeeks(long weeksToSubtract);
 * public LocalDate minusDays(long daysToSubtract);
 * <p>
 * public LocalDateTime atTime(LocalTime time);
 * public LocalDateTime atTime(int hour, int minute[, int second[, int nanoOfSecond]]);
 * public OffsetDateTime atTime(OffsetTime time);
 * <p>
 * public int compareTo(ChronoLocalDate other);
 * public boolean isAfter(ChronoLocalDate other);
 * public boolean isBefore(ChronoLocalDate other);
 * public boolean isEqual(ChronoLocalDate other);
 * <p>
 * public boolean equals(Object obj);
 * public int hashCode();
 * public String toString();
 * <p>
 * 其他说明
 * <p>
 *
 * @author RABBIT2002
 * @date 2020/12/27
 */
public class LocalDateClass {
}

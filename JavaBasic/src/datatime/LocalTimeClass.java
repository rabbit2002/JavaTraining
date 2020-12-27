package datatime;

/**
 * <p>
 * 构造器
 * private LocalTime(int hour, int minute, int second, int nanoOfSecond);
 * <p>
 * 类属性
 * public static final LocalTime MIN;
 * public static final LocalTime MAX;
 * public static final LocalTime MIDNIGHT;
 * public static final LocalTime NOON;
 * <p>
 * 实例属性
 * private final byte hour;
 * private final byte minute;
 * private final byte second;
 * private final int nano;
 * <p>
 * 类方法
 * public static LocalTime now([...]);
 * public static LocalTime of(...);
 * public static LocalTime ofSecondOfDay(long secondOfDay);
 * public static LocalTime ofNanoOfDay(long nanoOfDay);
 * <p>
 * public static LocalTime ofInstant(Instant instant, ZoneId zone);
 * public static LocalTime from(TemporalAccessor temporal);
 * public static LocalTime parse(CharSequence text[, DateTimeFormatter formatter]);
 * <p>
 * 实例方法
 * getXXX(): // 获取 指定字段 的值
 * public int getHour();
 * public int getMinute();
 * public int getSecond();
 * public int getNano();
 * <p>
 * withXXX(): // 设置 指定字段 的值, 并返回新的 LocalTime实例
 * public LocalTime withHour(int hour);
 * public LocalTime withMinute(int minute);
 * public LocalTime withSecond(int second);
 * public LocalTime withNano(int nanoOfSecond);
 * <p>
 * plusXXX(): // 在 当前LocalTime实例 基础上, 添加 指定字段 的一段 指定时间, 并返回新的 LocalTime实例
 * public LocalTime plusHours(long hoursToAdd);
 * public LocalTime plusMinutes(long minutesToAdd);
 * public LocalTime plusSeconds(long secondstoAdd);
 * public LocalTime plusNanos(long nanosToAdd);
 * <p>
 * minusXXX(): // 在 当前LocalTime实例 基础上, 减少 指定字段 的一段 指定时间, 并返回新的 LocalTime实例
 * public LocalTime minusHours(long hoursToSubtract);
 * public LocalTime minusMinutes(long minutesToSubtract);
 * public LocalTime minusSeconds(long secondsToSubtract);
 * public LocalTime minusNanos(long nanosToSubtract);
 * <p>
 * public LocalDateTime atDate(LocalDate date);
 * <p>
 * public int compareTo(LocalTime other);
 * public boolean isAfter(LocalTime other);
 * public boolean isBefore(LocalTime other);
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
public class LocalTimeClass {
}

package datatime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * LocalDateTime类 实例属性 由 LocalDate类 实例 和 LocalTime类 实例 共同组成
 * <p>
 * java.time.* package 是 JDK8 新提供的 包
 * LocalDateTime类, LocalDate类, LocalTime类 都是 final class 也是 immutable class
 * LocalDateTime实例, LocalDate实例, LocalTime实例 是 immutable object
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

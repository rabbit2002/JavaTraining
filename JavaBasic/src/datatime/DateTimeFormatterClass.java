package datatime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * java.time.format.DateTimeFormatter JDK8 中 提供的对日期的格式化类
 * // 格式化字符串
 * DateTimeFormatter.ISO_XXX.format()
 * // 获取一个 DateTimeFormatter实例
 * DateTimeFormatter.ofPattern(String pattern);
 *
 * @author RABBIT2002
 * @date 2020/12/28
 */
public class DateTimeFormatterClass {
    public static void main(String[] args) {
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(localDateTime1));
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE.format(localDateTime1));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("G yyyy-MM-dd EEEE HH:mm:ss.SSS zzzz");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime1, ZoneId.systemDefault());
        System.out.println(dateTimeFormatter.format(zonedDateTime));

        String s = "公元 2020-12-28 星期一 22:33:00.039 中国标准时间";
        // 1. 使用 目标类的parse 方法 通过指定 formatter 解析字符串
        ZonedDateTime zonedDateTime1= ZonedDateTime.parse(s,dateTimeFormatter);
        System.out.println(zonedDateTime1);
        // 2. 使用 dateTimeFormatter实例 的parse()方法 解析指定的字符串, 并返回 TemporalAccessor类的实例
        TemporalAccessor temporalAccessor = dateTimeFormatter.parse(s);
        // 再通过 目标类的 from方法 将 TemporalAccessor类的实例 转换为 目标类的实例
        ZonedDateTime zonedDateTime2 = ZonedDateTime.from(temporalAccessor);
        System.out.println(zonedDateTime2);
    }
}

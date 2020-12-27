package datatime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * ZonedDateTime 表示有 时区 和 时区偏移量 的 时间
 * <p>
 * private final LocalDateTime dateTime;
 * private final ZoneOffset offset;
 * private final ZoneId zone;
 *
 * ZonedDateTime 与 LocalDateTime 转换:
 * ZonedDateTime -> LocalDateTime:
 * LocalDateTime localDateTime =zonedDateTime.toLocalDateTime();
 * LocalDateTime -> ZonedDateTime:
 * ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId zone);
 *
 * @author RABBIT2002
 * @date 2020/12/27
 */
public class ZonedDateTimeClass {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);

        LocalDateTime localDateTime1 =zonedDateTime.toLocalDateTime();
    }
}

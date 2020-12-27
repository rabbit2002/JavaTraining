package datatime;

import java.time.ZoneId;
import java.util.Arrays;
import java.util.TimeZone;

/**
 * TimeZone 用于表示时区
 * <p>
 * // 返回 所有受支持的可用时区ID 的 String[]
 * TimeZone.getAvailableIDs();
 * // 返回当前操作系统默认时区
 * TimeZone.getDefault();
 * // 返回一个指定 时区ID 的 TimeZone实例
 * TimeZone.getTimeZone(String ID / ZoneId zoneId)
 * // 根据 地区 返回 时区名称
 * timeZone.getDisplayName([Locale locale]);
 * <p>
 * <p>
 * ZoneId 表示 时区编号
 * // 返回 所有受支持的 时区编号 组成的 Set<String>
 * ZoneId.getAvailableZoneIds();
 * // 返回当前操作系统默认时区编号
 * ZoneId.systemDefault();
 * // 获取 指定id 的 ZoneId实例
 * ZoneId.of(String zoneId)
 *
 * @author RABBIT2002
 * @date 2020/12/27
 */
public class TimeZoneClass {
    public static void main(String[] args) {
        TimeZone timeZone = TimeZone.getDefault();
        System.out.println(Arrays.toString(TimeZone.getAvailableIDs()));
        System.out.println(timeZone.getDisplayName());

        TimeZone timeZone1 = TimeZone.getTimeZone("Asia/Shanghai");
        System.out.println(timeZone1);
    }
}

class ZoneIdClass {
    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);
        ZoneId.getAvailableZoneIds();
    }
}

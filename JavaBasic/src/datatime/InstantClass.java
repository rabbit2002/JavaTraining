package datatime;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/**
 * java.time.Instant 用来表示 时间和日期 是JDK8中和 Date类 对等用于计算时间的类
 * 实现了 java.time.temporal.Temporal 接口
 * Instant类 是 final class 也是 immutable class
 * Instant实例 是 immutable object
 * <p>
 * 构造器
 * private Instant(long epochSecond, int nanos);
 * 类属性
 * public static final Instant EPOCH = new Instant(0, 0);
 * private static final long MIN_SECOND = -31557014167219200L;
 * private static final long MAX_SECOND = 31556889864403199L;
 * public static final Instant MIN = Instant.ofEpochSecond(MIN_SECOND, 0);
 * public static final Instant MAX = Instant.ofEpochSecond(MAX_SECOND, 999_999_999);
 * <p>
 * 实例属性
 * private final long seconds;
 * private final int nanos;
 * <p>
 * 类方法
 * public static Instant now();
 * // 根据 指定的 距离Epoch 的偏移秒[和纳秒]值 创建 Instant实例
 * public static Instant ofEpochSecond(long epochSecond[, long nanoAdjustment]);
 * // 根据 指定的 距离Epoch 的偏移毫秒值 创建 Instant实例
 * public static Instant ofEpochMilli(long epochMilli);
 * <p>
 * // 返回 Epoch到现在的毫秒数
 * System.currentTimeMillis();
 * // Returns the current value of the running Java Virtual Machine's high-resolution time source, in nanoseconds.
 * // This method can only be used to measure elapsed time and is not related to any other notion of system or wall-clock time.
 * // The value returned represents nanoseconds since some fixed but arbitrary origin time (perhaps in the future, so values may be negative).
 * // 返回一个任意但固定起点的高精度的纳秒时间值, 此方法只能用于测量经过时间, 与任何其他的系统或时钟时间概念无关
 * System.nanoTime();
 * <p>
 * java.time.Duration 类的 between 表示持续时间
 * public static Duration between(Temporal startInclusive, Temporal endExclusive); 可以计算两个 Temporal 之间的 间隔时间(duration)
 * <p>
 * <p>
 * Instant 与 Date 之间的转换:
 * Instant -> Date:
 * Date date = Date.from(instant);
 * Date -> Instant:
 * Instant instant= date.toInstant();
 *
 * @author RABBIT2002
 * @date 2020/12/27
 */
public class InstantClass {
    public static void main(String[] args) {
        Instant instant = null;
        Duration duration = Duration.between(instant, instant);

        Date date = null;
        Instant instant1 = date.toInstant();

    }
}

package datatime;

import java.util.Calendar;
import java.util.Date;

/**
 * java.util.Date 用来表示 日期和时间
 * <p>
 * 1. 历元: Greenwich mean time (GMT) midnight, January 1, 1970 UTC.
 * (格林威治标准时间 1970.01.01 00:00:00.0000 UTC)
 * 2. Java中的时间表示方式是 历元 到 现在 的时间偏移量 E.g.System.currentTimeMillis();
 * 3. 时间换算规则:
 * 1 hour = 60 minutes = 3,600(60*60) seconds
 * = 3,600,000(3,600*1000) milliseconds = 3,600,000,000(3,600,000*1000) nanoseconds
 * Date类中的 fastTime 实例属性 用于存储 时间(毫秒)
 * <p>
 * 尚未被废弃的实例方法:
 * 1. long getTime(); // 获取 Date实例 存储的 fastTime
 * 2. void setTime(long time); // 设置 Date实例 存储的 fastTime
 * 3. int hashCode(); // 通过 Date实例 存储的 fastTime 计算得出
 * 4. String toString(); // 打印 Date实例 存储的 fastTime 转换的时间(EEE MMM dd HH:mm:ss zzz yyyy)
 * 5. boolean before(Date when); // 判断 this.fastTime < when.fastTime 返回 true / false
 * 6. boolean after(Date when); // 判断 this.fastTime > when.fastTime 返回 true / false
 * 7. boolean equals(Object obj); // 判断 this.fastTime == obj.fastTime 返回 true / false
 * 8. int compareTo(Date anotherDate); // this.fastTime < / == / > anotherDate.fastTime 返回 -1 / 0 / 1
 * 9. Object clone();
 * 10. Instant toInstant(); (JDK1.8+)
 * <p>
 * 类方法:
 * static Date from(Instant instant) (JDK1.8+)
 *
 * @author RABBIT2002
 * @date 2020/12/25
 */
public class DateClass {
    public static void main(String[] args) {
        func2();
    }

    private static void func1() {
        // 获取当前时间
        System.currentTimeMillis();

        // 使用 当前时间 创建一个 Date实例
        Date date1 = new Date();
        // 使用 指定时间 创建一个 Date实例
        Date date2 = new Date(System.currentTimeMillis());

        System.out.println(date1);
    }

    private static void func2() {
        Date date = new Date();
        date.hashCode();
        date.toString();

        Date date1 = new Date(10000);
        Date date2 = new Date(20000);
        Date date3 = new Date(30000);

        System.out.println(date1.before(date2));
        System.out.println(date2.after(date1));
        System.out.println(date1.equals(date2));

        System.out.println(date2.compareTo(date1));
        System.out.println(date2.compareTo(date3));
    }
}

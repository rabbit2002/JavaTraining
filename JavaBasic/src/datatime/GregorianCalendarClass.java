package datatime;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Calendar 是一个 抽象类, 表示 日历
 * Calendar 有三个实现子类, 其中最常用的是 GregorianCalendar 类
 * 可以通过 Calendar.getInstance(); 返回当前地区所匹配的 Calendar实现类实例
 * <p>
 * Calendar类 内部通过字段储存日历数据
 * Calendar类 为特定时间与一组 日历字段 之间的转换提供了一些方法, 并为操作 日历字段 提供了一些方法
 * <p>
 * Calendar类 提供了 根据 Calendar实例 返回 java.util.Date类 的实例 的方法 public final Date getTime();
 * 步骤:
 * 1. 获取 Calendar实例
 * Calendar calendar = Calendar.getInstance();
 * 2. 清空 Calendar实例 中的所有 日历字段 数据
 * calendar.clear();
 * 3. 根据需要 设置 日历字段 的 值
 * calendar.set();
 * 4. 根据 Calendar实例 获取 Date实例
 * Date date =calendar.getTime();
 * <p>
 * 通过 Date实例 返回 Calendar实例的方法: public final void setTime(Date date);
 * 1. 获取 Date实例
 * Date date =new Date();
 * 2. 获取 Calendar实例
 * Calendar calendar = Calendar.getInstance();
 * 3. 清空 Calendar实例 中的所有 日历字段 数据
 * calendar.clear();
 * 4. 根据 Calendar实例 获取 Date实例
 * calendar.setTime(date);
 *
 * @author RABBIT2002
 * @date 2020/12/26
 */
public class GregorianCalendarClass {

    public static void main(String[] args) {
        func3();
    }

    private static void func1() {
        Calendar calendar = new GregorianCalendar();
        // 获取年份
        System.out.print(calendar.get(Calendar.YEAR) + ".");
        // 获取月份 0 - 11
        System.out.print(calendar.get(Calendar.MONTH) + ".");
        // 获取日期 Calendar.DATE 与 Calendar.DAY_OF_MONTH 均表示日期
        // System.out.print(calendar.get(Calendar.DATE) + " ");
        System.out.print(calendar.get(Calendar.DAY_OF_MONTH) + " ");

        // 获取小时 Calendar.HOUR 表示 12小时制, Calendar.HOUR_OF_DAY 表示24小时制
        // System.out.print(calendar.get(Calendar.HOUR) + " ");
        System.out.print(calendar.get(Calendar.HOUR_OF_DAY) + ":");

        // 获取分钟
        System.out.print(calendar.get(Calendar.MINUTE) + ":");
        // 获取秒钟
        System.out.print(calendar.get(Calendar.SECOND) + ".");
        // 获取毫秒
        System.out.print(calendar.get(Calendar.MILLISECOND));
    }

    private static void func2() {
        Calendar calendar = new GregorianCalendar();
        System.out.println(calendar);

        // 清除 calendar实例 中保存的 日历字段值
        calendar.clear();
        System.out.println(calendar);

        // 可以通过 set(); 方法设置新的 calendar 日历字段
        calendar.set(2000, 10, 10, 8, 30, 50);
        calendar.set(Calendar.MILLISECOND, 123);
        System.out.println(calendar);
    }

    private static void func3() {
        // 获取一个 Calendar实例 当做日历
        Calendar calendar = new GregorianCalendar();
        System.out.println(calendar.getTime());
        System.out.println(calendar.getTimeInMillis());

        // 根据需要设置 Calendar实例 的 日历字段 的值
        // 会修改储存的毫秒值
        calendar.set(Calendar.YEAR, 2000);
        calendar.set(Calendar.MONTH, 9);

        // 通过 Calendar实例 获取 date实例
        Date date = calendar.getTime();
        System.out.println(date);
        System.out.println(date.getTime());
    }
}

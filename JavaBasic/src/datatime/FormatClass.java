package datatime;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.text.Format 抽象类 文本格式化和解析器
 * 在构造时, 传入 参数 String pattern, 用于指定 格式化模式
 * <p>
 * java.text.DateFormat 抽象类
 * java.text.SimpleDateFormat 具体类
 * 具体格式化格式 参见API
 * public final String format(Date date)
 * public Date parse(String source) throws ParseException
 * // 将 字符串 解析为 Date实例 的时候, 传入的字符串要完全匹配 pattern参数
 * <p>
 * java.text.NumberFormat 抽象类
 * java.text.DecimalFormat 具体类
 * 具体格式化格式 参见API
 * format(long number) / format(double number) 可以将 数字 格式化 为 特定格式 的 字符串
 * public Number parse(String source) throws ParseException; 将 字符串 解析为 Number实例
 * <p>
 * java.text.MessageFormat 具体类 消息格式化
 *
 * @author RABBIT2002
 * @date 2020/12/28
 */
public class FormatClass {
    public static void main(String[] args) throws ParseException {
        func1();
        // func2();
    }

    private static void func1() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("G yyyy-MM-dd EEEE HH:mm:ss.SSS zzzz");
        Date date = new Date();
        System.out.println(simpleDateFormat.format(date));

        // String字符串 要完全匹配 pattern参数 设置的日期格式
        Date date1= simpleDateFormat.parse("公元 2020-12-28 星期一 21:34:23.402 中国标准时间");
        System.out.println(date1);
    }

    private static void func2() throws ParseException {
        DecimalFormat decimalFormat = new DecimalFormat("00000000");

        System.out.println(decimalFormat.format(123456));
        System.out.println(decimalFormat.format(123456.123));
        Number a = decimalFormat.parse("123.456");
        System.out.println(a);
    }
}

package chapter06_String;

import java.util.Scanner;

/**
 * 部分已迁移
 * // TODO 迁移
 * <p>
 * // TODO 还需后续学习JVM部分
 * 常量池：当字面量存在时，指向存在的字面量；当字面量不存在时，新建字面量，指向该字面量
 * // TODO 迁移
 * 由于常量池中会引用相同的内容，所以字面量可以用 "=" 或 equals()判断值是否相等
 * 常量池不会参与GC
 * 实例：当实例化新对象时，堆中创建该实例，并将栈中的引用类型指针(4B)指向该对象
 * 所以String实例只能用equals()判断值是否相等，"="判断其指针是否相同
 * 堆会参与GC，废弃的实例对象将被回收
 * <p>
 * <p>
 * // 判断内容是否相同
 * new String().equals(String anotherString);
 * // 忽略大小写判断内容是否相同
 * new String().equalsIgnoreCase(String anotherString)；
 * <p>
 * // 字符串第一次出现位置[the index to start the search from]
 * // int ch: Unicode code point
 * new String().indexOf(int ch[, int fromIndex]);
 * new String().indexOf(String str[, int fromIndex]);
 * <p>
 * // 字符串最后一次一次出现位置 [the index to start the search from]
 * // int ch: Unicode code point
 * new String().lastIndexOf(int ch[, int fromIndex]);
 * new String().lastIndexOf(String str[, int fromIndex]);
 * <p>
 * // 是否以该字符串开头 [where to begin looking in this string]
 * new String().startsWith(String prefix[, int toffset]);
 * <p>
 * // 是否以该字符串结尾 [where to begin looking in this string]
 * new String().endsWith(String suffix);
 * <p>
 * // 比较两个字符串大小
 * new String().compareTo(String anotherString)
 * // 全部转换为小写/大写
 * new String().toLowerCase();
 * new String().toUpperCase();
 * <p>
 * // 取出首位空格
 * new String().trim();
 * <p>
 * // 链接字符串 等同于 "+"
 * new String().concat(String str);
 * <p>
 * <p>
 * 字符串格式化
 * String.format(String format, Object... args)
 * %s String        %c Character        %b Boolean
 * %d Integer(DEC)  %x Integer(HEX)     %o Integer(OCT)     %f Float
 * // TODO 需要补充详细格式化案例
 * <p>
 * 基本类型与String互相转换
 * 需要调用基本类型的包装类型的转换方法，其中char调用的是String的方法
 * // TODO int在JVM内部应该是转换为Integer存储，需了解过程及内存分配，以及为何在栈中存储
 * // TODO 自动装箱与拆箱
 * boolean  Boolean.parseBoolean(String s)
 * byte     Byte.parseByte(String s[, int radix])
 * int      Integer.parseInt(CharSequence s[, int beginIndex, int endIndex, int radix])
 * long     Long.parseLong(CharSequence s[, int beginIndex, int endIndex, int radix])
 * float    Float.parseFloat(String s)
 * double   Double.parseDouble(String s)
 * chat     new String().charAt(int index)
 * String   String.valueOf(Object obj)
 * <p>
 * // TODO 需要了解 new String().intern();
 * // TODO 需要了解 i18n 的使用
 * // TODO Object... 方法可变参数
 * // TODO 优化修改Exercise
 *
 * @author RABBIT2002
 * @date 2020/12/1
 */

public class StringClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // for (int i = 0; i < 128; i++) {
        //     System.out.println(i + " " + (char)i);
        // }

        // true
        System.out.println(new String("abcdef").startsWith("bcd", 1));
        // true
        System.out.println(new String("abcdef").endsWith("def"));
        // abc
        System.out.println(new String(" abc ").trim());
        // 255
        System.out.println(String.format(new String("%d"), 0xFF));

        // Exercise 01
        new StringClass().exercise01(scanner.nextLine());
        // Exercise 02
        new StringClass().exercise02(scanner.nextLine());
        // Exercise 03
        new StringClass().exercise03(scanner.nextLine());
        // Exercise 04
        new StringClass().exercise04(scanner.nextLine());
        // Exercise 05
        new StringClass().exercise05("");
        // Exercise 06
        new StringClass().exercise06(scanner.nextLine());
        // Exercise 07
        new StringClass().exercise07(scanner.nextLine());

    }

    /**
     * 1.从键盘上输入任意个任意字母，统计元音字母a、e、i、o、u共出现多少次
     */
    public void exercise01(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                sum++;
            }
        }
        System.out.println("Exercise01: ");
        System.out.println("The sum of 'a/e/i/o/u' is: " + sum);

    }

    /**
     * 2.从键盘上输入一个用户名，验证用户名是否合法并输出，合法的用户名是
     * 2.1.长度在6-20位之间
     * 2.2.必须以大写字母开头
     * 2.3.必须包含数字、下划线
     */
    public void exercise02(String s) {
        System.out.println("Exercise02: ");
        if (s.length() < 6 || s.length() > 20) {
            System.out.println("The string is too long or too short");
            return;
        }
        if (!(s.charAt(0) >= 65 && s.charAt(0) <= 90)) {
            System.out.println("The string is needed capital letters to beginning");
            return;
        }
        boolean flagNumber = false;
        boolean flagUnderline = false;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == 95) {
                flagUnderline = true;
            }
            if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                flagNumber = true;
            }
        }
        if (flagNumber && flagUnderline) {
            System.out.println("The string is legal");
            return;
        }
        System.out.println("The string is illegal");
    }

    /**
     * 3.从键盘上输入若干汉字和英文字母组合，统计汉字的个数和英文字母的个数分别是多少。
     * 提示:汉字的unicode编码在\u4e00与\u9fa5之间
     */
    public void exercise03(String s) {
        System.out.println("Exercise03: ");
        int sumChinese = 0;
        int sumEnglish = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90 || s.charAt(i) >= 97 && s.charAt(i) <= 122) {
                sumEnglish++;
            }
            if (s.charAt(i) >= Integer.parseInt("4e00", 16) && s.charAt(i) <= Integer.parseInt("9fa5", 16)) {
                sumChinese++;
            }
        }
        System.out.println("English: " + sumEnglish);
        System.out.println("Chinese: " + sumChinese);
    }

    /**
     * 4.检测用户输入的单词是否是回文单词。
     * 所谓回文单词指单词倒过来与原单词一样，
     * 比如 "level" "pop" "noon" 都是回文单词。
     */
    public void exercise04(String s) {
        System.out.println("Exercise04: ");
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                System.out.println("The word is not needed");
                return;
            }
        }
        System.out.println("The word is needed");
    }

    /**
     * 5.有如下一段文字
     * "天气太hot,食物都放坏了，我昨天就吃了一个坏蛋黄派，真是 Stupid啊，怎么能这么Stupid呢？"。
     * 编写程序将这段文字中的脏字"笨蛋"，"坏蛋"，"Stupid"用"****"替换。
     */
    public void exercise05(String s) {
        System.out.println("Exercise05: ");
        s = "天气太hot,食物都放坏了，我昨天就吃了一个坏蛋黄派，真是Stupid啊，怎么能这么Stupid呢？";
        String str = "笨蛋,坏蛋,Stupid";
        String replaceStr = "****";

        s = s.toLowerCase();
        str = str.toLowerCase();
        String[] strArr = str.split(",");

        for (int i = 0; i < strArr.length; i++) {
            String temp = "";
            String[] tempArr = s.split(strArr[i]);
            for (int j = 0; j < tempArr.length; j++) {
                temp += tempArr[j];
                if (j < tempArr.length - 1) {
                    temp += replaceStr;
                }
            }
            s = temp;
        }
        System.out.println(s);
    }

    /**
     * 6.编写一个函数实现字符串倒置,用键盘输入一个字符串，调用函数输出结果。例如输入:"ABCDEFG"输出"GFEDCBA"
     */
    public void exercise06(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            System.out.print(s.charAt(i));
        }
        System.out.println();
    }

    /**
     * 7.编写一个求字符串长度的函数。完成字符串中length()的功能。
     */
    public void exercise07(String s) {
        System.out.println(s.toCharArray().length);
    }
}

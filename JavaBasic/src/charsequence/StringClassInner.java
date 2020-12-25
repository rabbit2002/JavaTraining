package charsequence;

import charsequence.util.StringHelper;

import java.util.Arrays;

/**
 * String 属于 不可变类:
 * 1. 类不可继承 2. 属性不可修改 3. 不提供实例变量的 setter方法
 * <p>
 * 在 JDK9 中, String类 的主要内部属性有以下三个:
 * 1. private final byte[] value;
 * 2. private final byte coder;
 * 3. private int hash; // Default to 0
 * <p>
 * 1. 因为 String的不可变性,
 * 所以在 通过字面量 创建新的 String实例 (new String("...")) 的过程中, 如果在常量池中已经存在该字面量,
 * 则新的 String实例 中的实例属性, 会拷贝自相同 字面量实例 中储存的值, 即 共享同一个 byte[]
 * (对于字面量的创建可以参照: 字面量存放规则)
 * 2. coder用于指定编码格式为 LATIN1 / UTF16
 * 3. hashCode初始化为 0, 并将在首次调用计算hashCode时自动计算生成,
 * 又因为该属性没有提供 Setter方法, 也属于不可变类的属性
 * <p>
 * 注意: 因为 String的不可变性, 相同内容的 String实例 只是共用一个 byte[] 地址, 存储字节序列
 * 但 String实例 本身并不相同
 * <p>
 * <p>
 * intern()方法: 返回字符串对象的规范表示形式
 * (Returns a canonical representation for the string object.)
 * <p>
 * 作用: 当调用 intern方法 时, 如果池中已经包含了 equals(object) 方法确定的与此字符串对象相等的字符串,
 * 则返回池中的字符串. 否则, 将该字符串对象添加到池中, 并返回对该字符串对象的引用
 * (When the intern method is invoked, if the pool already contains a
 * string equal to this {@code String} object as determined by
 * the {@link #equals(Object)} method, then the string from the pool is
 * returned. Otherwise, this {@code String} object is added to the
 * pool and a reference to this {@code String} object is returned.)
 * <p>
 * 返回: 与此字符串具有相同内容的字符串, 但保证来自唯一字符串池
 * (a string that has the same contents as this string,
 * but is guaranteed to be from a pool of unique strings.)
 * 即: 没有则添加到池, 并返回池中的实例, 有则直接返回池中的实例
 *
 * @author RABBIT2002
 * @date 2020/12/25
 */
public class StringClassInner {
    public static void main(String[] args) {
        func3();
        func4();
    }

    private static void func1() {
        String t = "hello";
        StringHelper.analysis(t);

        t.hashCode();// 首次调用hashCode()
        StringHelper.analysis(t);

        t.hashCode();// 再次调用hashCode()
        StringHelper.analysis(t);

        System.out.println("- - - - - - - - - - - - - - - - - - - -");

        String s = new String("hello");
        StringHelper.analysis(s);

        System.out.println("- - - - - - - - - - - - - - - - - - - -");

        String x = new String(t);
        StringHelper.analysis(x);
    }

    private static void func2() {
        String t = "hello";
        t.hashCode(); // 首次调用 hashCode方法导致 String实例 的 hash 变量被初始化
        String s = new String("hello");
        String x = new String(t);

        System.out.println(t == s);
        System.out.println(t == x);
        System.out.println(x == s);

        System.out.println("- - - - - - - - - - - - - - - - - - - -");

        StringHelper.analysis(t);
        StringHelper.analysis(s);
        StringHelper.analysis(x);

        System.out.println("- - - - - - - - - - - - - - - - - - - -");

        System.out.println("t : " + t);
        System.out.println("s : " + s);
        System.out.println("x : " + x);

        System.out.println("- - - - - - - - - - - - - - - - - - - -");

        StringHelper.set(t, 1, (byte)65);

        System.out.println("t : " + t);
        System.out.println("s : " + s);
        System.out.println("x : " + x);
    }

    private static void func3() {
        char[] chars = {'青', '海', '长', '云', '暗', '雪', '山'};
        // System.out.println(Arrays.toString(chars));

        // 使用 char 数组中的所有字符构造新的 String实例
        String s = new String(chars);
        // System.out.println(s);

        StringHelper.analysis(s);

        // 调用 s 的 intern 方法时，String常量池 中并没有相应 String实例
        // 所以 就将 当前的 String实例 添加到 String常量池 并返回该实例的地址
        String x = s.intern();

        StringHelper.analysis(x);

        // 尝试从 String常量池 中获取 字符序列 对应的 String实例
        // 因为 String常量池 中已经存在相应的 String实例，所以直接返回相应的 String实例
        String t = "青海长云暗雪山";

        StringHelper.analysis(t);

        System.out.println(s == t); // true
        System.out.println(s == x); // true
        System.out.println(t == x); // true
    }

    private static void func4() {
        char[] chars = {'青', '海', '长', '云', '暗', '雪', '山'};
        // System.out.println(Arrays.toString(chars));

        // 使用 char 数组中的所有字符构造新的 String实例
        String s = new String(chars); // byte[] value / byte coder / int hash
        // System.out.println(s);

        StringHelper.analysis(s);

        // 尝试从 String常量池 中获取 字符序列 对应的 String实例
        // 因为未找到相应的 String实例，所以需要 创建新的String实例并添加到String常量池后再返回其地址
        String t = "青海长云暗雪山";

        StringHelper.analysis(t);

        // 调用 s 的 intern 方法时，String常量池 中已经存在相应 String实例
        // 因此 s.intern() 返回了 String常量池 中已经存在的 String实例 的地址，而不是返回 s 实例地址
        String x = s.intern();

        StringHelper.analysis(x);

        System.out.println(s == t); // false
        System.out.println(s == x); // false
        System.out.println(t == x); // true
    }

}
